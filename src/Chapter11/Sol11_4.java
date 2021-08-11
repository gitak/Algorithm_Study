package Chapter11;

import java.util.Scanner;

public class Sol11_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력시작
        int n = sc.nextInt();
        int max = 0; //주어진 동전들의 최댓값
        int[] coin = new int[n];
        for(int i = 0; i < n ;i++){
            coin[i] = sc.nextInt();
           // max += coin[i];
        }//입력종료

        //Logic
        //1. 오름차순 정렬
        int temp;
        for(int i = n - 1; i > 0; i--){
            for(int j = 0; j < n-1; j++){
               if(coin[j] > coin[j+1]){
                 temp = coin[j];
                 coin[j] = coin[j+1];
                 coin[j+1] = temp;
               }
            }
        }

        //2. target을 1로 초기화한 뒤에, 작은 동전부터 확인해 target을 업데이트하여 찾는다
        int target = 1;
        for(int i = 0; i < n; i++){
            if(target < coin[i]){
                break;
            }
            target += coin[i];
        }

        System.out.println(target);

    }
}
