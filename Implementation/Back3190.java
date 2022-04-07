package Implementation;

import java.io.*;
import java.util.*;

public class Back3190 {

    static int n, time = 1;
    static int[][] map;
    //뱀의 방향전환 정보를 담을 hashmap
    static Map<Integer, String> moveInfo;

    //오른쪽기준 시계방향
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    //뱀의 위치를 나타내기 위한 클래스
    static class Snake {
        private int x;
        private int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        //전역 변수 초기화
        moveInfo = new HashMap<>();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        //사과의 위치정보 초기화
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        //뱀의 방향정보 초기화
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int dir_time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            moveInfo.put(dir_time, dir);
        }
        moveSnake();
        bw.write(time+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    //map안에 있는지 확인하는 메서드
    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    //규칙에 따라 뱀을 움직이는 메서드
    static void moveSnake() {
        //0초일 때 뱀의 정보 초기화
        Queue<Snake> snake = new LinkedList<>();
        snake.add(new Snake(0,0));
        int dir = 0;
        //1초일 때 머리 정보 초기화 -> 규칙1.
        int head_x = dx[dir];
        int head_y = dy[dir];

        while (true) {
            //벽 또는 자기자신과 부딪히는 경우
            if(!inRange(head_x,head_y) || map[head_x][head_y] == 2) return;

            //규칙2. 이동한 칸에 사과가 없는 경우 (사과가 있다면 꼬리를 제거할 필요x)
            if (map[head_x][head_y] == 0) {
                //꼬리제거
                Snake tail = snake.poll();
                map[tail.x][tail.y] = 0;
            }

            //이동한 후 몸통의 위치저장
            snake.add(new Snake(head_x, head_y));
            map[head_x][head_y] = 2;

            //뱀이 방향전환을 하는 경우
            if (moveInfo.containsKey(time)) {
                String temp = moveInfo.remove(time);
                if (temp.equals("D")) {
                    dir = (dir + 1) % 4;
                }
                if (temp.equals("L")) {
                    if (dir == 0) {
                        dir = 3;
                    }else{
                        dir--;
                    }
                }
            }
            //규칙1. 머리를 다음칸에 이동
            head_x += dx[dir];
            head_y += dy[dir];
            time++;
        }

    }
}
