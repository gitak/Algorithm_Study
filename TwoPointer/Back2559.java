package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2559 {

    static int N, K;
    static int[] temperature;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        int R = 0, sum = 0, ans = -100 * N;

        for (int L = 1; L + K - 1 <= N; L++) {
            //L - 1을 구간에서 제외하기
            sum -= temperature[L - 1];

            //R을 옮길 수 있을 때 까지 옮기기
            while (R + 1 <= L + K - 1) {
                sum += temperature[++R];
            }

            // [L ... R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            ans = Math.max(sum, ans);
        }

        System.out.println(ans);
    }

    private static void another_logic() {
        int best_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += temperature[i];
        }
        best_sum = Math.max(best_sum, sum);

        for (int L = 1, R = K + 1; R <= N; R++,L++) {
            sum += temperature[R] - temperature[L];
            best_sum = Math.max(best_sum, sum);
        }

        System.out.println(best_sum);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        temperature = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }
    }
}
