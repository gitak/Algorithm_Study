package Math;

import java.io.*;
import java.util.StringTokenizer;

public class Back1717 {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //부모노드 초기화
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //합집합인 경우
            if (calc == 0) {
                union(x,y);
            }else{
                x = find(x);
                y = find(y);
                if (x == y) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //x의 부모노드를 찾는 메서드
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }

    //x(노드)집합과 y(노드)집합을 합치는 메서드
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        }else{
            parent[x] = y;
        }
    }
}
