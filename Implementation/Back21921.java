package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back21921 {

    static int N, X;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visit = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void logic() {
        int count = 1;
        int sum = 0;
        for (int i = 1; i <= X; i++) {
            sum += visit[i];
        }
        int max = sum;

        for (int i = X + 1; i <= N; i++) {
            sum = sum + visit[i] - visit[i - X];
            if (max < sum) {
                max = sum;
                count = 1;
            } else if (max == sum) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
