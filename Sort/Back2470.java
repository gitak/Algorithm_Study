package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back2470 {

    static int N;
    static int[] solution;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        input();
        logic();
    }

    private static void logic() {
        //이분탐색을 위한 정렬
        Arrays.sort(solution, 1, N + 1);
        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        for (int left = 1; left <= N - 1; left++) {
            // solution[left] 용액을 쓸 것이기 때문에, -solution[left] 와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾기
            int candidate = lower_bound(left + 1, N, -solution[left]);

            // solution[candidate - 1] 와 solution[candidate] 중에 solution[left] 와 섞었을 때의 정보를 정답에 갱신시킨다.
            //Todo solution[left]와 더했을 때 solution[candidate] 보다 solution[candidate - 1]이 더 가까울 수 있다.

            //1. solution[left] + solution[candidate - 1]
            if (left < candidate - 1 && Math.abs(solution[left] + solution[candidate - 1]) < best_sum) {
                v1 = solution[left];
                v2 = solution[candidate - 1];
                best_sum = Math.abs(solution[left] + solution[candidate - 1]);
            }

            //2. solution[left] + solution[candidate]
            if (candidate <= N && Math.abs(solution[left] + solution[candidate]) < best_sum) {
                v1 = solution[left];
                v2 = solution[candidate];
                best_sum = Math.abs(solution[left] + solution[candidate]);
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb.toString());
    }

    // solution[left...right] 에서 value 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
    // 그런 게 없다면 right + 1 을 return 한다
    private static int lower_bound(int left, int right, int value) {

        int result = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (solution[mid] >= value) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solution = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
    }
}
