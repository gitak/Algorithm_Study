package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2096 {
    static int N;
    static int[][] map;
    static int[][] max, min;
    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void logic() {
        max = new int[N][3];
        min = new int[N][3];

        //초기값 구하기
        for (int i = 0; i < 3; i++) {
            max[0][i] = map[0][i];
            min[0][i] = map[0][i];
        }

        if (N >= 2) {
            //점화식 구하기
            for (int i = 1; i < N; i++) {
                max[i][0] = map[i][0] + Math.max(max[i - 1][0], max[i - 1][1]);
                max[i][1] = map[i][1] + Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]);
                max[i][2] = map[i][2] + Math.max(max[i - 1][1], max[i - 1][2]);
                min[i][0] = map[i][0] + Math.min(min[i - 1][0], min[i - 1][1]);
                min[i][1] = map[i][1] + Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]);
                min[i][2] = map[i][2] + Math.min(min[i - 1][1], min[i - 1][2]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(Math.max(max[N - 1][0], max[N - 1][1]), max[N - 1][2])).append(" ");
        sb.append(Math.min(Math.min(min[N - 1][0], min[N - 1][1]), min[N - 1][2]));

        System.out.println(sb);
    }
}
