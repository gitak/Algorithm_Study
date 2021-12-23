package Sort;

import java.util.*;
public class Menu {
    static List<String> comb;

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        solution(orders,course);

        return;
    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        comb = new ArrayList<>();
        //Logic
        //1.orders[i]마다 모든 조합 구하기
        for(int i = 0; i < orders.length;i++){
            char[] orders_char = orders[i].toCharArray();
            //orders[i]의 문자열안의 문자들을 오름차순 정렬(알파벳순 정렬)
            Arrays.sort(orders_char);

            for (int index = 0; index < orders_char.length - 1; index++) {  // orders[i]의 문자열에서 차례대로 한글자씩 선택
                for (int j = 0; j < course.length; j++) {   // course 에 있는 모든 경우
                    //course에 있는 값과 같을때 까지 dfs를 이용
                    //course의 값과 같을 때 해당조합을 list에 넣기
                    dfs(orders_char, index, 1, course[j], String.valueOf(orders_char[index]));
                }
            }
        }

        HashMap<String, Integer> hashMap = new HashMap<>();

        //HashMap에서 동일 key값을 추가하는 경우 value값을 1씩 증가
        //hashMap.getOrDefault()-> 동일 key값을 추가하는 경우 value값을 덮어쓰기 할 때 사용하는 메서드
        for(String key : comb){
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }

        //hashMap에 있는 모든 키값들을 ketSetList에 담기
        //streamAPI ->keySetList에 저장된 값을 받아와서 해당 key값의 value값을 기준으로 ketSetList를 내림차순 정렬
        List<String> keySetList = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (hashMap.get(o2).compareTo(hashMap.get(o1))));

        //정답을 담을 arrayList 변수
        List<String> answerList = new ArrayList<>();

        for(int i = 0; i < course.length; i++){
            int max = 0;

            for(String key : keySetList){
                //해당 key의 value값이 2보다 크면서 course에 저장된 값과 같은 경우
                //이때 keySetList에는 문자열의 길이가 내림차순으로 정렬되어 있으므로 같은 길이인 경우 가장 긴 길이가 answerList의 저장
                if(hashMap.get(key) >= 2 && key.length() == course[i]){
                    if(hashMap.get(key) >= max){
                        answerList.add(key);
                        max = hashMap.get(key);
                    }
                }
            }
        }

        Collections.sort(answerList);
        answer= new String[answerList.size()];
        //answerList에 저장된 값을 answer에 복사
        answerList.toArray(answer);

        for(String str : answer){
            System.out.println(str);
        }
        return answer;
    }

    //orders_char배열에 있는 문자들의 조합 중 course에 있는 값과 같은 조합을 구하기 위한 메서드
    public static void dfs(char[] orders_char, int idx, int length, int course, String str) {
        if (length == course) {    // 문자열의 길이가 course에 있는 값과 같은 경우 경우의 수 추가
            comb.add(str);
        }

        for (int i = idx + 1; i < orders_char.length; i++) {
            dfs(orders_char, i, length + 1, course, str + orders_char[i]);
        }
    }
}
