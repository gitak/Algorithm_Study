package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back2470_Another {
    static int N;
    static int[] solution;

    public static void main(String[] args) throws IOException {
        input();

        // 최소, 최대를 빠르게 알기 위한 정렬
        Arrays.sort(solution, 1, N + 1);
        int L = 1, R = N;
        int best_sum = Integer.MAX_VALUE;
        int best_left = 0, best_right = 0;
        while (L < R) {
            if (Math.abs(solution[L] + solution[R]) < best_sum) {
                best_sum = Math.abs(solution[L] + solution[R]);
                best_left = solution[L];
                best_right = solution[R];
            }

            if (solution[L] + solution[R] < 0) {
                L++;
            } else {
                R--;
            }
        }

        System.out.println(best_left+" "+best_right);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solution = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
    }

}
