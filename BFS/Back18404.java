package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back18404 {

    static int N, M, X, Y;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static int[][] dist;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() throws IOException {
        bfs(); // target_x, target_y 가 바뀔 때 마다 bfs 돌릴 필요X -> 시작 위치는 항상 (X,Y)이기 때문에
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int target_x = Integer.parseInt(st.nextToken());
            int target_y = Integer.parseInt(st.nextToken());
            sb.append(dist[target_x][target_y]).append(' ');
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    static void bfs() {

        //dist 배열 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        dist[X][Y] = 0;
        q.add(X);
        q.add(Y);

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int i = 0; i < 8; i++) {
                int new_x = x + dir[i][0];
                int new_y = y + dir[i][1];
                if (!inRange(new_x, new_y)) continue; //지도 밖으로 벗어났는가?
                if (dist[new_x][new_y] != -1) continue; //이미 방문한 적이 있는가?
                q.add(new_x);
                q.add(new_y);
                dist[new_x][new_y] = dist[x][y] + 1;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= N && y <= N;
    }
}
