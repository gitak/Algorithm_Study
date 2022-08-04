package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardGame {
    public static void main(String[] args) throws IOException {

        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] card = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력 종료

        //각 행마다 정렬
        for (int i = 0; i < n; i++) {
            Arrays.sort(card[i]);
        }

        int max = card[0][0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, card[i][0]);
        }

        bw.write(max + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}
