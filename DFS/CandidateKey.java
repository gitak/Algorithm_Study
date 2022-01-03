package DFS;

import java.io.IOException;
import java.util.*;

public class CandidateKey {
    static List<String> candidate = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},
                {"300","tube","computer","3"},{"400","con","computer","4"},
                {"500","muzi","music","3"}, {"600","apeach","music","2"}};

        System.out.println(solution(relation));
    }

    public static int solution(String[][] relation) {
        int answer = 0;

        //1부터 칼럼의 길이만큼 dfs를 하여 후보키로 가능한 요소 찾기
        for(int i = 0 ; i < relation[0].length; i++){
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, 0, i + 1, relation);
        }
        answer = candidate.size();
        return answer;
    }

    public static void dfs(boolean[] visited, int start, int depth, int end, String[][] relation){
        if(depth == end){
            List<Integer> list = new ArrayList<>();
            String key = "";

            //뽑힌 경우의 수를 list에 추가 & key에 저장
            //1 2 4 중 길이가 1인 경우의 수는 1 2 4 가 있다.
            for(int i = 0; i < relation[0].length; i++){
                if(visited[i]){
                    key += String.valueOf(i);
                    list.add(i);
                }
            }

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < relation.length; i++){
                String s = "";
                //relation에서 해당 column의 속성을 s에 추가
                for(Integer j : list){
                    s += relation[i][j];
                }

                //해당 칼럼의 속성이 중복되는 경우 종료
                if(map.containsKey(s)){
                    return;
                }
                else{
                    map.put(s,0);
                }
            }

            //후보키 추가
            for(String s : candidate){
                int count = 0;

                //최소성 확인 (비트마스킹과 같은 역할)
                for(int i = 0; i < key.length(); i++){
                    String subS = String.valueOf(key.charAt(i));
                    //key의 요소들을 후보키들에 존재하는지 확인
                   if(s.contains(subS)) count++;
                }

                //후보키와 key의 문자열과 비교하여 같은 속성이 후보키와 같다면 후보키로 추가할 수 없다.
                if(count == s.length()) return;
            }

            //길이가 1인 경우 후보키에 바로 추가
            candidate.add(key);

            return;
        }

        //depth == end가 될때 까지 dfs로 탐색
        // -> 길이가 1부터 relation[0].length()까지 모든 경우의 수 구하기
        for(int i = start; i < relation[0].length; i++){
            if(visited[i]) continue;

            visited[i] = true;
            dfs(visited, i, depth + 1, end, relation);
            visited[i] = false;
        }

    }
}
