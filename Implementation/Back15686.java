package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back15686 {

    static int n;
    static int m;
    static int[][] map;
    static int min_dist = Integer.MAX_VALUE;

    static List<Pos> chickens = new ArrayList<>();
    static List<Pos> houses = new ArrayList<>();
    static Stack<Pos> selectChicken = new Stack<>();

    static class Pos {
        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //map 초기화 && houses 와 chickens 초기화
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    houses.add(new Pos(i,j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Pos(i, j));
                }
            }
        }

        dfs(0,0);
        System.out.println(min_dist);
        br.close(); //입력종료
    }

    //백트래킹 방식으로 조합을 통해 경우의 수를 구하는 메서드
    static void dfs(int start, int depth) {

        if (depth == m) {
            chicken_distance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selectChicken.push(chickens.get(i));
            dfs(i + 1, depth + 1);
            selectChicken.pop();
        }

    }

    //뽑은 경우의 수로 치킨거리를 구하는 메서드
    static void chicken_distance() {

        int total = 0;
        for (Pos house : houses) {
            int min = Integer.MAX_VALUE;

            for(Pos chicken : selectChicken){
                int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                min = Math.min(distance, min);
            }

            total += min;
        }

        min_dist = Math.min(total, min_dist);
    }

}
