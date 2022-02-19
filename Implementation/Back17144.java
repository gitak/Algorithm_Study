package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back17144 {
    static int r;
    static int c;
    static int t;

    //상,하,좌,우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int up = Integer.MIN_VALUE;
    static int down = Integer.MIN_VALUE;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //공기청정기의 위치 저장
                if (map[i][j] == -1) {
                    if (up == Integer.MIN_VALUE) {
                        up = i;
                        down = i + 1;
                    }
                }

            }
        }
        br.close(); //입력 종료

        for (int i = 0; i < t; i++) {
            //확산된 먼지의 정보를 담고있는 map초기화
            int[][] diffusion_map = new int[r][c];
            diffusion_map[up][0] = -1;
            diffusion_map[down][0] = -1;
            dustDiffusion(diffusion_map);
            up_air_cleaning();
            down_air_cleaning();
        }

        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }

        System.out.println(sum);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    //미세먼지를 확산시키는 메서드
    static void dustDiffusion(int[][] diffusion_map) {

        //1. 확산된 미세먼지 만들기
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                //미세먼지가 확산될 수 있는 경우
                if (map[x][y] >= 5) {
                    int count = 0;
                    //확산된 먼지
                    int dust = (map[x][y] / 5);
                    for (int i = 0; i < 4; i++) {
                        int new_x = x + dx[i];
                        int new_y = y + dy[i];

                        if (inRange(new_x, new_y) && !(map[new_x][new_y] == -1)) {
                            //해당 위치에 이미 확산된 먼지가 존재할 수 있으므로 dust를 더해줘야 한다.
                            diffusion_map[new_x][new_y] += dust;
                            count++;
                        }
                    }

                    map[x][y] -= (count * dust);
                }

            }
        }

        //2. 남은 미세먼지 + 확산된 미세먼지 합치기
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (diffusion_map[x][y] > 0) {
                    map[x][y] += diffusion_map[x][y];
                }
            }
        }

    }

    static void up_air_cleaning() {

        int[][] temp = copy_map(map);

        for (int i = up - 1; i > 0; i--) {
            map[i][0] = temp[i-1][0];
        }
        for (int i = 0; i < c-1; i++) {
            map[0][i] = temp[0][i+1];
        }
        for (int i = 0; i < up ; i++) {
            map[i][c - 1] = temp[i+1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            map[up][i] = temp[up][i - 1];
        }
        map[up][1] = 0;

    }

    static void down_air_cleaning() {
        int[][] temp = copy_map(map);

        for (int i = down + 1; i < r-1; i++) {
            map[i][0] = temp[i + 1][0];
        }
        for (int i = 0; i < c-1; i++) {
            map[r - 1][i] = temp[r - 1][i+1];
        }
        for (int i = r - 1; i > down ; i--) {
            map[i][c-1] = temp[i-1][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            map[down][i] = temp[down][i - 1];
        }
        map[down][1] = 0;
    }

    //2차원배열을 복사하는 메서드
    static int[][] copy_map(int[][] map) {
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = map[i][j];
            }
        }

        return temp;
    }

}
