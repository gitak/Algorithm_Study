package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back13144 {

    static int N;
    static int[] A;
    static int[] count; // [L..R-1] 까지 중복된 수가 있는지 확인하는 배열
    public static void main(String[] args) throws IOException {
        input();

        long ans = 0;

        // L마다 R 을 최대한 옮길 때
        for (int L = 1, R = 1; L <= N; L++) {

            //R을 최대한 옮기는 경우
            while (R  <= N && count[A[R]] == 0) {
                count[A[R]]++;
                R++;
            }

            //정답을 갱신한다 [L..R]
            ans += R - L;

            //L을 옮겨주면서 A[L]의 개수를 감소한다.
            count[A[L]]--;
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        count = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}
