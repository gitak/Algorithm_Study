package Implementation;

import java.util.ArrayList;
import java.util.HashMap;

public class Compression {
    public static void main(String[] args) {
        String msg = "KAKAO";
        solution(msg);
    }

    public static int[] solution(String msg) {
        //압축값을 저장할 리스트
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        //1. A~Z까지 사전에 넣기
        for (int i = 0; i < 26; i++) {
            char word= (char)('A' + i);
            hashMap.put(String.valueOf(word), i+1);
        }

        int last_index = 26;
        //문자열의 끝에 도달했는지 확인하는 변수
        boolean isFinished = false;

        for (int i = 0; i < msg.length();) {
            String word = msg.charAt(i) + "";

            //2. 사전에 가장 긴 문자열 찾기
            while (hashMap.containsKey(word)) {
                i++;

                //문자열의 끝에 도달한 경우
                if (i == msg.length()) {
                    isFinished = true;
                    break;
                }
                //단어하나씩 늘리기
                word += msg.charAt(i);
            }

            //문자열 끝에 도달했을 때 예외처리
            if (isFinished) {
                list.add(hashMap.get(word));
                break;
            }

            //3. 가장 긴 문자열(w)에 해당하는 색인번호 출력
            list.add(hashMap.get(word.substring(0,word.length()-1)));

            //4. 입력에서 처리되지 않은 글자(c)에 대해, w+c 해당하는 단어 사전에 입력
            hashMap.put(word, ++last_index);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
