package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back15681 {

    static StringBuilder sb = new StringBuilder();
    static int N, R, Q;
    static ArrayList<Integer>[] connected_graph;
    static int[] query, subTree;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        connected_graph = new ArrayList[N + 1];
        query = new int[Q];
        for (int i = 1; i <= N; i++) {
            connected_graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            connected_graph[v1].add(v2);
            connected_graph[v2].add(v1);
        }

        for (int i = 0; i < Q; i++) {
            query[i] = Integer.parseInt(br.readLine());
        }
    }

    static void dfs(int x, int prev) {
        subTree[x] = 1;
        //subTree[x]의 개수는 connected_graph[x]에 연결된 subTree의 합과 같다.
        for (int y : connected_graph[x]) {
            if(y == prev) continue;
            dfs(y, x);
            subTree[x] += subTree[y];
        }
    }

    static void logic() {
        subTree = new int[N + 1];
        dfs(R, -1);

        for (int i = 0; i < Q; i++) {
            sb.append(subTree[query[i]]).append('\n');
        }
        System.out.println(sb);
    }
}
