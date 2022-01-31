package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1016 {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        br.close();//입력 종료

        int result = (int) (max - min + 1);
        int sqrt = ((int)Math.sqrt(max));
        //제곱수인 경우 true를 저장하는 배열
        boolean[] checkSqrt = new boolean[result];

        //제곱근까지 반복(에라토스테네스의 체 -> 소수 판별 알고리즘)
        for (long i = 2; i <= sqrt; i++) {
            long square = i*i;
            //min이 제곱수로 나눠지는 경우 start는 제곱수로 나눈 몫부터 진행
            long start = min % square == 0 ? (min/square) : (min/square) + 1;
            // min부터 max사이의 제곱수 판별
            for (long j = start; j * square <= max; j++) {
                checkSqrt[(int) ((j*square) - min)] = true;
            }
        }

        int count = 0;
        //제곱ㄴㄴ수 세기
        for (int i = 0; i < result; i++) {
            if (!checkSqrt[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
