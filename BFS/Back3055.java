package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back3055 {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] dist_water, dist_hedgehog;

    public static void main(String[] args) throws IOException {
        input();
        //각 칸마다 물에 닿는 시간 계산하기
        bfs_water();
        //고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        bfs_hedgedog();

        //탈출구 'D'에 대한 결과 출력
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] == 'D') {
                   if(dist_hedgehog[i][j] == -1) System.out.println("KAKTUS");
                   else System.out.println(dist_hedgehog[i][j]);
                }
            }
        }

    }

    // 모든 물의 위치를 시작으로 동시에 BFS 시작!
    static void bfs_water() {

        //모든 물의 시작위치 초기화
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                dist_water[i][j] = -1;
                visited[i][j] = false;

                if (map[i][j] == '*') {
                    q.add(i);
                    q.add(j);
                    dist_water[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int k = 0; k < 4; k++) {
                int new_x = x + dir[k][0];
                int new_y = y + dir[k][1];

                if(new_x < 1 || new_x > R || new_y < 1 || new_y > C) continue; //지도를 벗어나는가?
                if(map[new_x][new_y] != '.') continue; //물이 이동할 수있는 칸인가?
                if(visited[new_x][new_y]) continue; //이미 방문한 적이 있는 곳인가?

                q.add(new_x);
                q.add(new_y);
                visited[new_x][new_y] = true;
                dist_water[new_x][new_y] = dist_water[x][y] + 1;
            }
        }

    }

    //고슴도치 위치를 시작으로 동시에 bfs 시작
    static void bfs_hedgedog() {
        //고슴도치의 시작위치 초기화
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                dist_hedgehog[i][j] = -1;
                visited[i][j] = false;
                if (map[i][j] == 'S') {
                    q.add(i);
                    q.add(j);
                    dist_hedgehog[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int k = 0; k < 4; k++) {
                int new_x = x + dir[k][0];
                int new_y = y + dir[k][1];

                if(new_x < 1 || new_x > R || new_y < 1 || new_y > C) continue; //지도를 벗어나는가?
                if(map[new_x][new_y] != '.' && map[new_x][new_y] != 'D') continue; //고슴도치가 이동할 수 있는 곳인가?
                //이동할 위치가 물에 잠기지 않는가?
                if(dist_water[new_x][new_y] != -1 && dist_water[new_x][new_y] <= dist_hedgehog[x][y] + 1) continue;
                if(visited[new_x][new_y]) continue;

                q.add(new_x);
                q.add(new_y);
                visited[new_x][new_y] = true;
                dist_hedgehog[new_x][new_y] = dist_hedgehog[x][y] + 1;
            }
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];
        dist_water = new int[R + 1][C + 1];
        dist_hedgehog = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = temp.charAt(j - 1);
            }
        }
    }
}
