package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back14267 {

    static int n,m;
    static ArrayList<Integer>[] children;
    static int[] compliment;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        dfs(1);
        for (int i = 1; i <= n; i++) {
            sb.append(compliment[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        children = new ArrayList[n + 1];
        compliment = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int par = Integer.parseInt(st.nextToken());
            if (par == -1) {
                continue;
            }
            children[par].add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            compliment[vertex] += weight;
        }
    }

    //내가 받은 칭찬을 부하직원에게 누적시켜주는 함수 -> 루트노드의 호출로 모든 자식노드를 한 번씩 접근
    static void dfs(int vertex) {
        for (int x : children[vertex]) {
            compliment[x] += compliment[vertex];
            dfs(x);
        }
    }
}
