package DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1937 {
    static int n; // 대나무 숲의 크기
    static int[][] map; //map에서 대나무의 수를 표현할 배열
    static int max;
    static int[][] dp; //해당 위치에서 최대값을 저장하기 위한 배열
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 대나무 숲의 크기
        map = new int[n][n]; //배열 초기화
        int[][] check = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close(); //입력 종료

        //Logic -> 시간 초과가 나오는 경우 메모리를 사용해 이전 값을 저장하여 시간을 줄인다.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //DFS결과로 나온 값은 (i,j)에서 나올 수 있는 최대값 dp[i][j]가 반한된다.
                max = Math.max(max, DFS(i,j));
            }
        }
        System.out.println(max);
    }

    public static int DFS(int x, int y){
        if(dp[x][y] != 0) return dp[x][y]; //해당 위치에서 이미 dp값을 구한 경우

        dp[x][y] = 1; //시작 위치에서의 값은 모두 1이다.

        for(int i = 0; i < 4; i++){
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            //map을 벗어나지 않은 경우
            if(new_x>= 0 && new_x < n && new_y >=0 && new_y < n){
                //새로운 위치에 대나무가 더 많은 경우
                if(map[x][y] < map[new_x][new_y]){
                    //기존의 값과 새로운 위치에서 오는 값중 더 큰 값으로 dp[x][y]의 값오로 갱신한다.
                    dp[x][y] = Math.max(DFS(new_x, new_y) + 1, dp[x][y]);
                    //DFS(new_x, new_y);
                }
            }
        }
        return dp[x][y];
    }

}
