package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back1240 {

    static class Edge {
        private int vertex;
        private int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int ans;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Edge>[] adj;
    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    //풀이 1. 트리도 일종의 그래프이므로 최단거리 알고리즘인 Dijkstra 사용
    //풀이 2. 트리에서 두 노드 사이의 경로는 유일한 점을 활용해서 BFS 사용
    //풀이 3. 트리를 Rooted 트리로 변환해서 구현이 짧은 DFS를 통해 거리 계산하기.
    //    마찬가지로 두 노드 사이의 경로가 유일함을 확인한다.
    private static void logic() throws IOException {
        while (M-- > 0) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            DFS(v1, -1, v2, 0);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    // 현재 노드는 x 이고, 부모 노드는 prev 이며, 목표 지점은 goal,
    // 그리고 root부터 지금까지 이동 거리가 dist 이다.
    static void DFS(int x, int prev, int goal, int dist) {
        if (x == goal) {
            ans = dist;
            return;
        }

        for (Edge edge : adj[x]) {
            if(edge.vertex == prev) continue;
            DFS(edge.vertex, x,goal,dist + edge.weight);
        }
    }

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[v1].add(new Edge(v2, weight));
            adj[v2].add(new Edge(v1, weight));
        }
    }
}
