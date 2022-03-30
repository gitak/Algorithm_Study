package Implementation;

import java.io.*;
import java.util.*;

public class Back16234 {

    //연합할 국가의 위치를 저장할 클래스
    static class Pos {
        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n,l,r;
    static int[][] map;
    static boolean[][] visited;
    static List<Pos> union;
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Queue<Pos>> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        //map 초기화
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = movePopulation();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    //인구이동이 며칠동안 일어나는지 찾는 메서드
    static int movePopulation() {
        int result = 0;

        while (true) {
            //인구이동이 가능한지 확인하기 위한 플래그
            boolean isMove = false;
            //하루가 지나면 방문했던곳 초기화
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //인구이동이 일어지 않았을 때
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        //인구이동이 가능한 경우
                        if (union.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }

            //더 이상 인구이동을 할 수 없는 경우
            if(!isMove) return result;
            result++;
        }
    }

    //연합이 되는 국가의 총 인구수를 찾기 위한 메서드
    static int bfs(int x, int y) {

        //Queue와 ArrayList 2개를 이용
        //q는 연합이 가능한 국가를 찾는데 사용하고 union은 연합이 되는 국가들의 위치를 모두 저장
        Queue<Pos> q = new LinkedList<>();
        union = new ArrayList<>();

        q.add(new Pos(x, y));
        union.add(new Pos(x, y));
        visited[x][y] = true;

        int sum = map[x][y];
        while (!q.isEmpty()) {
            Pos pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = pos.x + dx[i];
                int new_y = pos.y + dy[i];

                //범위를 안나가면서 방문하지 않으면서
                if (inRange(new_x, new_y) && !visited[new_x][new_y]) {
                    int diff = Math.abs(map[pos.x][pos.y] - map[new_x][new_y]);
                    //인구 차이가 l이상 r이하가 되는 경우
                    if (diff >= l && diff <= r) {
                        q.add(new Pos(new_x, new_y));
                        union.add(new Pos(new_x, new_y));
                        sum += map[new_x][new_y];
                        visited[new_x][new_y] = true;
                    }
                }
            }
        }

        return sum;
    }

    //해당 위치가 범위안에 있는지 확인하는 메서드
    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    //연합국가의 인구수를 바꾸기 위한 메서드
    static void changePopulation(int sum) {
        int avg = sum / union.size();
        for (Pos pos : union) {
            map[pos.x][pos.y] = avg;
        }
    }
}
