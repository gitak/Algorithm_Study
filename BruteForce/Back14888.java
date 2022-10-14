package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back14888 {
    static StringBuilder sb = new StringBuilder();
    static int n, max, min;
    static int[] number, order, operator;

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1,number[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }


    //order[1..n-1]에 연산자들이 순서대로 저장
    static void rec_func(int k, int value) {

        //완성된 식에 맞게 계산을 하여 정답을 갱신
        if (k == n) {
            max = Math.max(value, max);
            min = Math.min(value, min);
        }
        // k번째 연산자를 선택할 때
        else {
            for (int cand = 1; cand <= 4; cand++) {
                if (operator[cand] >= 1) {
                    operator[cand]--;
                    order[k] = cand;
                    int new_value = calculator(value, cand, number[k + 1]);
                    rec_func(k + 1, new_value);

                    operator[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    //피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        }
        else if (operator == 2) {
            return operand1 - operand2;
        }
        else if (operator == 3) {
            return operand1 * operand2;
        }
        else{
            return operand1 / operand2;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        number = new int[n + 1];
        order = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
}
