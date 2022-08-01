package DFS;

import java.io.*;
import java.util.StringTokenizer;

public class FreezeDrink {

    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    count++;
                    dfs(i,j);
                }
            }
        }


        bw.write(count + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void dfs(int x, int y) {
//        if (visited[x][y]) {
//            return;
//        }

        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if (inRange(new_x,new_y)) {
                if (map[new_x][new_y] == 0) {
                    map[new_x][new_y] = 1; // map이 다시 사용되지 않는 경우 visited배열 대신 map의 값을 변경해도 된다.
                    dfs(new_x,new_y);
                }
            }
        }
    }

}
