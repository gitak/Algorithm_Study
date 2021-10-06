package Backjoon;
import java.util.Scanner;
import java.util.Arrays;
public class Back18310 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //집의 개수
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();//입력 종료

        //Logic
        Arrays.sort(arr);

        //중간값에서 이동할수록 더해야할 양 옆 거리값이 증가 -> 중간값 찾기(이진 탐색과 연관)
        int mid = (n-1) / 2;
        System.out.println(arr[mid]);

        /* -> 시간 초과
       //2. 가장 작은 위치에 있는 값부터 거리 비교
        for(int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(arr[j] - arr[i]);
            }
            if(sum < min){ // 이전 min값을 sum값과 비교하여 더 작은 값이 min이 되도록 갱신
                min = sum;
                index = arr[i];
            }
        }

         */
    }
}
