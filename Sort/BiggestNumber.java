package Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BiggestNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        solution(numbers);

    }
    public static String solution(int[] numbers) {
        String answer = "";
        //정수형 배열을 문자열 배열로 변환
        List<String> numbers_list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            numbers_list.add(String.valueOf(numbers[i]));
        }

        //number_list로 만들 수 있는 큰 수를 내림차순으로 정렬
        numbers_list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String temp1 = o1 + o2;
                String temp2 = o2 + o1;

                if(Integer.valueOf(temp1) > Integer.valueOf(temp2)){
                    return -1;
                }
                else if (Integer.valueOf(temp1) < Integer.valueOf(temp2)){
                    return 1;
                }
                return 0;
            }
        });

        for(int i = 0; i < numbers_list.size(); i++){
            answer += numbers_list.get(i);
            //number_list에 0만 존재하는 경우 예외처리
            if(answer.charAt(0) == '0') answer = "0";
        }

        return answer;
    }
}
