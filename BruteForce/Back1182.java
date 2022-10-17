package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1182 {
    static int n, s, ans;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1,0);

        //진부분집합이 아닌경우(예외 case)
        if (s == 0) {
            ans--;
        }

        System.out.println(ans);
    }

    //k번째 원소를 포함시킬지 결정하는 함수
    //value: k-1 번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value) {

        //부분수열을 하나 완성시킨 경
        if (k == n + 1) {
            //value가 s랑 같은지 확인
            if (value == s) {
                ans++;
            }
        }
        //k번째 원소를 포함시킬지 결정하고 재귀호출
        else {
            //k번째를 포함시키는 경우
            rec_func(k + 1, value + num[k]);
            //k번째를 포함시키지 않는 경우
            rec_func(k+1,value);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        num = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}
