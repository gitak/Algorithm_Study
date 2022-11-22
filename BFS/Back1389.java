package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back1389 {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        dist = new int[N + 1];
        int minV = bfs(1);
        int minIdx = 1;
        for (int i = 2; i <= N; i++) {
            int v = bfs(i);
            if (minV > v) {
                minV = v;
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }

    //start 라는 정점에서 케빈 베이컨의 수를 구해주는 함수
    static int bfs(int start) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        q.add(start);
        dist[start] = 0; //start 정점을 갈 수 있다고 표시하기

        while (!q.isEmpty()) {
            int v = q.poll();
            count += dist[v];

            for (int x : adj[v]) {
                if(dist[x] != -1) continue; //v -> x를 이미 탐색했으므로 무시(최단경로가 아니므로 배제)
                q.add(x);
                dist[x] = dist[v] + 1;
            }
        }

        return count;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
    }
}
