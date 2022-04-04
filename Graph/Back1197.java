package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Back1197 {

    //간선 정보를 담기 위한 클래스
    static class Edge implements Comparable<Edge> {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Edge> edges = new ArrayList<>();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        //간선을 오름차순 정렬
        Collections.sort(edges);

        //부모노드 초기화
        parent = new int[v+1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        int sum = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            //사이클이 발생하지 않는 경우
            if (find(edge.start) != find(edge.end)) {
                sum += edge.weight;
                union(edge.start, edge.end);
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    //node1과 node2를 연결시키기 위한 메서드
    static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        if (node1 != node2) {
            parent[node2] = node1;
        }
    }

    //해당 노드의 부모노드를 찾기 위한 메서드
    static int find(int node) {
        if (parent[node] == node) {
            return node;
        } else{
            return find(parent[node]);
        }
    }

}
