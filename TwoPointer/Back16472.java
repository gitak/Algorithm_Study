package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back16472 {

    static int N, kind;
    static int[] count;
    static String sequence;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        int ans = 0;
        for (int L = 0, R = 0; R < sequence.length(); R++) {

            //R 번째 문자를 오른쪽에 추가
            add(sequence.charAt(R));

            //불가능하면 가능할 때 까지 L을 이동(R을 고정)
            while (kind > N) {
                erase(sequence.charAt(L++));
            }

            ans = Math.max(ans, R - L + 1);
        }

        System.out.println(ans);
    }

    //알파벳 x를 추가하는 메서드
    static void add(char x) {
        count[x - 'a']++;
        //x가 새로운 알파벳인 경우
        if (count[x - 'a'] == 1) {
            kind++;
        }
    }

    //알파벳 x를 제거하는 메소드
    static void erase(char x) {
        count[x - 'a']--;

        // 인식해야 하는 알파벳에서 빠지는 경우
        if (count[x - 'a'] == 0) {
            kind--;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sequence = br.readLine();
        count = new int[26];
    }
}
