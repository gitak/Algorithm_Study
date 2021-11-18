package Math;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //달팽이가 올라가는 거리
        int b = Integer.parseInt(st.nextToken()); //달팽이가 떨어지는 거리
        int v = Integer.parseInt(st.nextToken()); //나무의 높이
        int count = 1; //걸린 날짜
        int diff = a-b;

        //반복문대신 나누기를 해서 반올림처리 한다.
        count +=  (int)Math.ceil((double) (v-a) / diff);
        System.out.println(count);
    }
}
