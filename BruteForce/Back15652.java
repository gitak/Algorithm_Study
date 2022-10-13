package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back15652 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        input();
        //logic
        rec_func(1);
        System.out.println(sb.toString());
    }

    //n개중에서 m개를 순서없이 뽑는 경우
    static void rec_func(int k) {

        //1부터 m까지 탐색을 마친 경우
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else{
            int start = selected[k - 1];
            //뽑힌 숫자가 없는 경우
            if(start == 0) start = 1;
            for (int cand = start; cand <= n; cand++) {
                //k번째에 cand가 올 수 있는 경우
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
