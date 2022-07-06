package Implementation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberString {
    static Map<String, Integer> map = createMap();
    public static void main(String[] args) {
        String s = "2three45sixseven";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        String total = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                if (sb.length() == 0) {
                    total += s.substring(i,i+1);
                }
                else{
                    total += stringToNumber(sb.toString());
                    total += s.substring(i, i + 1);
                    sb.setLength(0);
                }
            }else{
                sb.append(s.charAt(i));
            }
        }

        //s가 문자열로 마무리된 경우
        if (sb.length() != 0) {
            total += stringToNumber(sb.toString());
        }

        answer = Integer.valueOf(total);

        return answer;
    }

    //문자열에 해당하는 숫자로 바꿔주는 메서드
    static String stringToNumber(String s) {
        String temp = "";
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.substring(start, i+1))) {
                temp += String.valueOf(map.get(s.substring(start, i+1)));
                start = i + 1;
            }
        }

        return temp;
    }

    //0~9까지 숫자에 대응되는 영단어 hashmap에 저장하기 위한 메서드
    static Map<String, Integer> createMap() {
        Map<String, Integer> result = new HashMap<>();
        result.put("zero", 0);
        result.put("one", 1);
        result.put("two", 2);
        result.put("three", 3);
        result.put("four", 4);
        result.put("five", 5);
        result.put("six", 6);
        result.put("seven", 7);
        result.put("eight", 8);
        result.put("nine", 9);
        return Collections.unmodifiableMap(result);
    }

    //최적화된 풀이

//    public int solution(String s) {
//        int answer = 0;
//        StringBuilder sb = new StringBuilder("");
//        int len = s.length();
//        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
//        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
//
//        for(int i=0; i<10; i++){
//            s = s.replaceAll(alphabets[i],digits[i]);
//        }
//
//        return Integer.parseInt(s);
//    }
}
