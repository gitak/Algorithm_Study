package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2468 {
    static int[][] map ;
    static int n;
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max;

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int max_rain = 0;
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max_rain < map[i][j])
                    max_rain = map[i][j];
            }
        }
        br.close();//입력종료

        for (int rain = 0; rain < max_rain; rain++) {
            int count = 0;
            boolean[][] visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j] || map[i][j] <= rain) continue;
                    else{
                        visited[i][j] = true;
                        dfs(map, visited, i, j, rain);
                        count++;
                    }
                }
            }
            if(max < count) max = count;
        }

        System.out.println(max);

    }

    static void dfs(int[][] map,boolean[][] visited, int x, int y, int rain){

        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if (isRange(new_x, new_y) && map[new_x][new_y] > rain && !visited[new_x][new_y]) {
                visited[new_x][new_y] = true;
                dfs(map,visited, new_x, new_y, rain);
            }
        }

        return;
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
