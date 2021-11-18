package BruteForce;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Back1747 {
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close(); //입력종료

        //Logic
        if(n == 1){ //예외처리 (1은 소수가 아니다)
            System.out.println(n+1);
        }

        else{
            while(true) {
                if (palindrome(n)) { //회문인 경우가 소수인 경우보다 경우의 수가 더 적다
                    if(prime_num(n)){
                        System.out.println(n);
                        break;
                    }
                }
                n++;
            }
        }
    }

    public static boolean prime_num(int n){ //소수인지 판별하는 함수
        int count = 0;
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean palindrome(int n){ //회문인지 판별하는 함수
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(n));
        sb.reverse();
        //StringBuilder를 이용하여 문자열을 비교하려면, 반드시 sb.toString() 뒤에 equals함수를 이용하여 비교해야 한다.
        if(sb.toString().equals(String.valueOf(n))){
            return true;
        }
        else{
            return false;
        }
    }
}
