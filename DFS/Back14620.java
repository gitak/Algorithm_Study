package DFS;

import java.io.*;
import java.util.StringTokenizer;

public class Back14620 {

    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int cost = Integer.MAX_VALUE;

    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        //map 초기화
       for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       dfs(0,0);

        bw.write(cost+"\n");
        bw.flush();
        bw.close();
        br.close();

    }

    //완전탐색 && 백트래킫
    //최소 화단 대여비용을 찾는 메서드
    static void dfs(int count, int sum) {
        if (count == 3) {
            cost = Math.min(cost, sum);
        }
        else{
            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    //(i,j)를 방문하지 않았으면서 개화했을 때 겹치지 않는 경우
                    if (!visit[i][j] && !isOverraped(i, j)) {
                        visit[i][j] = true;
                        int temp = getCost(i, j);

                        dfs(count + 1, sum + temp);
                        visitInitialize(i, j);
                        visit[i][j] = false;
                    }
                }
            }
        }
    }

    //(x,y)에서 꽃을 폈을때, 가격을 얻는 메서드
    static int getCost(int x, int y) {
        int sum = map[x][y];

        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            visit[new_x][new_y]=true;
            sum += map[new_x][new_y];
        }

        return sum;
    }

    //(x,y)에서 꽃을 폈을 때 겹치는지 확인하는 메서드
    static boolean isOverraped(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if(visit[new_x][new_y]) {
                return true;
            }
        }

        return false;
    }

    //(x,y)에서 방문했던 곳을 초기화하는 메서드
    static void visitInitialize(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            visit[new_x][new_y] = false;
        }
    }
}
