package Graph;

import java.io.*;
import java.util.StringTokenizer;

public class Back1991 {

    static int[][] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        //이진트리 만들기
        tree = new int[26][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int left_child = st.nextToken().charAt(0) - 'A';
            int right_child = st.nextToken().charAt(0) - 'A';

            //비어있는 경우 -1을 대입('.'은 46이므로 'A'의 정수값인 65를 빼면 -19)
            tree[parent][0] = (left_child == -19)? -1 : left_child;
            tree[parent][1] = (right_child == -19)? -1: right_child;
        }

        preorder(0);
        sb.append('\n');
        inorder(0);
        sb.append('\n');
        postorder(0);
        sb.append('\n');

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }


    static void preorder(int node) {
        //탐색할 노드가 없는 경우
        if(node == -1) return;

        //현재 노드 출력 -> 왼쪽 자식 노드 탐색 -> 오른쪽 자식 노드 탐색
        sb.append((char)(node + 'A'));
        preorder(tree[node][0]);
        preorder(tree[node][1]);
    }

    static void inorder(int node) {
        if(node == -1) return;

        //왼쪽 자식 노드 탐색 -> 현재 노드 출력 -> 오른쪽 자식 노드 탐색
        inorder(tree[node][0]);
        sb.append((char)(node + 'A'));
        inorder(tree[node][1]);
    }

    static void postorder(int node) {
        if(node == -1) return;

        //왼쪽 자식 노드 탐색 -> 오른쪽 자식 노드 탐색 -> 현재 노드 출력
        postorder(tree[node][0]);
        postorder(tree[node][1]);
        sb.append((char) (node + 'A'));
    }
}
