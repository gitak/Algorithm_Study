package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back2110 {
    static int N, C;
    static int[] home;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    //D만큼의 거리 차이를 둘 때, C개 만큼의 공유기를 설치할 수 있는지 확인하는 메서드
    static boolean determination(int D) {

        // 제일 왼쪽 집부터 가능한 많이 설치해보자!
        // D 만큼의 거리를 두면서 최대로 설치한 개수와 C 를 비교하자.
        int count = 1;
        int last = home[1];
        for (int i = 2; i <= N; i++) {
            if(home[i] - last < D) continue;
            last = home[i];
            count++;
        }

        return count >= C;
    }

    static void logic() {
        Arrays.sort(home, 1, N + 1);
        int left = 1, right = 1000000000;
        int answer = 0;

        while (left <= right) {
            // [L ... R] 범위 안에 정답이 존재한다!
            // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
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
        C = Integer.parseInt(st.nextToken());
        home = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            home[i] = Integer.parseInt(st.nextToken());
        }
    }
}
