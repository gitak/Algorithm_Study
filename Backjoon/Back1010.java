package Backjoon;
import java.util.*;

public class Back1010 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] arr1 = new int[t];
        int [] arr2 = new int[t];
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (m/2 < n) n = m - n; // nCr == nCn-r 반복문 횟수를 줄이기 위해 필요
            arr1[i] = n;
            arr2[i] = m;

        }
        sc.close(); //입력종료
//test
        for(int i = 0;i < t; i++){
            System.out.println(combination(arr2[i], arr1[i]));
        }

    }

    /* 조합으로 경우의 수 구하기
    public static int combination(int n, int r){
        if(n == r || r == 0) return 1;
        else{
            return combination(n-1, r-1) + combination(n-1,r);
        }
    }
     */

    public static long combination(int n, int r){
        long result = 0;
        long num1 = 1, num2 = 1, temp = 1;
        int i = n;
        for(int k = 0; k < r; k++,i--,temp++){
            num1 *= i;
            num2 *= temp;
        }
        result = num1 / num2;
        return result;
    }


}
