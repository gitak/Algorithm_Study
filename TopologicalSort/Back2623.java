package TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Back2623 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adj;
    static int[] indeg;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int singer_count = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= singer_count; j++) {
                int next = Integer.parseInt(st.nextToken());
                adj[prev].add(next);
                indeg[next]++;
                prev = next;
            }
        }

    }

    static void logic() {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }

        // 우선순위에 대한 조건을 간선으로 표현했으므로 위상정렬을 수행하면 된다.
        ArrayList<Integer> ans = new ArrayList<>();

            while (!queue.isEmpty()) {
                int x = queue.poll();
                ans.add(x);
                for (int y : adj[x]) {
                    indeg[y]--;

                    if (indeg[y] == 0) {
                        queue.add(y);
                    }
                }
            }

        if (ans.size() == N) {
            for (int x : ans) {
                sb.append(x).append('\n');
            }
        } else {
            sb.append(0).append('\n');
        }

        System.out.println(sb);
    }
}
