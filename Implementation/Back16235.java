package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back16235 {

    static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        //나무의 나이를 기준으로 오름차순
        @Override
        public int compareTo(Tree tree) {
            return this.age - tree.age;
        }
    }

    static int[][] map;
    static int[][] nutrient;
    static Queue<Tree> trees = new PriorityQueue<>();
    static Queue<Tree> alive_tree;
    static Queue<Tree> dead_tree;

    //(x,y)와 인접한 칸
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        nutrient = new int[n][n];

        //양분 정보 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nutrient[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }
        br.close(); //입력 종료

        alive_tree = new LinkedList<>();
        dead_tree = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    static boolean isRange(int x, int y) {
        return x>= 0 && x < map.length && y >= 0 && y < map.length;
    }

    static void spring() {
        while (!trees.isEmpty()) {
            Tree tree = trees.poll();
            if (map[tree.x][tree.y] >= tree.age) {
                map[tree.x][tree.y] -= tree.age;
                tree.age += 1;
                alive_tree.add(tree);
            }else{
                dead_tree.add(tree);
            }
        }
    }

    static void summer() {
        while (!dead_tree.isEmpty()) {
            Tree tree = dead_tree.poll();
            map[tree.x][tree.y] += (tree.age/2);
        }
    }

    static void fall() {
        while (!alive_tree.isEmpty()) {
            Tree tree = alive_tree.poll();

            if (tree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int new_x = tree.x + dx[i];
                    int new_y = tree.y + dy[i];
                    if (isRange(new_x, new_y)) {
                        trees.add(new Tree(new_x, new_y, 1));
                    }
                }
            }

            trees.add(tree);
        }
    }

    static void winter() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] += nutrient[i][j];
            }
        }
    }

}
