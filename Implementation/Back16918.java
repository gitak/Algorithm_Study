package Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class Back16918 {

    static int r, c, n;
    static char[][] map;
    static int[][] bomb_time;
    static int time = 1;

    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        //map, time 배열 초기화
        map = new char[r][c];
        bomb_time = new int[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'O') {
                    //3초후 폭탄이 터지도록 설정
                    bomb_time[i][j] = 3;
                }
            }
        }

        while (time++ < n) {
            //폭탄을 설치하는 경우
            if (time % 2 == 0) {
                set_bomb();
            }else{
                check_bomb();
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    //빈공간에 폭탄을 설치하는 메서드
    static void set_bomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                    //현재시간에서 3초후 폭탄이 터지도록 설정
                    bomb_time[i][j] = time + 3;
                }
            }
        }
        return;
    }

    //폭탄을 터트려야 되는지 확인하는 메서드
    static void check_bomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (bomb_time[i][j] == time) {
                    explosion(i,j);
                }
            }
        }
        return;
    }

    //폭탄설치를 한지 3초가 지난 폭탄을 터트리는 메서드
    static void explosion(int x, int y) {
        map[x][y] = '.';

        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if(!inRange(new_x,new_y)) continue;
            //폭탄을 동시에 터트리기 위한 조건 (같이 폭발해야될 폭탄은 터트리지 않는다.)
            if(bomb_time[new_x][new_y] == time) continue;
            if(map[new_x][new_y] == '.') continue;

            bomb_time[new_x][new_y] = 0;
            map[new_x][new_y] = '.';
        }

        return;
    }

}
