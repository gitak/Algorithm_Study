package Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class GameDevelopment {

    static int n, m;
    static int count = 0;
    static int[][] map;
    static boolean[][] visited;
    //북쪽기준 반시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력 종료

        bfs(x, y, dir);
        System.out.println(count);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void bfs(int x, int y, int dir) {

        for (int i = 1; i < 4; i++) {
            int new_x = x + dx[(dir + i) % 4];
            int new_y = y + dy[(dir + i) % 4];
            int new_dir = (dir + i) % 4;

            if (inRange(new_x, new_y)) {
                if (!visited[new_x][new_y] && map[new_x][new_y] == 0) {
                    count++;
                    visited[new_x][new_y] = true;
                    bfs(new_x,new_y,new_dir);
                }
            }
        }

        if (map[x + dx[(dir + 2) % 4]][y + dy[(dir + 2) % 4]] == 1) {
            return;
        }
        int new_x = x + dx[(dir + 2) % 4];
        int new_y = y + dy[(dir + 2) % 4];
        bfs(new_x,new_y,dir);
    }
}
