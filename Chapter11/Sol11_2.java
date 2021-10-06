package Chapter11;

import java.util.Scanner;

public class Sol11_2 {
    public static void main(String[] args) {
        //입력 시작
        int max = 0;
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        sc.close();
        //입력종료

        int num = 0; //이전의 숫자를 담기 위한 변수
        for(int i = 0; i < temp.length(); i++){
            //문자열을 하나씩 문자로 쪼갠뒤, 문자를 문자열로 변환후 다시 문자열을 숫자로 변환
            int x = Integer.parseInt(String.valueOf(temp.charAt(i)));
            if(i == 0){ //첫번째 숫자인 경우
                max += x;
            }
            else{
                if((num == 0) || (num == 1) || (x == 0) || (x == 1)){ //현재 숫자보다 왼쪽의 숫자가 0이나 1일 경우 더하는 것이 최대
                  max += x;
                }
                else{
                    max *= x;
                }
            }
            num = x; //이전의 숫자를 저장
        }

        System.out.println(max);
    }
}
