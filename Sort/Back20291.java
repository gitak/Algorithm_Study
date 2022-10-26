package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Back20291 {
    static int n;
    static HashMap<String, Integer> hashMap;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    private static void output() {

        //Todo 키 값들을 리스트로 받은 후, 사전순 정렬
        List<String> keyset = new ArrayList<>(hashMap.keySet());
        Collections.sort(keyset);

        for (String key : keyset) {
            sb.append(key).append(' ').append(hashMap.get(key));
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //Todo '.' 뒤에있는 확장자 파일이름만 남기기
            String temp = br.readLine();
            temp = temp.substring(temp.lastIndexOf('.') + 1);
            hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
        }
    }
}
