package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2805 {
    static int N, M;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    // H 높이로 나무들을 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 return하는 함수
    static boolean determination(int H) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (tree[i] > H) {
                sum += (tree[i] - H);
            }
        }

        return sum >= M;
    }

    static void logic() {
        int left = 0, right = 2000000000, answer = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while (left <= right) {
            int mid = (left + right) / 2;
            if (determination(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
        }
    }
}
