package DFS;

import java.io.*;
import java.util.StringTokenizer;

public class Back14888 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] number;
    static int[] operator = new int[4];
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        number = new int[n];

        //입력 시작
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        //입력 종료

        dfs(number[0], 1);
        bw.write(max+"\n"+min+"\n");
        br.close();
        bw.flush();
        bw.close();
    }

    //모든 연산자를 넣었을 때 나올 수 있는 경우를 확인하기 위한 메서드
    static void dfs(int result, int idx) {

        //n번째 숫자까지 연산을 마친 경우 (재귀함수 탈출 조건)
        if (idx == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operator[i] > 0) {

                //해당 연산자 감소
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(result + number[idx], idx + 1);
                        break;
                    case 1:
                        dfs(result - number[idx], idx + 1);
                        break;
                    case 2:
                        dfs(result * number[idx], idx + 1);
                        break;
                    case 3:
                        dfs(result / number[idx], idx + 1);
                        break;
                }

                //재귀호출 종료시 해당 연산자 개수 복구
                operator[i]++;
            }
        }
    }

}
