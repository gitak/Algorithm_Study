package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back3687 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] minDp = new long[101];

        //minDp초기화
        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        minDp[8] = 10;

        String[] add = {"1", "7", "4", "2", "0", "8"};

        //minDp[8]부터 할 경우 10 과 01 중 01이 뽑혀서 조건 위배 -> minDp[9]부터 하기
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String candidate = minDp[i - j] + add[j - 2];
                minDp[i] = Math.min(Long.parseLong(candidate), minDp[i]);
            }
        }


        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(minDp[n]+" "+max_matchstick(n));
        }
    }

    static String max_matchstick(int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            count = n / 2;
            for (int i = 0; i < count; i++) {
                sb.append(1);
            }

            return sb.toString();

        }else{
            sb.append(7);
            count = (n / 2) - 1;
            for (int i = 0; i < count; i++) {
                sb.append(1);
            }

            return sb.toString();
        }
    }
}
