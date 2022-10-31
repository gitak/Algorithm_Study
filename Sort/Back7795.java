package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back7795 {
    static int[] A,B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            A = new int[N + 1];
            B = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            //B 배열의 이분탐색을 위해 정렬!
            Arrays.sort(B, 1, M + 1);

            int ans = 0;

            for (int i = 1; i <= N; i++) {
                // A[i] 를 선택했을 때, B 에서는 A[i]보다 작은 게 몇 개나 있는지 count하기
                ans += lower_bound(1, M, A[i]);
            }
            sb.append(ans).append('\n');
        }

       System.out.println(sb.toString());
    }

    // B[L...R] 에서 X 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
    // 그런 게 없다면 L-1 을 return
    private static int lower_bound(int left, int right, int X) {
        //만약 B[L...R] 중 X 이하의 수가 없다면 L - 1을 return 한다. (이전값)
        int result = left - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (B[mid] < X) {
                result = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return result;
    }
}
