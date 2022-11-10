package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1806 {

    static int N, S;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    //Two Pointer
    private static void logic() {
        int R = 0, sum = 0, ans = N + 1;

        for (int L = 1; L <= N; L++) {
            //L - 1을 구간에서 제외하기
            sum -= sequence[L - 1];

            //R을 옮길 수 있을 때 까지 옮기기
            while (R + 1 <= N && sum < S) {
                sum += sequence[++R];
            }

            //sum[L..R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }

        if (ans == N + 1) {
            ans = 0;
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        sequence = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }
}
