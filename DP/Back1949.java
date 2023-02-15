package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back1949 {

    static int N;
    static int[] town;
    static ArrayList<Integer>[] con;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        town = new int[N + 1];
        con = new ArrayList[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            town[i] = Integer.parseInt(st.nextToken());
            con[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            con[x].add(y);
            con[y].add(x);
        }
    }

    static void dfs(int x, int prev) {
        dp[x][1] = town[x];
        for (int y : con[x]) {
            if(y == prev) continue;
            dfs(y, x);
            //x 를 선택한 경우와 선택하지 않는 경우 각각 점화식
            dp[x][0] += Math.max(dp[y][0], dp[y][1]);
            dp[x][1] += dp[y][0];
        }
    }

    static void logic() {
        // dp[i][j] -> i는 마을 번호, j는 우수마을로 선정됐는지 여부
        dp = new int[N + 1][2];
        dfs(1, -1);

        System.out.println(Math.max(dp[1][1], dp[1][0]));
    }
}
