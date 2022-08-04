package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LawOfLageNumbers {
    public static void main(String[] args) throws IOException {

        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int sum= 0;
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //입력종료

        Arrays.sort(arr);

        //m이 커질 경우 시간초과가 나올수 있으므로
        for (int i = 0; i < m; i++) {
            if (count == k) {
                count = 0;
                sum += arr[n - 2];
                continue;
            }
            sum += arr[n - 1];
            count++;

        }

        bw.write(sum + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
