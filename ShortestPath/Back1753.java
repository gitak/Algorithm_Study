package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1753 {

    static class Edge implements Comparable<Edge>{
        private int vertex;
        private int distance;

        public Edge(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
    static int V, E, K;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();

        for (int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else{
                sb.append(dist[i]).append('\n');
            }
        }

        System.out.println(sb.toString());

    }

    private static void dijkstra() {
        //Todo 1. 모든 정점까지에 대한 거리를 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        //Todo 2. 최소 힙 생성
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //Todo 3. 시작점에 대한 정보를 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        pq.add(new Edge(K, 0));
        dist[K] = 0;

        //Todo 4. 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            // 꺼낸 edge의 거리가 dist[edge]보다 크다면 갱신할 필요가 없으므로 폐기한다.
            if(edge.distance > dist[edge.vertex]) continue;

            for (Edge nextEdge : edges[edge.vertex]) {

                if (nextEdge.distance + dist[edge.vertex] < dist[nextEdge.vertex]) {
                    dist[nextEdge.vertex] = nextEdge.distance + dist[edge.vertex];
                    pq.add(new Edge(nextEdge.vertex, dist[nextEdge.vertex]));
                }
            }

        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        edges = new ArrayList[V + 1];

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
        }
    }
}
