package DFS;

import java.io.*;
import java.util.StringTokenizer;

public class MazeEscape {

    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static int[][] map;

    //하,우 로만 이동
    static int[] dx = {1,0};
    static int[] dy = {0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 시작
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }
        //입력 종료

        dfs(0,0,1);

        System.out.println(min);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void dfs(int x, int y, int count) {

        //(n,m)에 도달한 경우
        if (x == n-1 && y == m-1) {
            min = Math.min(count, min);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if (inRange(new_x, new_y) && map[new_x][new_y] == 1) {
                dfs(new_x,new_y,count+1);
            }
        }
    }

}
