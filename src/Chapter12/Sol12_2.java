package Chapter12;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sol12_2 {
    public static void main(String[] args) {
        //입력시작
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();//입력 종료
        String[] arr1 = new String[input.length()]; //알파벳 담기
        int count1 = 0, count2 = 0;
        String[] arr2 = new String[input.length()]; //숫자 담기
        //Logic
        //1. arr1에 문자를 넣고 arr2에 숫자를 넣는다
        for(int i = 0; i < input.length(); i++){
            if((input.charAt(i)- 'A') >=0){
                arr1[count1] = String.valueOf(input.charAt(i));
                count1++;
            }
            else{
                arr2[count2] = String.valueOf(input.charAt(i));
                count2++;
            }
        }
        //null을 제외한 문자들을 저장하기 위해 새로운 배열 선언
        String[] str1 = new String[count1];
        String[] str2 = new String[count2];
        for(int i = 0; i < str1.length; i++){
            str1[i] = arr1[i];
        }
        for(int i = 0; i < str2.length; i++){
            str2[i] = arr2[i];
        }

        //2.  문자열을 알파벳 순으로 정렬
        for(int i = str1.length -1; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                if(str1[j].compareTo(str1[j+1]) > 0){ //arr1[j]가 arr1[j+1]보다 사전적으로 뒤에 있는 경우
                    String temp = str1[j+1];
                    str1[j+1] = str1[j];
                    str1[j] = temp;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < str2.length ; i++){
            sum += Integer.parseInt(str2[i]);
        }

        for(int i = 0; i < str1.length; i++){
            System.out.print(str1[i]);
        }
        System.out.println(sum);
    }
}
