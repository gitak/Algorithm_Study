package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back15681_New {
    static BufferedReader br;
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
    }

    //이전 방문노드인 prev를 제외했을 때, x를 root노드로 한 subtree의 개수
    private static void dfs(int x, int prev) {
       dp[x] = 1;
        for (int y : tree[x]) {
            if(y == prev)continue;
            dfs(y, x);
            dp[x] += dp[y];
        }
    }

    private static void logic() throws IOException {
        StringBuilder sb = new StringBuilder();
        dp = new int[N + 1];
        dfs(R, -1);

        for (int i = 1; i <= Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(dp[q]).append('\n');
        }
        System.out.println(sb);
    }
}
