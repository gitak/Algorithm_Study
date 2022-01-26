package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back12919 {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        br.close(); //입력 종료

        System.out.println(changeTintoS(S,T));
    }

    public static int changeTintoS(String S, String T) {
        if (S.length() == T.length()) {
            if (S.equals(T)) {
                return 1;
            }
            return 0;
        }

        int isPossible = 0;

        //S에서 T로 갈때, 새로운 문자열은 A---B가 될 수 없다.

        if (T.charAt(T.length() - 1) == 'A') {
            isPossible += changeTintoS(S, T.substring(0, T.length() - 1));
        }

        if (T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(T.substring(1));
            isPossible += changeTintoS(S, sb.reverse().toString());
            System.out.println(T +", "+isPossible);
        }

        return isPossible > 0 ? 1 :0;
    }
}
