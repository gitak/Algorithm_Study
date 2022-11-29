package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back9489 {

    static int N, K;
    static int[] tree, parent;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if(N == 0 && K == 0) break;
            logic();
        }

        System.out.println(sb);
    }

    private static void logic() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        // 각 노드의 부모 노드 인덱스를 계산하자. 루트 노드가 1번 노드임을 주의하라.
                // 편의상 0번 정점의 부모를 -1 로 하자.
        parent[0] = -1;
        parent[1] = 0;

        // last := 이번에 자식 정점들을 찾을 노드의 인덱스
        int last = 1;
        for (int i = 2; i <= N; i++, last++) {
            for (; i <= N; i++) { // i번부터 연속한 수를 가진 정점을 모두 last의 자식으로 묶는다.
                parent[i]= last;
                if (i < N && tree[i] + 1 != tree[i + 1]) {
                    break;
                }
            }
        }

        int kIdx = 0;  // 수가 K인 정점의 인덱스
        for (int i = 1; i <= N; i++) if (tree[i] == K) kIdx = i;

        int ans = 0;
        for (int i = 1; i <= N; i++){
            // 사촌 := 부모의 부모는 동일하나 부모는 다른 정점의 개수
            if (parent[parent[i]] == parent[parent[kIdx]] && parent[i] != parent[kIdx])
                ans++;
        }

        sb.append(ans).append('\n');
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new int[N + 1];
        parent = new int[N + 1];
    }
}
