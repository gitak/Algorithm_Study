package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back9461 {
    static long[] dp = new long[101]; //파도반 수열의 값을 저장할 배열
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        //파도반 수열의 배열 초기화
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        //파도반 수열의 값을 dp를 이용하여 검색
        padovane();
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
                System.out.println(dp[n]);
        }
        br.close(); //입력 종료
    }

    //Logic
    public static void padovane(){
        for(int i = 4; i <= 100; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }
        return ;
    }
}
