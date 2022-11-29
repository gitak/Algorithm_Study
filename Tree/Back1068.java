package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back1068 {

    static int N,root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        //erased와 그의 부모 사이의 연결 끊어주기
        for (int i = 0; i < N; i++) {
            if (child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }

        //erased가 root인 경우 예외처리
        if(root != erased) DFS(root, -1);

        System.out.println(leaf[root]);
    }

    // dfs(x, par) := 정점 x 의 부모가 parent 일 때, Subtree(x) 의 leaf 개수를 세주는 함수
    static void DFS(int x, int parent) {
        if (child[x].isEmpty()) {
            leaf[x]++;
        }

        for (int y : child[x]) {
            if(y == parent) continue;
            DFS(y, x);
            leaf[x] += leaf[y];
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        leaf = new int[N];
        child = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int par = Integer.parseInt(st.nextToken());
            if (par == -1) {
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = Integer.parseInt(br.readLine());
    }
}
