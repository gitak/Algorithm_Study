package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1260_New {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    //static ArrayList<Integer>[] adjList; -> ArrayList 배열로도 사용 가능
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        input();


    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        //정점의 개수 N만큼 인접리스트 생성
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            //인접리스트에 무방향 간선 추가
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        for (int i = 1; i < adjList.size(); i++) {
            Collections.sort(adjList.get(i));
        }

        //시작 vertex 처리
        visited[start] = true;
        sb.append(start).append(' ');

        dfs(start);
        sb.append('\n');
        //visited 배열 초기화
        Arrays.fill(visited, false);
        bfs(start);
        System.out.println(sb.toString());
    }

    static void dfs(int vertex) {
        //dfs를 하는 vertex는 visited[vertex] = false를 의미하므로 시작하는 부분에 방문처리!!
        visited [vertex] = true;
        for (int i = 0; i < adjList.get(vertex).size(); i++) {
            if (!visited[adjList.get(vertex).get(i)]) {
                sb.append(adjList.get(vertex).get(i)).append(' ');
                dfs(adjList.get(vertex).get(i));
            }
        }

        return;
    }

    static void bfs(int vertex) {
        Queue<Integer> q = new LinkedList<>();
        //시작점 방문처리
        q.add(vertex);
        sb.append(vertex).append(' ');

        while (!q.isEmpty()) {
            int next_vertex = q.poll();

            for (int i = 0; i < adjList.get(next_vertex).size(); i++) {
                if (!visited[adjList.get(next_vertex).get(i)]) {
                    q.add(adjList.get(next_vertex).get(i));
                    //queue에 넣고 방문처리
                    visited[adjList.get(next_vertex).get(i)] = true;
                    sb.append(adjList.get(next_vertex).get(i)).append(' ');
                }
            }
        }

        return;
    }
}
