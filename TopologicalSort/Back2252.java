package TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Back2252 {

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indeg = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            //indegree 계산하기
            indeg[y]++;
        }
    }

    static void logic() {
        Deque<Integer> queue = new LinkedList<>();
        //제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i = 1; i <= N; i++) {
            if(indeg[i] == 0) queue.add(i);
        }

        //정렬될 수 있는 정점이 있는 경우
        //1. 정렬 결과에 추가하기
        //2. 정점과 연결된 간선 제거하기
        //3. 새롭게 "정렬될 수 있는" 정점 Queue에 추가하기
        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');
            for (int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
            }
        }

        System.out.println(sb);
    }
}
