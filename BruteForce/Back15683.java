package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Back15683 {

    static class CCTV {

        private int num;
        private int x;
        private int y;

        public CCTV(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static int blindSpot = Integer.MAX_VALUE;
    static int count;

    static int n, m;
    static int[][] map;

    static CCTV[] cctvs = new CCTV[8];
    //12시 방향기준 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    //위쪽 방향을 기준으로 cctv 번호에 맞는 방향
    static int[][] dir = {
            {},
            {1},
            {1, 3},
            {0, 1},
            {0, 1, 3},
            {0, 1, 2, 3}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        //map 초기화
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                //cctv가 있는 경우 cctvs에 담기
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctvs[count++] = new CCTV(map[i][j], i, j);
                }
            }
        }

        observation(0,map);
        bw.write(blindSpot + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    //cctv번호에 맞는 모든 경우를 확인해주는 메서드
    static void observation(int index, int[][] map) {
        //해당 경우의 수에 모든 cctv를 탐색한 경우
        if (index == count) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        sum++;
                    }
                }
            }

           // blindSpot 값 갱신
            blindSpot = Math.min(blindSpot, sum);
            return;
        }

        CCTV cctv = cctvs[index];

        //위쪽 방향부터 시작하여 모든 방향을 탐색할 때
        for (int i = 0; i < 4; i++) {
            int[][] new_map = copy_map(map);

            //cctv번호에 맞게 감시하는 경우
            for (int j = 0; j < dir[cctv.num].length; j++) {
                int new_dir = (dir[cctv.num][j]- i + 3) % 4;
                int new_x = cctv.x;
                int new_y = cctv.y;

                while (true) {
                    new_x += dx[new_dir];
                    new_y += dy[new_dir];

                    if(!inRange(new_x,new_y) || new_map[new_x][new_y] == 6) break;

                    //cctv로 확인한 부분 방문처리
                    new_map[new_x][new_y] = -1;
                }
            }

            //다음 cctv가 탐색
            observation(index+1, new_map);
        }
    }

    //map을 벗어나는지 확인해주는 메서드
    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    //2차원 배열을 복사하는 메서드
    static int[][] copy_map(int[][] map) {
        int[][] copy_map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy_map[i][j] = map[i][j];
            }
        }

        return copy_map;
    }

}
