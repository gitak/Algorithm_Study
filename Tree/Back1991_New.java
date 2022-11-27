package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1991_New {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] childs;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    static void logic() {
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        sb.append('\n');

        System.out.println(sb);
    }

    //중위순회
    static void inOrder(int x) {
        if(x == -1) return;
        inOrder(childs[x][0]);
        sb.append((char) (x + 'A'));
        inOrder(childs[x][1]);
    }

    //전위순회
    static void preOrder(int x) {
        if(x == -1) return;
        sb.append((char) (x + 'A'));
        preOrder(childs[x][0]);
        preOrder(childs[x][1]);
    }

    //후위순회
    static void postOrder(int x) {
        if(x ==-1) return;
        postOrder(childs[x][0]);
        postOrder(childs[x][1]);
        sb.append((char) (x + 'A'));
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        childs = new int[26][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char curChar = st.nextToken().charAt(0);
            int curIdx = (int) (curChar - 'A');
            for (int j = 0; j < 2; j++) {
                char child = st.nextToken().charAt(0);
                if(child != '.') childs[curIdx][j] = (int) (child - 'A');
                else childs[curIdx][j] = -1; // child가 없는 경우 -1 저장
            }
        }
    }
}
