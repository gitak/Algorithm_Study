package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PlayFair {

    static StringBuilder sb = new StringBuilder();
    static String word;
    static ArrayList<Character> key = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        input();
        logic();
    }

    private static void logic() {
        letter_conversion();
        rule();
    }

    private static void rule() {
        for (int i = 0; i < word.length(); i+=2) {
            int row_front = key.indexOf(word.charAt(i)) / 5;
            int col_front = key.indexOf(word.charAt(i)) % 5;
            int row_back = key.indexOf(word.charAt(i + 1)) / 5;
            int col_back = key.indexOf(word.charAt(i + 1)) % 5;

            //규칙1. 같은 행이면 오른쪽으로 한칸 이동
            if (row_front == row_back) {
                sb.append(key.get(5 * row_front + (col_front + 1) % 5)).append(key.get(5 * row_back + (col_back + 1) % 5));
            }

            //규칙2. 같은 열이면 아래로 한칸 이동
            else if (col_front - col_back == 0) {
                sb.append(key.get(5 * ((row_front + 1) % 5) + col_front)).append(key.get(5 * ((row_back + 1) % 5) + col_back));
            }
            //규칙3. 같은 행도 같은 열도 아니면 서로의 열의 위치 변환
            else {
                sb.append(key.get(5 * row_front + col_back)).append(key.get(5 * row_back + col_front));
            }

        }

        System.out.println(sb.toString());
    }

    private static void letter_conversion() {

        for (int i = 0; i < word.length(); i++) {

            //마지막이 한 글자인 경우
            if (i == word.length() - 1) {
                sb.append(word.charAt(i)).append('X');
                break;
            }

            //1.두 글자가 같지만 XX는 아닌 경우
            if (word.charAt(i) == word.charAt(i + 1) && word.charAt(i) != 'X') {
                sb.append(word.charAt(i)).append('X');
                continue;
            }
            //2. 두 글자가 XX로 같은 경우
            if (word.charAt(i) == word.charAt(i + 1) && word.charAt(i) == 'X') {
                sb.append(word.charAt(i)).append('Q');
                continue;
            }

            sb.append(word.charAt(i)).append(word.charAt(i + 1));
            //그 다음 i+1 다음 글자로 이동
            i++;
        }

        word = sb.toString();

        //StringBuilder 초기화
        sb.setLength(0);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        String cipher = br.readLine();

        ArrayList<Character> password = new ArrayList<>();
        for (int i = 0; i < cipher.length(); i++) {
            if (!password.contains(cipher.charAt(i))) {
                password.add(cipher.charAt(i));
            }
        }

        ArrayList<Character> alphabet = new ArrayList<>();
        Character A = 'A';
        for (int i = 0; i < 26; i++,A++) {
            if(A == 'J') continue;
            if (!password.contains(A)) {
                alphabet.add(A);
            }
        }

        for (int i = 0; i < password.size(); i++) {
            key.add(password.get(i));
        }

        for (int i = 0; i < alphabet.size(); i++) {
            key.add(alphabet.get(i));
        }

    }
}
