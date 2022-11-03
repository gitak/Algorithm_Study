package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class SuperComputerCluster {
    static int N;
    static long B;
    static int[] computer;
    public static void main(String[] args) throws IOException {
        input();

        System.out.println(binary_search(B));
    }

    private static int binary_search(long B) {
        int left = 1;
        //N = 1 이고 computer[1]과 B가 최대일 때, 최고로 성능을 낼 수 있는 값
        long right = 2000000000;
        int result = 0;



        while (left <= right) {
            //left + right 값이 int범위를 넘어가면 오버플로우가 발생하기 때문에 mid 자료형을 long 타입으로 해야 한다.
            long mid = (left + right) / 2;
            long best_sum = 0;

            for (int i = 1; i <= N; i++) {
                if (mid > computer[i]) {
                    best_sum += (long) pow(mid - computer[i], 2);
                }

                if(best_sum > B) break;
            }

            if (best_sum > B) {
                right = mid - 1;
            } else {
                left = (int) mid + 1;
                result = (int)mid;
            }
        }

        return result;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        computer = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            computer[i] = Integer.parseInt(st.nextToken());
        }
    }
}
