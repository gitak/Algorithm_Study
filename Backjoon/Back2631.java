package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2631 {
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n]; //아이들의 번호를 저장할 배열
        int[] dp = new int[n];
        int max = 0; //최장길이 수열을 저장할 변수

        //아이의 순서 입력
        for(int i = 0; i < n; i++){
            line[i] = Integer.parseInt(br.readLine());
        }
        br.close();//입력 종료

        //Logic
        //최장 길이 수열(LIS)

        dp[0] = 1; //처음위치 1로 초기화 -> 자기 자신도 세야한다.
        //길이를 2부터 n까지 늘려가면서 최장수열 갱신
        for(int i = 1; i < n; i++){
            dp[i] = 1;// 자신도 포함시켜야 되기 때문에 1로 초기화
            for(int j = 0; j < i; j++){
                //뒤쪽의 번호가 더 큰 경우
                if(line[i] > line[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
                max = Math.max(max, dp[i]);
            }
        }
        System.out.println(n - max);
    }
}
