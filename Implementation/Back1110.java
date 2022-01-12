package Implementation;
import java.util.Scanner;

public class Back1110 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int temp; //임시로 값을 담을 변수
        int[] num1 = new int[2]; // 초기 n값을 자리수마다 담을 배열
        int[] num2 = new int[2]; // 규칙에 따라 값을 자리수별로 담을 배열
        //입력종료

        //Logic
        if(n == 0){
            System.out.println(count+1);
        }
        else if(n >= 1 && n < 10){
            //처음 시작할 때 값 초기화
            num1[0] = 0;
            num1[1] = n;
            num2[0] = n;
            num2[1] = n;
            count++;
            while(true){
                if((num2[0]*10 +num2[1]) == n){
                    System.out.println(count);
                    break;
                }
                else{
                    temp = num2[0] + num2[1]; //이전 값 더하기
                    num2[0] = num2[1];
                    if(temp >= 10){ // 각 자리 수의 합이 10보다 큰경우
                        temp = temp % 10;
                    }
                    num2[1] = temp;
                    count++;
                }
            }
        }
        else{ //n이 10보다 큰 경우
            num1[0] = n / 10;
            num1[1] = n % 10;
            if(num1[0] + num1[1] >=10){
                temp = (num1[0] + num1[1]) % 10;
            }
            else{
                temp = num1[0] + num1[1];
            }
            num2[0] = num1[1];
            num2[1] = temp;
            count++;

            while(true){
                if((num2[0]*10 +num2[1]) == n){
                    System.out.println(count);
                    break;
                }
                else{
                    temp = num2[0] + num2[1]; //이전 값 더하기
                    num2[0] = num2[1];
                    if(temp >= 10){ // 각 자리 수의 합이 10보다 큰경우
                        temp = temp % 10;
                    }
                    num2[1] = temp;
                    count++;
                }
            }
        }
    }
}
