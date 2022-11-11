package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back2473 {

    static int N;
    static int[] A;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();

        // 최소, 최대 원소를 빠르게 찾기 위해서 미리 정렬
        Arrays.sort(A, 1, N + 1);
        long best_sum = Long.MAX_VALUE;
        int cand1 = 0, cand2 = 0, cand3 = 0;

        //후보 3개를 골랐을 때, target, A[L], A[R] 순 일때,
        for (int i = 1; i <= N - 2; i++) {
            int target = -A[i];
            int L = i + 1, R = N;

            // L == R 인 상황이면 용액이 한 개 뿐인 것이므로, L < R 일 때까지만 반복
            while (L < R) {
                //1. 최적의 합인지 확인
                if (Math.abs(A[L] + A[R] -(long) target) < best_sum) {
                    best_sum = Math.abs(A[L] + A[R] - (long) target);
                    cand1 = -target;
                    cand2 = A[L];
                    cand3 = A[R];
                }

                if(A[L] + A[R] < target) L++;
                else R--;
            }
        }

        sb.append(cand1).append(' ').append(cand2).append(' ').append(cand3).append('\n');
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}

