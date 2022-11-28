package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back15900 {

    static int N;
    static ArrayList<Integer>[] adj;
    static int sum_leaf_depth;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        dfs(1, -1, 0);
        if (sum_leaf_depth % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    // 트리를 순회하면서 sum_leaf_depth 계산
    static void dfs(int x, int prev, int depth) {
        if(x != 1 && adj[x].size() == 1) sum_leaf_depth += depth;

        for (int y : adj[x]) {
            if(y ==prev) continue;
            dfs(y, x, depth + 1);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sum_leaf_depth = 0;
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
    }
}
