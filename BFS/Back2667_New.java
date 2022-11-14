package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Back2667_New {

    static class Pos{
        private int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> adjList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        logic();

    }

    private static void logic() {
        //인접리스트 초기화
        adjList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //새로운 단지인 경우
                if (map[i][j] == 1 && !visited[i][j]) {
                    adjList.add(bfs(i,j));
                }
            }
        }

        Collections.sort(adjList);
        sb.append(adjList.size()).append('\n');
        for (Integer number : adjList) {
            sb.append(number).append('\n');
        }

        System.out.println(sb.toString());
    }

    static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Pos(x, y));
        int count = 0;

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int new_x = pos.x + dir[i][0];
                int new_y = pos.y + dir[i][1];

                if (inRange(new_x, new_y) && map[new_x][new_y] == 1) {
                    if (!visited[new_x][new_y]) {
                        q.add(new Pos(new_x, new_y));
                        visited[new_x][new_y] = true;
                    }
                }
            }

        }

        return count;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }
    }
}
