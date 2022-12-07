package TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back14676 {

    static int N, K, M;
    static int[] indeg, count, satisfaction;
    static ArrayList<Integer>[] adj;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        count = new int[N + 1]; //해당 건물이 지어졌는지 확인하는 변수
        satisfaction = new int[N + 1]; //선행 건물이 지어졌는지 확인하는 변수
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void logic() throws IOException {
        boolean abnormal = false;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            //건설하는 경우
            //x의 모든 선행 건물들이 지어졌는지 확인
            if (t == 1) {
                //선행 건물이 다 안지어진 경우
                if (satisfaction[x] < indeg[x]) {
                    abnormal = true;
                }

                count[x]++;
                //x 가 처음 지어진 경우, x가 영향을 주는 건물들에 "너희의 선행 건물 중 하나가 처음 지어졌어" 라고 알려주기
                if (count[x] == 1) {
                    for (int y : adj[x]) {
                        satisfaction[y]++;
                    }
                }
            }
            //파괴하는 경우
            else {
                //건설한 적 없는 x를 파괴하는 경우
                if (count[x] == 0) {
                    abnormal = true;
                }

                count[x]--;
                //x가 더 이상 남아있지 않는 경우, "너희의 선행 건물 중 하나가 사라졌어" 라고 알려주기
                if (count[x] == 0) {
                    for (int y : adj[x]) {
                        satisfaction[y]--;
                    }
                }
            }

        }

        if (abnormal) {
            System.out.println("Lier!");
        } else {
            System.out.println("King-God-Emperor");
        }
    }
}
