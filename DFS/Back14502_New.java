package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back14502_New {

    static int N, M, B;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map, blank;
    static boolean[][] visited;
    static int safe_area = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        //1. 벽으로 가능한 위치를 배열에 순서대로 저장
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        //2. 벽을 세울 수 있는곳 완전탐색
        building_wall(1,0);

        System.out.println(safe_area);
    }

    // idx 번째 빈 칸에 벽을 세울 지 말지 결정해야 하고, 이 전까지 selected_count 개의 벽을 세우는 메서드
    private static void building_wall(int idx, int selected_count) {
        //벽 3개를 세운 경우
        if (selected_count == 3) {
            //3. 모든 바이러스 전파
            spread_virus();
            return;
        }

        //더이상 세울 수 있는 벽이 없는경우
        if(idx > B) return;

        //idx번째 벽을 세우는 경우와 안 세우는 경우를 각각 호출
        map[blank[idx][0]][blank[idx][1]] = 1;
        building_wall(idx + 1, selected_count + 1);

        map[blank[idx][0]][blank[idx][1]] = 0;
        building_wall(idx + 1, selected_count);
    }

    private static void spread_virus() {
        Queue<Integer> q = new LinkedList<>();

        //모든 virus의 위치를 큐에 넣기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visited[i][j] = false;
                if (map[i][j] == 2) {
                    // (i, j)의 위치를 하나씩 넣기
                    q.add(i);
                    q.add(j);
                    visited[i][j] = true;
                }
            }
        }

       //BFS 과정
        while (!q.isEmpty()) {
            int x= q.poll(); int y = q.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = x + dir[i][0], new_y = y + dir[i][1];
                if(!inRange(new_x,new_y)) continue;
                if(map[new_x][new_y] != 0) continue;
                if(visited[new_x][new_y]) continue;

                visited[new_x][new_y] = true;
                q.add(new_x);
                q.add(new_y);
            }
        }

        // 탐색이 종료후, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        int count = countSafeArea(map);
        safe_area = Math.max(safe_area, count);
    }


    static boolean inRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }

    static int countSafeArea(int[][] map) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
