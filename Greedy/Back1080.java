package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Back1080 {

    static int[][] A,B;
    static int n, m;

    public static void main(String[] args) throws IOException {

        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //변수 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        B = new int[n][m];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(sb.toString().substring(j, j + 1));
            }
            sb.setLength(0);
        }

        for (int i = 0; i < n; i++) {
            sb.append(br.readLine());
            for (int j = 0; j < m; j++) {
                B[i][j] = Integer.parseInt(sb.toString().substring(j, j + 1));
            }
            sb.setLength(0);
        }
        //입력 종료


        //n < 3이거나 m < 3이어도 A와B의 입력값이 같은 경우가 있으므로 제외
//        if (n < 3 || m < 3) {
//            System.out.println(-1);
//        }

        int count = checkMap();

        if (isSameMap()) {
            System.out.println(count);
        }else{
            System.out.println(-1);
        }

        br.close();
    }


    //A와B를 좌측상단을 기준으로 비교했을 때, 값이 다른 경우 바꿔주는 메서드
    static int checkMap() {
        int switchCount = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    switchMap(i,j);
                    switchCount++;
                }
            }
        }

        return switchCount;
    }

    //3*3 부분행렬을 바꾸는 메서드
    static void switchMap(int row, int column) {
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                A[i][j] = A[i][j] ^ 1;
            }
        }
    }

    //A와B가 같은지 확인하는 메서드
    static boolean isSameMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}
