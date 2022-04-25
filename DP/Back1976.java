package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Back1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] map;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //map 초기화
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (i == j) { //출발점과 도착점이 같은 경우
                    map[i][j] = 1;
                }
            }
        }

        //플로이드-워샬 알고리즘
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //i -> j로 갈 때 k를 거쳐서 갈 수 있는 경우
                   if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < m-1; i++) {
            int end = Integer.parseInt(st.nextToken()) - 1;

            if (map[start][end] == 0) {
                bw.write("NO\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        bw.write("YES\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
