package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Back1181 {

    static int n;
    static ArrayList<String> words;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    private static void output() {

        //Todo 1. 길이가 짧은 순서 2. 길이가 같으면 사전순
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for (String word : words) {
            sb.append(word).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            //중복 단어 처리
            if(words.contains(word)) continue;

            words.add(word);
        }
    }
}
