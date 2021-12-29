package DFS;

import java.util.*;

public class  BadUser {
    private static Set<Set<String>> result;

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        System.out.println(solution(user_id, banned_id));

    }

    public static int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>(); //result 초기화
//        Set<String> set = new LinkedHashSet<>();
//        dfs(user_id, banned_id, set);
        dfs(user_id,banned_id, new HashSet<>());
        return result.size();
    }

    //set의 크기가 banned_id의 길이와 같을 때까지 set에 문자열을 추가하는 메서드
    static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
        if (set.size() == banned_id.length) {
            //set에 있는 문자열들이 banned_id에 있는 문자열과 같다면 set에 추가
            if (isBannedUsers(set, banned_id)) {
                result.add(new HashSet<>(set));
            }

            return;
        }

        //user_id에 있는 문자열들이 set에 없다면 추가
        for (String userId : user_id) {
            if (!set.contains(userId)) {
                set.add(userId);
                dfs(user_id, banned_id, set);
                //set 초기화
                set.remove(userId);
            }
        }
    }

    //set에 있는 믄자열이 banned_id에 있는 문자열을 포함하고 있는지 확인하는 메서드
    static boolean isBannedUsers(Set<String> set, String[] banned_id) {
        int i = 0;

        //set에 있는 문자열들을 for-each를 통해 하나씩 꺼낸다.
        for (String user : set) {
            if (!isSameString(user, banned_id[i++])) {
                return false;
            }
        }

        return true;
    }

    //user_id에 있는 문자열과 banned_id에 있는 문자열을 전부 포함하고 있는지 확인하는 메서드
    static boolean isSameString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*') continue;

            if (a.charAt(i) != b.charAt(i))
                return false;
        }

        return true;
    }
}