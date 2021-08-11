package Chapter12;
import java.util.Scanner;

public class Sol12_1 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //입력 종료
        String temp = String.valueOf(n);
        int[] arr1 = new int[temp.length()/2];
        int[] arr2 = new int[temp.length()/2];
        int sum1 = 0;
        int sum2 = 0;
        //Logic
        for(int i =0; i < temp.length()/2; i++){
            arr1[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
            arr2[i] = Integer.parseInt(String.valueOf(temp.charAt((temp.length()/2)+i)));
            sum1 += arr1[i];
            sum2 += arr2[i];
        }

        if(sum1 == sum2){
            System.out.println("LUCKY");
        }
        else{
            System.out.println("READY");
        }
    }
}
