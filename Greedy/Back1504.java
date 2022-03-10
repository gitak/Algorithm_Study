package Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1504 {

    static class Node implements Comparable<Node>{

        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int n, e;
    //인접리스트
    static ArrayList<ArrayList<Node>> adj;
    static int[] dist;
    static boolean[] check;
    static int INF = 1000 * 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        dist = new int[n + 1];
        check = new boolean[n + 1];

        //dist 배열 INF값으로 초기화
        Arrays.fill(dist, INF);

        //adj ArrayList 초기화
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        //양방향 인접리스트 구현
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //start -> end 방향과 end -> start 방향 가중치 설정
            adj.get(start).add(new Node(end, weight));
            adj.get(end).add(new Node(start, weight));
        }

        //v1 과 v2 설정
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        //1. 1 -> v1 -> v2 -> n으로 가는 최소경로
        int case1 = 0;
        case1 += dijkstra(1, v1);
        case1 += dijkstra(v1, v2);
        case1 += dijkstra(v2, n);

        //2. 1 -> v2 -> v1 -> n으로 가는 최소경로
        int case2 = 0;
        case2 += dijkstra(1, v2);
        case2 += dijkstra(v2, v1);
        case2 += dijkstra(v1, n);

        int ans = (case1 >= INF && case2 >= INF) ? -1 : Math.min(case1, case2);

        bw.write(ans +"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    //다익스트라 알고리즘을 구현한 메서드
    static int dijkstra(int start, int end) {
        //dist배열을 INF값으로 check배열을 false로 초기화
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        //시작노드의 거리값 초기화하고 우선순위큐에 넣기
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int curNode = pq.poll().end;

            if (!check[curNode]) {
                check[curNode] = true;

                //현재노드(curNode)에서 인접한 모든 노드를 탐색
                for (Node nexNode : adj.get(curNode)) {

                    //다른 노드를 거쳐서 가는 것이 더 빠른 경우 갱신
                    if (!check[nexNode.end] && (dist[nexNode.end] > dist[curNode] + nexNode.weight)) {
                        dist[nexNode.end] = dist[curNode] + nexNode.weight;
                        pq.add(new Node(nexNode.end, dist[nexNode.end]));
                    }
                }
            }
        }

        return dist[end];
    }
}
