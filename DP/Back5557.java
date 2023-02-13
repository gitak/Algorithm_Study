package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back5557 {
    static int N;
    static int[] number;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void logic() {
        dp = new long[N + 1][21];

        //초기값 구하기
        dp[1][number[1]] = 1;

        //점화식을 토대로 dp배열 채우기
        for (int i = 2; i <= N - 1; i++) {
            for (int prev = 0; prev <= 20; prev++) {
                for (int cur : new int[]{prev - number[i], prev + number[i]}) {
                    if(cur < 0 || cur > 20) continue;
                    //i - 1번째 저장된 prev의 경우의 수가 있는 경우
                    if (dp[i - 1][prev] != 0) {
                        dp[i][cur] += dp[i - 1][prev];
                    }

                }
            }
        }

        System.out.println(dp[N - 1][number[N]]);
    }
}
