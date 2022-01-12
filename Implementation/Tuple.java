package Implementation;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        solution(s);
    }

    public static int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();

        //특수문자를 구분할 때 \\를 특수문자 앞에 삽입
        String[] temp = s.split(",|\\{|\\}");

        //hashMap에 key값을 temp에 있는 문자열로 value값을 해당 문자열이 나온 횟수로 넣기
        for(int i = 0; i < temp.length; i++){
            if(temp[i].equals("")) continue;
            map.put(temp[i], map.getOrDefault(temp[i], 0) + 1);
        }

        //hashMap의 key값과 value값을 하나의 entry로 하는 Linkedlist생성
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        //value(해당 문자열이 나온 횟수)값을 기준으로 entryList내림차순 정렬
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        //answer 배열에 entryList의 key값을 정수타입으로 바꾼 후 복사
        int[] answer = new int[entryList.size()];
        int count = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            answer[count] = Integer.valueOf(entry.getKey());
//            System.out.println(answer[count]);
            count++;
        }
        return answer;
    }
}
