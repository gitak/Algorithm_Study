package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back1920 {
    static int N, M;
    static int[] arr1, arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        //이분탐색을 위해 정렬
        Arrays.sort(arr1, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            if (binary_search(arr2[i])) {
                sb.append('1').append('\n');
            } else {
                sb.append('0').append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean binary_search(int X) {
         int left = 1;
         int right= N;
        while (left <= right) {
            int mid = (left + right) / 2;

            if(arr1[mid] == X) return true;

            if (arr1[mid] < X) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        return false;
    }

    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N + 1];

        //기본 StringTokenizer는 공백문자들(\t\n\r) 을 기준으로 나눈다.
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arr2 = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
    }
}
