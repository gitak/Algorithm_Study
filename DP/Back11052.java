package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11052 {

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //필요한 카드의 개수
        int[] dp = new int[n+1];
        int[] price = new int[n+1]; // 카드팩의 가격을 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        //card 배열과 priority 배열 초기화
        for(int i = 1; i <= n; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }
        //입력 종료

        //Logic
        //1. 카드팩에 들어있는 카드가 적은 순서대로 산다. & 그 때의 카드 값이 최대값이 되어야 한다.
        //-> DP로 접근(1개의 카드를 살 때부터 시작하여 n개의 카드를 살때 최대값을 구하기)
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + price[j]);
            }
        }

        System.out.println(dp[n]);



        //그리디 알고리즘 반례
        //10
        //1 100 160 1 1 1 1 1 1 1  -> 답은 520이 나와야하는데 481이 출력된다.
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine()); //필요한 카드의 개수
//        double[] card = new double[n]; //카드팩에서 카드 1장당 가격을 담을 배열
//        int[] priority = new int[n];
//        int count = n; //남은 카드의 개수를 세기위한 변수
//        int price = 0; //가격을 저장하기 위한 변수
//        int idx = 0;
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        //card 배열과 priority 배열 초기화
//        for(int i = 0; i < n; i++){
//            card[i] = Double.parseDouble(st.nextToken()) / (i+1);
//            priority[i] = i+1;
//        }
//        for(int i = 0; i < n; i++){
//            for(int j = n-1; j > 0; j--){
//                if(card[j] > card[j-1]){
//                    double temp = card[j];
//                    card[j] = card[j-1];
//                    card[j-1] = temp;
//                    int x = priority[j];
//                    priority[j] = priority[j-1];
//                    priority[j-1] = x;
//                }
//            }
//        }
//        while (true){
//            if(count == 0){
//                break;
//            }
//            if(count - priority[idx] >= 0) {
//                count -= priority[idx];
//                price += (int) (card[idx] * priority[idx]);
//            }
//            else{
//                idx++;
//            }
//        }
//        System.out.println(price);
    }
}
