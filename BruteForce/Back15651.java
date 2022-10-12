package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Back15651 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }

    //입력
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];
    }

    //n개중 m개를 중복있게 뽑는 경우
    public static void rec_func(int k) {
        //만약 m개를 전부 고름 -> 조건에 맞는 탐색을 한가지 성공
        if (k == m + 1) {
            //selected[1..m] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }
        //만약 m개를 고르지 않음 -> k번째 부터 m번째 원소를 조건에 맞게 고르는 방법을 모두 시도
        else {
            for (int cand = 1; cand <= n; cand++) {
                selected[k] = cand;
                //k+1번부터 m번까지 모두 탐색
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }
}
