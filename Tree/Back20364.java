package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back20364 {

    static int N, Q;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    static boolean[] estate;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() throws IOException {
        //사고 싶은 땅에서 시작해서 루트 땅까지 진행하여 정답을 찾는다.
        while (Q-- > 0) {
            int x = Integer.parseInt(br.readLine()), res = 0;
            int y = x;

            while (x > 0) {
                if (estate[x]) { // 처음 마주치는 땅을 출력해야 하므로 가장 루트 아래까지 이동해야 한다.
                    res = x;
                }
                x /= 2; // x >>= 1; 과 동일
            }
            estate[y] = true;
            sb.append(res).append('\n');

        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        estate = new boolean[N + 1];
    }
}
