package TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Back1005 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] indeg, D_done, D;
    static ArrayList<Integer>[] adj;


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            logic();
        }

        System.out.println(sb);
    }

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        D_done = new int[N + 1];
        D = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            D[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            indeg[y]++;
        }
    }

    private static void logic() throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                D_done[i] = D[i];
            }
        }

        // 위상 정렬 순서대로 D_done 계산을 함께 해주기
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
                //더 많이 걸리는 시간으로 갱신
                D_done[y] = Math.max(D_done[y], D_done[x] + D[y]);
            }
        }

        int W = Integer.parseInt(br.readLine());
        sb.append(D_done[W]).append('\n');
    }
}
