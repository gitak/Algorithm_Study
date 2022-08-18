package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeRiceCake {
    static int m;
    static int[] store;
    static int max;
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        store = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }
        //입력 종료

        Arrays.sort(store);

        int start = 0;
        int end = store[store.length - 1];

        max = store[0];
        max = findMax(start, end);
        System.out.println(max);

    }

    static int findMax(int start, int end) {
        int mid = (start + end) / 2;

        if (start > end) {
            return mid;
        }

        if (sumRiceCake(mid) < m) {
            return  findMax(start, mid - 1);
        } else {
            return findMax(mid + 1, end);
        }
    }

    static int sumRiceCake(int standard) {
        int sum = 0;
        for (int i = 0; i < store.length; i++) {
            if (store[i] <= standard) {
                continue;
            }
            sum += (store[i] - standard);
        }

        return sum;
    }
}
