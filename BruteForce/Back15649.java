package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back15649 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] selected;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {

        input();

        rec_func(1);

        System.out.println(sb.toString());

    }

    //n개중 m개를 중복없이 뽑는 경우
    static void rec_func(int k) {

        //selected[1..m] 까지 뽑은 경우
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        else{
            for (int cand = 1; cand <= n; cand++) {
                //cand가 사용된 경우
                if(isUsed[cand]) continue;

                //k번째에 cand가 올 수 있는 경우
                selected[k] = cand;
                isUsed[cand] = true;

                //K+1 ~ m까지 확인
                rec_func(k + 1);

                //원복
                selected[k] = 0;
                isUsed[cand] = false;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];
        isUsed = new boolean[n + 1];
    }
}
