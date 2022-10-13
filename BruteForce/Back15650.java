package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back15650 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] selected;


    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    //n개 중에서 m개를 순서없이 고르는 경우
    static void rec_func(int k) {

        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else {
            for (int cand = selected[k - 1] + 1; cand <= n; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];

    }
}
