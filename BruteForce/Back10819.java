package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back10819 {

    static int[] nums;
    static boolean[] visited;
    static int[] selected;
    static int n;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        nums = new int[n];
        visited = new boolean[n];
        selected = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        br.close();//입력 종료

        dfs(0);
        System.out.println(max);
    }

    //순열을 구하는 메서드
    static void dfs(int count) {
        if (count == n) {
            max = Math.max(getResult(),max);
            getResult();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[count] = nums[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }

    //문제의 공식을 계산하는 메서드
    static int getResult() {
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(selected[i] - selected[i + 1]);
        }

        return sum;
    }
}
