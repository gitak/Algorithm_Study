package Graph;

import java.io.*;
import java.util.*;

public class Back1916 {

    //노드와 그 노드까지 가는 거리를 담을 클래스
    static class Edge implements Comparable<Edge>{
        private int v;
        private int weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static final int INF = 100000*1000;
    static List<Edge>[] adjlist;
    static int[] result;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        //배열 선언
        result = new int[v + 1];
        check = new boolean[v + 1];
        adjlist = new ArrayList[v + 1];

        //인접리스트 인덱스별 선언
        for (int i = 1; i <= v; i++) {
            adjlist[i] = new ArrayList<>();
        }

        //모든 거리를 INF로 초기화
        Arrays.fill(result,INF);

        //인접리스트 초기화
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjlist[v1].add(new Edge(v2, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        bw.write(result[end] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        result[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            //방문한 노드 건너뛰기
            if (check[edge.v]) {
                continue;
            }

            check[edge.v] = true;
            //방문안한 노드와 연결된 노드 확인
            for (Edge next : adjlist[edge.v]) {
                //다른 노드 거쳐서 가는 경우가 더 짧은 경우 최소거리 갱신
                if (result[next.v] >= result[edge.v] + next.weight) {
                    result[next.v] = next.weight + result[edge.v];
                    pq.offer(new Edge(next.v, result[next.v]));
                }
            }

        }

    }
}
