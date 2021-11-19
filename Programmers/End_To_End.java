package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class End_To_End {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //참여하는 사람의 수
        br.close();//입력 종료

        //Logic
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] arr = solution(n, words);
        System.out.println(arr[0] +" "+arr[1]);
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> checklist = new ArrayList<>(); // 번호 순으로 말한 단어를 저장하기 위한 ArrayList
        int count = 1; // 몇번재 라운드인지 확인하기 위한 변수
        //checklist 초기화
        checklist.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if ( i % n == 0) {
                count++;
            }
            //checklist에 없고 이전 값의 마지막 문자가 해당 문자열의 첫번째 문자와 같은 경우
            if (!checklist.contains(words[i]) && words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)) {
                checklist.add(words[i]);
                continue;
            }

            //index가 n의 배수인 경우
            if((i+1) % n == 0){
                answer[0] = n;
                answer[1] = count;
            }
            else{
                answer[0] = (i+1) % n;
                answer[1] = count;
            }
            break;
        }
        return answer;
    }
}
