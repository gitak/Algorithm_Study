package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back1697_New {

    static int N, K;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();

        bfs(N);
        System.out.println(dist[K]);
    }

    //x 위치부터 시작
    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        dist[x] = 0;

        while (!q.isEmpty()) {
            x = q.poll();
            if (x - 1 >= 0 && !visited[x - 1]) {
                visited[x - 1] = true;
                dist[x - 1] = dist[x] + 1;
                q.add(x - 1);
            }

            if (x + 1 <= 100000 && !visited[x + 1]) {
                visited[x + 1] = true;
                dist[x + 1] = dist[x] + 1;
                q.add(x + 1);
            }

            if (x * 2 <= 100000 && !visited[x * 2]) {
                visited[x * 2] = true;
                dist[x * 2] = dist[x] + 1;
                q.add(x * 2);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        visited = new boolean[100001];
    }
}
