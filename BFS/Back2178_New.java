package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2178_New {

    static int N, M;
    static char[][] map;
    static int[][] path;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        input();
        bfs(1, 1);
        System.out.println(path[N][M]);
    }

    //(x,y)에 갈 수 있을 때 방문한 상태
   static void bfs(int x, int y){

        //거리 배열 초기화
       for (int i = 1; i <= N; i++) {
           for (int j = 1; j <= M; j++) {
               path[i][j] = -1;
           }
       }

       //(x,y)를 큐에 넣어주고 path, visited 값 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(1);
        path[x][y] = 1;
        visited[x][y] = true;


        while (!q.isEmpty()) {
            x = q.poll(); y = q.poll();
            for (int i = 0; i < 4; i++) {
                int new_x = x + dir[i][0]; int new_y = y + dir[i][1];
                if (!inRange(new_x, new_y)) continue;
                if(map[new_x][new_y] == '0') continue;
                if(visited[new_x][new_y]) continue;

                q.add(new_x); q.add(new_y);
                visited[new_x][new_y] = true;
                path[new_x][new_y] = path[x][y] + 1;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M + 1];
        path = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = temp.charAt(j - 1);
            }
        }

    }
}
