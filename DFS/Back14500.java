package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back14500 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int max;
    //싱하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    //(x,y)를 기준으로  ㅗ,ㅜ,ㅓ,ㅏ순
    static int[][] ex = {{0, 0, -1}, {0, 0, 1}, {0, -1, 1}, {-1, 0, 1}};
    static int[][] ey = {{-1, 1, 0}, {-1, 1, 0}, {-1, 0, 0}, {0, 1, 0}};

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close(); //입력종료


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                visited[i][j] = true;
                dfs(i,j,1,map[i][j]);
                visited[i][j] = false;
                dfs_exception(i,j);
            }
        }

        System.out.println(max);
    }

    static boolean isRange(int x, int y) {
        return x>= 0 && x < n && y >=0 && y < m;
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if (isRange(new_x, new_y) && !visited[new_x][new_y]) {
                visited[new_x][new_y] = true;
                dfs(new_x, new_y, depth + 1, sum + map[new_x][new_y]);

                visited[new_x][new_y] = false;
            }
        }
        return;
    }

    //ㅗ,ㅜ,ㅓ,ㅏ 탐색
    static void dfs_exception(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int sum = map[x][y];
            boolean isOut = false;

            for (int j = 0; j < 3; j++) {
                int new_x = x + ex[i][j];
                int new_y = y + ey[i][j];

                if (isRange(new_x, new_y)) {
                    sum += map[new_x][new_y];
                }else{
                    isOut = true;
                    break;
                }
            }

            if(!isOut)max = Math.max(max, sum);
        }
    }
}
