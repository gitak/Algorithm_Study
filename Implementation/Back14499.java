package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back14499 {
    static int[][] map;
    static int[] dice = new int[7];

    //동서북남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //지도의 세로,가로 크기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //주사위의 좌표
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        //명령의 개수
        int k = Integer.parseInt(st.nextToken());

        List<Integer> answerList = new ArrayList<>();

        //map 초기화
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int next_x = x + dx[dir - 1];
            int next_y = y + dy[dir - 1];

            if (isRange(next_x, next_y)) {
                rollDice(dir);

                if (map[next_x][next_y] == 0) {
                    map[next_x][next_y] = dice[6];
                }else{
                    dice[6] = map[next_x][next_y];
                    map[next_x][next_y] = 0;
                }

                x = next_x;
                y = next_y;
                answerList.add(dice[1]);
            }
        }

        for(int ans : answerList) {
            System.out.println(ans);
        }
        br.close();//입력 종료
    }

    //해당 좌표가 범위안에 있는 경우 true를 반환하는 메서드
    static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    /*
    주사위 위치를 고정시키고 해당위치의 값을 변경시킨다
      2
    4 1 3
      5
      6
     */

    //주사위를 굴렸을 때 주사위 값을 변경하는 메서드
    static void rollDice(int dir) {
        int[] temp = dice.clone();

        switch (dir) {
            case 1: //동
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[6] = temp[3];
                dice[4] = temp[6];
                break;
            case 2: //서
                dice[1] = temp[3];
                dice[3] = temp[6];
                dice[6] = temp[4];
                dice[4] = temp[1];
                break;
            case 3: //북
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[5] = temp[6];
                dice[6] = temp[2];
                break;
            case 4: //남
                dice[1] = temp[2];
                dice[2] = temp[6];
                dice[5] = temp[1];
                dice[6] = temp[5];
                break;
        }
    }
}
