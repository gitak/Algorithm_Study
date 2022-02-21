package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Back2458 {

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] students = new int[n + 1][n + 1];


        //a가 b보다 작은 경우 students[a][b]= 1로 초기화
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            students[a][b] = 1;
        }

        //플로이드-워샬 알고리즘
        //주로 n이 500이하인 경우 1초를 넘어가지 않음(빡센 곳은 n이 300이하)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    //i < k이고 k < j인 경우 i < j가 된다.
                    if (students[i][k] == 1 && students[k][j] == 1) {
                        students[i][j] = 1;
                    }
                }

            }

        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            boolean isCompared = true;

            for (int j = 1; j <= n; j++) {
                if(i == j) continue;

                //i와 j의 키를 비교할 수 없는 경우
                if (students[i][j] == 0 && students[j][i] == 0) {
                    isCompared = false;
                    break;
                }
            }

            //i번째 학생의 순서를 아는 경우
            if(isCompared) answer++;
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
