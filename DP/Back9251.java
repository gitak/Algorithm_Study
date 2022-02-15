package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        //공집합을 표현하기 위해 각각 A,B의 길이 +1씩 증가
        int[][] dp = new int[A.length + 1][B.length + 1];

        //1부터 시작 (dp의 0번째 행이나 열은 공집합을 의미)
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {

                //A의 (i-1)과 B의 (j-1)의 문자가 서로 같은 경우
                if (A[i - 1] == B[j - 1]) {
                    //대각선 위 (i-1, j-1)의 dp값의 +1한 값으로 갱신
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                //문자가 서로 다른 경우 이전 행이나 열에서 큰 값으로 갱신
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[A.length][B.length]);
        br.close();//입력 종료
    }
}
