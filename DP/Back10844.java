package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back10844 {
    static long[][] dp;
    static int n;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close(); //입력종료

        dp = new long[n + 1][10];

        //첫번째 자릿수 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1l;
        }

        long sum = 0;

        //길이가 n인 경우 가장 높은 자릿수에 올 수 있는 모든 경우의 수
        for(int i = 1; i < 10; i++){
            sum += NumberOfSteps(n,i);
        }

        System.out.println(sum % MOD);
    }

    //top-down 방식 - 재귀호출(추상화 -> 구체적인 값)
    static long NumberOfSteps(int digit, int val) {

        //자릿수가 1인 경우
        if(digit == 1) {
            return dp[digit][val];
        }

        //값이 초기화가 되지 않은 경우
        if(dp[digit][val] == 0)  {
            // 0 뒤에는 1만 올 수 있다.
            if (val == 0) {
                dp[digit][val] = NumberOfSteps(digit - 1, 1);
            }
            // 9 뒤에는 8만 올 수 있다.
            else if (val == 9) {
                dp[digit][val] = NumberOfSteps(digit - 1, 8);
            }
            // 그 외의 경우는 val-1과 val+1 값의 경우의 수를 합한 경우의 수가 됨
            else {
                dp[digit][val] = NumberOfSteps(digit - 1, val - 1) + NumberOfSteps(digit - 1, val + 1);
            }
        }

        return dp[digit][val] % MOD;
    }
}
