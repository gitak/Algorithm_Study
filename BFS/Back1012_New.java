package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back1012_New {

    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            input(br);
            logic();
        }

        System.out.println(sb);
    }

    private static void logic() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                    count++;
                }
            }
        }
        sb.append(count).append('\n');
    }

    static void bfs(int x, int y) {
        //시작점 초기화
        Queue<Integer> q = new LinkedList();
        q.add(x);
        q.add(y);
        visited[x][y] = true;

        while (!q.isEmpty()) {
            x = q.poll();
            y = q.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = x + dir[i][0];
                int new_y = y + dir[i][1];

                if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= M) continue; //지도를 벗어나는가?
                if(map[new_x][new_y] != 1) continue; //배추가 있는가?
                if(visited[new_x][new_y]) continue; //방문한 적이 있는가?

                q.add(new_x);
                q.add(new_y);
                visited[new_x][new_y] = true;
            }
        }
    }

    private static void input(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }
    }
}
