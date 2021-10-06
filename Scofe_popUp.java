import java.util.Scanner;

public class Scofe_popUp {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //가로 줄 길이
        int m = sc.nextInt(); //세로 줄 길이
        int[][] map = new int[m][n]; // 매장의 크기
        int[][] path = new int[m][n]; //최적의 경로값을 저장할 변수

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close(); //입력 종료

        //Logic
        path[0][0] = map[0][0]; //초기값 설정
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0) {
                    if (j != 0) {
                        path[i][j] = path[i][j - 1] + map[i][j];
                        continue;
                    }
                } else if (j == 0) {
                    if (i != 0) {
                        path[i][j] = path[i - 1][j] + map[i][j];
                        continue;
                    }
                } else {
                    path[i][j] = map[i][j] + Math.max(path[i - 1][j], path[i][j - 1]);
                }

            }
        }

        System.out.println(path[m-1][n-1]);

    }
}
