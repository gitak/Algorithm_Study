package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back15970 {

    static int n;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    private static void output() {
        int count = 0;
        //Todo 색깔별로 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (list[i].size() > 0) {
                //시작점과 끝점 처리
                count += list[i].get(1) - list[i].get(0);
                count += list[i].get(list[i].size() - 1) - list[i].get(list[i].size() - 2);
                //Todo 색깔별로 각 점마다 가장 가까운 점 찾아주기
                for (int j = 1; j < list[i].size() - 1; j++) {
                    count += Math.min(list[i].get(j) - list[i].get(j - 1), list[i].get(j + 1) - list[i].get(j));
                }
            }
        }

        System.out.println(count);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            list[color].add(pos);
        }

    }
}
