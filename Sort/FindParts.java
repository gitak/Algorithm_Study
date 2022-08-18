package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindParts {
    static int[] store;
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        store = new int[n];

        st = new StringTokenizer(br.readLine());
        //매장의 정보 입력
        for (int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] customer = new int[m];
        //고객의 정보 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            customer[i] = Integer.parseInt(st.nextToken());
        }
        //입력 종료

        Arrays.sort(store);
        for (int i = 0; i < m; i++) {
            sb.append(findPart(0, store.length, customer[i])+" ");
        }

        bw.write(sb.toString()+"\n");
        br.close();
        bw.flush();
        bw.close();
    }

    //이진탐색
    static String findPart(int start,int end, int part) {
        //재귀함수 종료 조건
        if (start > end) {
            return "no";
        }
        int mid = (start + end) / 2;

        if (store[mid] == part) {
            return "yes";
        }
        else if (store[mid] > part) {
            return findPart(start, mid-1, part);
        }
        else {
            return findPart(mid+1, end, part);
        }
    }
}
