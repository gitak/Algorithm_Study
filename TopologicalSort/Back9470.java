package TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Back9470 {

    static int T, K, M, P;
    static ArrayList<Integer>[] adj;
    static int[] indeg, order, maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input(br);
            logic();
        }
    }

    private static void input(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        adj = new ArrayList[M + 1];
        indeg = new int[M + 1];
        order = new int[M + 1];
        maxCount = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void logic() {
        Deque<Integer> queue = new LinkedList<>();
        //제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i = 1; i <= M; i++) {
            if(indeg[i] == 0){
                queue.add(i);
                order[i] = maxCount[i] = 1;
            }
        }

        // 정렬될 수 있는 정점이 있는 경우
        // 1. 정렬 결과에 추가하기
        // 2. 정점과 연결된 간선 제거하기
        // 3. 새롭게 "정렬 될 수 있는" 정점 Queue에 추가하기
        int ans = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            //만약 들어오는 순서 중 가장 큰 순서가 2개 이상이면 자신의 순서를 1 증가시킨다.
            if(maxCount[x] >= 2) order[x]++;
            ans = Math.max(ans, order[x]);
            for (int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
                // Stahler 순서 계산을 위해서 y번 정점에 들어오는 최대 순서를 갱신해준다.
                //x -> y 로 가장 큰 값이 2개 이상인 경우
                if(order[y] == order[x]) maxCount[y]++;
                //x -> y 로 가장 큰 값이 들어오는 경우
                else if (order[y] < order[x]) {
                    order[y] = order[x];
                    maxCount[y] = 1;
                }
            }
        }

        System.out.println(K+" "+ans);
    }
}
