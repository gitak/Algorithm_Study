package Implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2933 {

    static class Node{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int r, c;
    static char[][] map;
    static boolean[][] visit;
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        //map 초기화
        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int removePoint = Integer.parseInt(st.nextToken());
            removeMineral(removePoint,i);
            //방문 초기화
            visit = new boolean[r][c];
            moveMineral();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    //순서에 따라 미네랄을 제거하는 메서드
    static void removeMineral(int row, int count) {
        row = r - row;

        //왼쪽 방향에서 제거하는 경우(왼쪽부터 시작)
        if (count % 2 == 0) {
            for (int i = 0; i < c; i++) {
                if (map[row][i] == 'x') {
                    map[row][i] = '.';
                    break;
                }
            }
        }else{ //오른쪽 방향에서 제거하는 경우
            for (int i = c - 1; i >= 0; i--) {
                if (map[row][i] == 'x') {
                    map[row][i] = '.';
                    break;
                }
            }
        }

    }

    static void moveMineral() {
        Queue<Node> q = new LinkedList<>();

        //1. 미네랄 위치 모두 탐색
        //땅과 붙어있는 미네랄 탐색
        for (int i = 0; i < c; i++) {
            if (map[r - 1][i] == 'x' && !visit[r - 1][i]) {
                q.add(new Node(r - 1, i));
                visit[r-1][i] = true;
            }
        }
        //땅에있는 미네랄과 같은 클러스터 bfs 탐색 ->같은 클러스터는 상하좌우중 적어도 하나가 붙어있다.
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int new_x = node.x + dx[i];
                int new_y = node.y + dy[i];

                //map을 안벗어나고 미네랄이 존재하며 방문하지 않은 경우 -> 땅과 연결된 클러스터만 방문처리
                if (inRange(new_x, new_y) && map[new_x][new_y] == 'x' && !visit[new_x][new_y]) {
                    q.add(new Node(new_x, new_y));
                    visit[new_x][new_y] = true;
                }
            }
        }

        //2. 공중에 있는 미네랄 찾기
        //단, 두 개이상의 클러스터가 동시에 떨어지지 않을 때
        ArrayList<Node> airMineral = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'x' && !visit[i][j]) {
                    airMineral.add(new Node(i, j));
                    map[i][j] = '.';
                    visit[i][j] = true;
                }
            }
        }

        //3. 공중에 있는 미네랄이 있는 경우 -> 조건에 맞게 내리기
        if (!airMineral.isEmpty()) {
            boolean isStop = false;

            //미네랄을 최대한 내릴 수 있을때 까지 이동
            while (!isStop) {
                //전체 미네랄이 한 칸씩 내려갈 수 있는지 확인
                for (int i = 0; i < airMineral.size(); i++) {
                    int next_x = airMineral.get(i).x + 1;
                    int next_y = airMineral.get(i).y;

                    //한 칸 내렸을 때, 다른 클러스터나 땅을 만나는 경우 - > 탈출 조건
                    if (next_x >= r || map[next_x][next_y] == 'x') {
                        isStop = true;
                        break;
                    }
                }

                //한 칸씩 내릴 수 있는 경우 한 칸내린 좌표로 수정
                if (!isStop) {
                    for (Node node : airMineral) {
                        node.x++;
                    }
                }
            }

            //공중에 있는 미네랄 위치 수정
            for (int i = 0; i < airMineral.size(); i++) {
                map[airMineral.get(i).x][airMineral.get(i).y] = 'x';
            }

        }

    }
}
