package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back14225 {
    static int n;
    static int[] nums;
    static int[] sub = new int[2000001];

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1, 0);

        result();
    }

    private static void result() {
        for (int i = 1; i <= sub.length; i++) {
            if (sub[i] == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    //nums[1..n] 번째까지 선택하는 모든 경우
    static void rec_func(int k,int value) {
        //n번째까지 모두 선택한 경우
        if (k == n + 1) {
            sub[value] = 1;
        } else {
            //k번째 숫자를 선택한 경우
            rec_func(k + 1, value + nums[k]);
            //k번째 숫자를 선택하지 않은 경우
            rec_func(k + 1, value);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
