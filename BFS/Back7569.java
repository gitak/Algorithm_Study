package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back7569 {

    static int M, N, H;
    static int[][][] box;
    static int[][] dir = new int[][]{{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    static int[][][] dist;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        bfs();
        int max = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if(box[i][j][k] == -1) continue; //빈 공간인 경우
                    if (dist[i][j][k] == -1) { // 안익은 토마토가 있는 경우
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, dist[i][j][k]);
                }
            }
        }

        System.out.println(max);
    }

    static boolean inRange(int h, int x, int y) {
        return h > 0 && h <= H && x > 0 && x <= N && y > 0 && y <= M;
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        //익은 토마토의 위치를 큐에 저장
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    dist[i][j][k] = -1;
                    if (box[i][j][k] == 1) {
                        dist[i][j][k] = 0;
                        q.add(i);q.add(j);q.add(k);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int h = q.poll();
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 6; i++) {
                int new_h = h + dir[i][0];
                int new_x = x + dir[i][1];
                int new_y = y + dir[i][2];
                if(!inRange(new_h,new_x,new_y)) continue; //범위를 벗어났는가?
                if(dist[new_h][new_x][new_y] != -1) continue; //방문한 적이 있는가?
                if(box[new_h][new_x][new_y] == -1) continue; //비어 있는가?

                q.add(new_h);
                q.add(new_x);
                q.add(new_y);
                dist[new_h][new_x][new_y] = dist[h][x][y] + 1;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H + 1][N + 1][M + 1];
        dist = new int[H + 1][N + 1][M + 1];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }
}
