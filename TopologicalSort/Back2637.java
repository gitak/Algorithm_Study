package TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Back2637 {

    static class Node{
        private int part;
        private int part_count;

        public Node(int part, int part_count) {
            this.part = part;
            this.part_count = part_count;
        }
    }

    static int N, M;
    static ArrayList<Node>[] adj;
    static int[] indeg;
    static int[][] count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        indeg = new int[N + 1];
        count = new int[N + 1][N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            adj[y].add(new Node(x, k));
            indeg[x]++;
        }
    }

    static void logic() {
        Deque<Integer> queue = new LinkedList<>();
        //제일 앞에 "정렬될 수 있는" 정점 찾기 (기본 부품 찾기)
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                count[i][i] = 1;
            }
        }
            // 먼저 만들 수 있는 제품들부터 차례대로 만들어서 필요 기본 부품 개수 계산하기
            while (!queue.isEmpty()) {
                int x = queue.poll();

                for (Node node : adj[x]) {
                    int y = node.part;
                    int y_count = node.part_count;
                    indeg[y]--;
                    //제품 y에 제품 x가 y_count개 만큼 필요하므로 기본 부품 개수에 y_count를 곱해서 누적시켜 준다.
                    //count[a][b] 는 a 제품을 만드는데 필요한 b제품의 개수를 의미한다.
                    for (int i = 1; i <= N; i++) {
                        count[y][i] += count[x][i] * y_count;
                    }
                    if(indeg[y] == 0) queue.add(y);
                }
            }

        for (int i = 1; i <= N; i++) {
            if (count[N][i] != 0) {
                sb.append(i).append(' ').append(count[N][i]).append('\n');
            }
        }

        System.out.println(sb);

    }
}
