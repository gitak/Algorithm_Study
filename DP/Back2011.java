package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2011 {
    static int N, MOD = 1000000;
    static String str;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str= br.readLine();
        N = str.length();
    }

    //'AB'라는 두 자리 숫자가 하나의 수로 해독이 가능한지 확인하는 메서드
    static boolean check(char A, char B) {
        if(A == '0') return false;
        if(A == '1') return true;
        if(A >= '3') return false;
        return B <= '6';
    }

    static void logic() {
        dp = new int[N];

        //초기값 구하기
        if(str.charAt(0) != '0') dp[0] = 1;

        //점화식을 토대로 dp 배열 채우기
        for (int i = 1; i < N; i++) {
            //i번 숫자를 단독으로 해석 가능할 때
            if(str.charAt(i) != '0') dp[i] = dp[i - 1];

            //i-1 번과 i 번 숫자를 하나의 문자로 해석 가능할 때
            if (check(str.charAt(i - 1), str.charAt(i))) {
                if(i >= 2) dp[i] += dp[i - 2];
                else dp[i] += 1;

                dp[i] %= MOD;
            }

        }

        System.out.println(dp[N - 1]);
    }
}
