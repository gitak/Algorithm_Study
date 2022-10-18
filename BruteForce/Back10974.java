package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back10974 {
    static int n;
    static int[] num, answer;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }

    static void rec_func(int k) {
        //1 ~ n 번째 까지 탐색을 마친 경우
        if (k == n + 1) {
            for (int i = 1; i <= n; i++) {
                sb.append(answer[i]).append(' ');
            }
            sb.append('\n');
        }
        //k ~ n까지 탐색
        else {
            for (int i = 1; i <= n; i++) {
                if (isUsed[i]) {
                    continue;
                }

                answer[k] = num[i];
                isUsed[i] = true;
                rec_func(k + 1);
                answer[k] = 0;
                isUsed[i] = false;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        num = new int[n + 1];
        answer = new int[n + 1];
        isUsed = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = i;
        }
    }
}
