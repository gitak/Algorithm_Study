package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2644 {

    static int N, A, B;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    static void logic() {
        //dist 배열 초기화
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        bfs(A);

        System.out.println(dist[B]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y : adj[x]) {
                if(dist[y] != -1) continue;
                q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
    }
}
