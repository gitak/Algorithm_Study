package TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Back2056 {

    static int N;
    static int[] indeg, time, time_done;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        indeg = new int[N + 1];
        time = new int[N + 1];
        time_done = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int x = Integer.parseInt(st.nextToken());
                adj[x].add(i);
                indeg[i]++;
            }
        }
    }

    static void logic() {
        Deque<Integer> queue = new LinkedList<>();

        //제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i = 1; i <= N; i++) {
            if(indeg[i] == 0) queue.add(i);
        }

        //위상정렬의 순서대로 time_done도 함께 계산하기
        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y : adj[x]) {
                time_done[y] = Math.max(time_done[y], time[x]);
                indeg[y]--;
                if (indeg[y] == 0) {
                    time[y] += time_done[y];
                    queue.add(y);
                }
            }
        }

        int min_time = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            min_time = Math.max(min_time, time[i]);
        }

        System.out.println(min_time);
    }
}
