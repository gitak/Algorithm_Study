package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1916_new {

    static class Node implements Comparable<Node>{
        private int vertex;
        private int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    static int N, M;
    static int depart, arrival;
    static int[] dist;
    static ArrayList<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();

        System.out.println(dist[arrival]);
    }

    private static void dijkstra() {
        //Todo 1. 모든 정점까지에 대한 거리를 무한대로 초기화
        // ※주의사항※
        // 문제의 정답으로 가능한 거리의 최댓값보다 큰 값임을 보장해야 한다.
        Arrays.fill(dist,Integer.MAX_VALUE);

        //Todo 2. 최소 힙 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();

        //Todo 3. 시작점에 대한 정보(Node)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        dist[depart] = 0;
        pq.add(new Node(depart, 0));

        //Todo 4. 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보이므로 폐기한다. -> 시간 복잡도를 낮춤
            if(curNode.distance > dist[curNode.vertex]) continue;

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
            for (Node nextNode : nodes[curNode.vertex]) {

                if (dist[curNode.vertex] + nextNode.distance < dist[nextNode.vertex]) {
                    dist[nextNode.vertex] = nextNode.distance + dist[curNode.vertex];
                    pq.add(new Node(nextNode.vertex, dist[nextNode.vertex]));
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        dist = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            nodes[start].add(new Node(end, distance));
        }

        st = new StringTokenizer(br.readLine());
        depart = Integer.parseInt(st.nextToken());
        arrival = Integer.parseInt(st.nextToken());
    }
}
