package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1260 {

    static boolean[] visited = new boolean[1001];
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        //ArrayList배열 초기화
        list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }

        //list[i]의 값 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        //dfs전 시작노드 초기화
        visited[v] = true;
        System.out.print(v+" ");
        dfs(v);
        System.out.println();

        visited = new boolean[1001];
        bfs(v);

    }

    static void dfs(int node) {

        for (int next : list[node]) {
            if (!visited[next]) {
                System.out.print(next + " ");
                visited[next] = true;
                dfs(next);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        System.out.print(node + " ");
        visited[node] = true;

        while (!q.isEmpty()) {
            int next = q.poll();

            //해당 노드에 연결리스트가 없는 경우 skip
            if(list[next].isEmpty()) continue;

            for (int i = 0; i < list[next].size(); i++) {
                if (!visited[list[next].get(i)]) {
                    visited[list[next].get(i)] = true;
                    System.out.print(list[next].get(i)+" ");
                    q.add(list[next].get(i));
                }
            }
        }

        System.out.println();
    }
}
