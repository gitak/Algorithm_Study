package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Failure_rate {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //스테이지의 수
        //입력 종료

        int[] answer = new int[N];
        double [] fail = new double[N]; //실패율을 저장할 배열
        int[] user = new int[N]; // 해당 스테이지에 도전중인 사람의 수를 저장할 배열
        int count = 0; //남은 사용자

        //Logic
        //answer배열 초기화
        for(int i = 0; i< N; i++){
            answer[i] = i + 1;
        }
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        //user 배열 초기화
        for(int i = 0; i < stages.length; i++){
            if(stages[i] == N+1){
                continue;
            }
            user[stages[i]-1]++;
        }

        for(int i = 0; i < user.length; i++){
            fail[i] = (double) user[i] / (stages.length - count);
            count += user[i];
        }

        //fail 배열 내림차순 정렬 && answer도 배열
        for(int i = fail.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(fail[j] < fail[j+1]){
                    double temp = fail[j];
                    fail[j] = fail[j+1];
                    fail[j+1] = temp;

                    int x = answer[j];
                    answer[j]  = answer[j+1];
                    answer[j+1] = x;
                }
            }
        }

//        for(int i = 0; i < fail.length; i++){
//
//            System.out.println(fail[i]);
//        }
//
//        for(int i = 0; i < answer.length; i++){
//
//            System.out.println(answer[i]);
//        }

    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double [] fail = new double[N]; //실패율을 저장할 배열
        int[] user = new int[N]; // 해당 스테이지에 도전중인 사람의 수를 저장할 배열
        int count = 0; //남은 사용자

        //answer배열 초기화
        for(int i = 0; i< N; i++){
            answer[i] = i + 1;
        }
        //user 배열 초기화
        for(int i = 0; i < stages.length; i++){
            //모든 스테이지를 클리어한 경우
            if(stages[i] == N+1){
                continue;
            }
            user[stages[i]-1]++;
        }

        //fail 배열 초기화
        for(int i = 0; i < user.length; i++){
            fail[i] = (double) user[i] / (stages.length - count);
            count += user[i];
        }

        //fail 배열 내림차순 정렬 && answer에 저장되어 있는 stage번호도 옮기기
        for(int i = fail.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(fail[j] < fail[j+1]){
                    double temp = fail[j];
                    fail[j] = fail[j+1];
                    fail[j+1] = temp;

                    int x = answer[j];
                    answer[j]  = answer[j+1];
                    answer[j+1] = x;
                }
            }
        }
        return answer;
    }
}
