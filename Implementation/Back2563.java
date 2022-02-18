package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2563 {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[100][100];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //검은색 종이 방문처리
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    visited[j][k] = true;
                }
            }

        }
        br.close(); //입력종료

        //검은색 종이(크기1) 개수 세기
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j]) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}
