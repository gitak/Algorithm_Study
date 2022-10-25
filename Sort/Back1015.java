package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back1015 {
    static int n;
    static A[] B;
    static int[] P;
    static StringBuilder sb = new StringBuilder();

    static class A implements Comparable<A> {
        /**
         * @Param idx A배열의 idx 위치를 기억하는 변수
         * @Param num A[idx]의 값
         */
        private int idx, num;

        public A(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(A a) {
            //Todo
            //1. num의 비내림차순
            //2. num이 같으면 idx 오름차순 -> java의 객체 정렬은 stable 하다.(같은 값을 가지면 원소순서가 그대로 보존)

            if (num == a.num) {
                return this.idx - a.idx;
            }
            return this.num - a.num;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    private static void output() {
        //Todo: B 배열 정렬하기
        Arrays.sort(B);

        //Todo: B 배열의 값을 이용해서 P 배열 채우기
        for (int i = 0; i < n; i++) {
            P[B[i].idx] = i;
        }

        for (int i = 0; i < n; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        B = new A[n];
        P = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            B[i] = new A(i, num);
        }
    }
}
