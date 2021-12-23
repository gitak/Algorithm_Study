package Implementation;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        for(String answer : solution(record))
            System.out.println(answer);
    }

    public static String[] solution(String[] record) {
        String[] answer;

        //key값을 id, value값을 닉네임으로 저장할 hashMap
        HashMap<String, String> hashMap = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Change")){ // 닉네임 변경을 원하는 경우
                hashMap.put(temp[1], temp[2]);
            }
            else if(temp[0].equals("Enter")){ // 만약 나갔다가 들어온 경우 자동으로 닉네임 갱신
                hashMap.put(temp[1], temp[2]);
            }
        }

        ArrayList<String> answerList = new ArrayList<>();

        for(int i = 0 ; i < record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Enter")){
                answerList.add(hashMap.get(temp[1]) + "님이 들어왔습니다.") ;
            }
            else if(temp[0].equals("Leave")){
                answerList.add(hashMap.get(temp[1]) + "님이 나갔습니다.");
            }
        }

        answer = new String[answerList.size()];
        answerList.toArray(answer);

        return answer;
    }
}
