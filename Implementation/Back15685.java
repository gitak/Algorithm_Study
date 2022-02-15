package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back15685 {

    //드래곤커브의 정보를 담을 클래스
    static class DragonCurve {
        private int x;
        private int y;
        private int dir;
        private int gen;

        public DragonCurve(int x, int y, int dir, int gen) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.gen = gen;
        }
    }

    //우,상,좌,하
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] map = new boolean[101][101];
    static Queue<DragonCurve> q = new LinkedList<>();

    static int count;

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //드래곤 커브의 정보를 Queue에 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());
            q.add(new DragonCurve(x, y, dir, gen));
            map[x][y] = true;
        }

        br.close();//입력 종료

        //각각의 드래곤커브를 이동
        for (DragonCurve dragonCurve : q) {
            move_dragonCurve(dragonCurve);
        }

        //드래곤 커브후 사각형의 개수 세기
        check_square();
        System.out.println(count);
    }

    //(x,y)가 모눈종이 안에 존재하는지 확인하는 메서드
    static boolean inRange(int x, int y) {
        return x >= 0 && x <= 100 && y >= 0 && y <= 100;
    }

    //모눈종이에 그려진 사각형의 개수를 세는 메서드
    static void check_square() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    count++;
                }
            }
        }
    }

    //해당 드래곤커브의 세대만큼 이동시켜주는 메서드
    static void move_dragonCurve(DragonCurve dragonCurve) {
        //이동할 방향을 담을 arrayList
        List<Integer> direction = new ArrayList<>();

        //0세대의 좌표 초기화
        int new_x = dragonCurve.x + dx[dragonCurve.dir];
        int new_y = dragonCurve.y + dy[dragonCurve.dir];

        if (inRange(new_x,new_y)) {
            map[new_x][new_y] = true;

            //0세대일 경우 예외처리
            if (dragonCurve.gen == 0) {
                return;
            }
        }

        direction.add(dragonCurve.dir);

        for (int i = 1; i <= dragonCurve.gen; i++) {

            //i번째 세대의 드래곤 커브를 했을 때 map의 정보 갱신
            for (int dir : direction) {
                new_x += dx[(dir+1)  % 4];
                new_y += dy[(dir+1)  % 4];
                if (inRange(new_x, new_y)) {
                    map[new_x][new_y] = true;
                }
            }

            int count = direction.size();

            //2. direction의 새로운 방향을 조건에 맞게 추가
            for (int j = 0; j < count; j++) {
                int new_dir =  (direction.get(2*j) +1) % 4;
                direction.add(0,new_dir);
            }

        }

    }
}
