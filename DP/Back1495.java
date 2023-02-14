package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1495 {
    static int N, S, M;
    static int[] volume;
    static boolean[][] dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        volume = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void logic() {
        dp = new boolean[N + 1][M + 1];

        //초기값 구하기
        dp[0][S] = true;

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            boolean isPossible = false;
            ans = 0;
            for (int prev = 0; prev <= M; prev++) {
                if(!dp[i - 1][prev]) continue;
                for (int cur : new int[]{prev - volume[i], prev + volume[i]}) {
                    if(cur < 0 || cur > M) continue;
                    ans = Math.max(cur, ans);
                    dp[i][cur] = true;
                    isPossible = true;
                }
            }

            if (!isPossible) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }
}
