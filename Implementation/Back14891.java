package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back14891 {

    static int[][] gear = new int[4][8];
    static int[] isValid; // 회전하는 방향 저장 (0이면 이동X)

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //gear의 상태 초기화
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(input[j]);
            }
        }

        //회전시키는 방법 초기화
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gear_num = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());

            isValid = new int[4];
            checkDir(gear_num, dir);
            rotate(isValid);
        }

        br.close(); //입력 종료

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] != 0) {
                sum += Math.pow(2, i);
            }
        }

        System.out.println(sum);

    }

    //톱니바퀴의 회전방향을 결정짓는 메서드
    static void checkDir(int gear_num, int dir) {
        isValid[gear_num] = dir;

        int prev = gear_num - 1;
        int next = gear_num + 1;

        //왼쪽 톱니바퀴검사(단, 톱니바퀴 1번까지)
        if (prev >= 0 && isValid[prev] == 0) {
            if (gear[prev][2] != gear[gear_num][6]) {
                checkDir(prev, dir * -1);
            }
        }

        //오른쪽 바퀴검사(단, 톱니바퀴 4번까지)
        if (next <= 3 && isValid[next] == 0) {
            if (gear[gear_num][2] != gear[next][6]) {
                checkDir(next, dir * -1);
            }
        }

    }

    //톱니바퀴를 회전시키는 메서드
    static void rotate(int[] isValid) {
        for (int i = 0; i < 4; i++) {
            //회전하는 경우
            if (isValid[i] != 0) {
                int[] temp = gear[i].clone();

                //시계방향
                if (isValid[i] == 1) {
                    for (int j = 0; j < 8; j++) {
                        if (j == 0) {
                            gear[i][j] = temp[7];
                            continue;
                        }
                        gear[i][j] = temp[j - 1];
                    }
                }
                //반시계 방향
                else if (isValid[i] == -1) {
                    for (int j = 0; j < 8; j++) {
                        if (j == 7) {
                            gear[i][j] = temp[0];
                            continue;
                        }
                        gear[i][j] = temp[j + 1];
                    }
                }
            }
        }

    }

}
