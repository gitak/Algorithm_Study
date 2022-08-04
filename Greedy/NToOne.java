package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class NToOne {
    public static void main(String[] args) throws IOException {
        int count = 0;
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //입력 종료

        while (n > 1) {
            //1.n이 k로 나눠지는 경우
            if (n % k == 0) {
                n /= k;
                count++;
                continue;
            }

            //2. n이 k로 안나눠지는 경우
            n -= 1;
            count++;
        }

        System.out.println(count);
    }
}
