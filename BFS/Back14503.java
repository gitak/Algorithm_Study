package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back14503 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int cleaned_place;

    //북,동,남,서(시계방향)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<Robot> robots = new LinkedList<>();

    //로봇청소기의 방향과 위치를 담을 클래스
    static class Robot {
        private int x;
        private int y;
        private int dir;

        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        //map, visited 초기화
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //입력 종료

        //로봇청소기의 초기위치 설정
        robots.add(new Robot(x, y, d));
        visited[x][y] = true;
        cleaned_place++;

        bfs();
        System.out.println(cleaned_place);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void bfs() {

        while (!robots.isEmpty()) {
            Robot robot = robots.poll();
            boolean check = false;
            for (int i = 1; i <= 4; i++) {

                int new_dir = (robot.dir + 4 - i) % 4;
                int new_x = robot.x + dx[new_dir];
                int new_y = robot.y + dy[new_dir];

                if (!inRange(new_x, new_y)) continue;

                //현재 방향기준 왼쪽으로 돌았을 때 해당 공간이 청소하지 않은 경우
                if (!visited[new_x][new_y] && map[new_x][new_y] == 0) {
                    visited[new_x][new_y] = true;
                    robots.add(new Robot(new_x, new_y, new_dir));
                    cleaned_place++;
                    check = true;
                    break;
                }
            }

            //네 방향이 이미 청소했거나 벽인 경우
            if (!check) {
                int back_dir = (robot.dir + 2) % 4;
                int back_x = robot.x + dx[back_dir];
                int back_y = robot.y + dy[back_dir];

                //후진할 수 있는 경우
                if (map[back_x][back_y] == 0) {
                    robots.add(new Robot(back_x, back_y, robot.dir));
                }
            }
        }

        return;
    }
}
