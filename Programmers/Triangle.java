package Programmers;

import java.io.IOException;

public class Triangle {
    public static void main(String[] args) throws IOException {
       int[][] triangle = {{7}, {3,8}, {8,1,0},{2,7,4,4},{4,5,2,6,5}};

//       for(int i = 0; i < triangle.length;i++){
//           for(int j = 0; j <triangle[i].length; j++){
//               System.out.print(triangle[i][j]);
//           }
//           System.out.println();
//       }

        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        //해당 위치에서 가장 큰 값을 저장하기 위한 배열
        int[][] dp = new int[triangle.length][triangle.length];
        int answer = 0;
        dp[0][0] = triangle[0][0]; //시작값 초기화
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){

                if(j == 0){//가장 왼쪽에 있는 경우
                    dp[i][j] = dp[i-1][0] + triangle[i][j];
                }
                else if( j == triangle[i].length - 1){//가장 오른쪽에 있는 경우
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        //삼각형 마지막 줄에서 가장 큰 값을 answer에 대입
        for(int i = 0; i < triangle.length; i++){
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }

        return answer;
    }
}
