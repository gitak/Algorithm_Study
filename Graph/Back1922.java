package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back1922 {

    //간선 정보를 담기 위한 클래스
    static class Edge implements Comparable<Edge>{
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
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //간선 정보 담기
        edgeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(start, end, weight));
        }

        //부모노드 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int sum = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

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

    //x가 어떤 집합에 포함되어 있는지
    // 찾아주는 메서드(start가 속한 부모노드)
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    //x와 y가 서로 연결되었는지 확인하는 메서드
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {

            parent[y] = x;

            /* 항상 부모노드에 더 작은 값으로 넣어 주려면 다음과 같이 표현 가능
            if(x < y) parent[y] = x;
            else parent[x] = y;
            */
        }
    }
}
