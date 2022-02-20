package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back17135 {

    //적들의 좌표를 저장할 클래스
    static class Enemy {
        private int x;
        private int y;

        public Enemy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, d;
    static int[][] map;
    static int max;

    //궁수의 y좌표를 저장할 list
    static List<Integer> archer;

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        //map 초기화
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();//입력 종료

        //궁수의 list초기화
        archer = new ArrayList<>();

        comb(0, 0);
        System.out.println(max);

    }

    //궁수의 위치를 결정하기 위한 메서드(조합)
    static void comb(int depth, int start) {
        if (depth == 3) {
            game_start();
            return;
        }

        for (int i = start; i < m; i++) {
            archer.add(i);
            comb(depth + 1, start + 1);
            archer.remove(archer.size() - 1);
        }

    }

    //주어진 game을 실행하기 위한 메서드
    static void game_start() {
        //제거한 적의 수를 담기위한 변수
       int sum = 0;
        //초기 성의 위치
        int castle = n;

        //map을 복사 (map의 값을 바꾸기 위해)
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, m);
        }

        //게임이 끝나기 위한 조건
        while (castle > 0) {
            //적의 위치를 담기위한 arrayList
            ArrayList<Enemy> enemies = new ArrayList<>();

            //궁수의 인원수만큼(3명)
            for (int i = 0; i < archer.size(); i++) {
                int min = Integer.MAX_VALUE;
                int x = 0, y = 0;

                //왼쪽부터 (열 기준)
                for (int j = 0; j < m; j++) {
                    //가까운 적 찾기
                    for (int k = castle - 1; k >= 0; k--) {
                        int dist = Math.abs(castle - k) + Math.abs(archer.get(i) - j);

                        //해당 위치에 적이 있고 궁수와의 거리가 d이하인 경우
                        if (copyMap[k][j] == 1 && dist <= d) {
                            //더 가까운 적이 나타나는 경우 위치와 거리 갱신
                            if (dist < min) {
                                min = dist;
                                x = k;
                                y = j;
                            }
                            break;
                        }

                    }
                }

                //공격할 수 있는 적이 있는 경우
                if(min != Integer.MAX_VALUE){
                    enemies.add(new Enemy(x, y));
                }

            }

            //모든궁수가 동시에 적 제거
            for (int i = 0; i < enemies.size(); i++) {
                int enemy_x = enemies.get(i).x;
                int enemy_y = enemies.get(i).y;

                //중복되는 적을 한 번만 제거하기 위해
                if (copyMap[enemy_x][enemy_y] == 1) {
                    sum++;
                    copyMap[enemy_x][enemy_y] = 0;
                }
            }

            //성의 위치 이동(성을 위로 한칸 움직임)
            castle--;

        }

        //제거한 적의 수 갱신
        if (sum > max) {
            max = sum;
        }
    }

}
