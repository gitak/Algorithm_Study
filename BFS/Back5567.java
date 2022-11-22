package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back5567 {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs(1));
    }

    //start 정점에서 결혼식에 올 수 있는 사람의 수 찾기
    static int bfs(int start) {
        int count = 0;
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0; //start 방문 처리

        while (!q.isEmpty()) {
            int x = q.poll();

            if(dist[x]== 2) continue;

            for (int y : adj[x]) {
                if(dist[y] != -1) continue; //x -> y로 이미 방문한 적이 있는 경우
                count++;
                q.add(y);
                dist[y] = dist[x] + 1;
            }
        }

        return count;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
    }
}
