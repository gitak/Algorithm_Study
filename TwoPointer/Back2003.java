package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2003 {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        int R = 0, sum = 0, ans = 0;
        for (int L = 1; L <= N; L++) {
            //L - 1을 구간에서 제외하기
            sum -= A[L - 1];

            //R을 옮길 수 있을 때 까지 옮기기
            while (R + 1 <= N && sum < M) {
                sum += A[++R];
            }

            //[L..R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if(sum == M) ans++;
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}
