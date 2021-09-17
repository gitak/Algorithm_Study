package Backjoon;
import java.util.*;

public class Back1449 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 물이 새는 개수
        int l = sc.nextInt(); // 테이프의 길이
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close(); //입력 종료

        //Logic
        //1. 물이 새는 위치 오름차순 정렬
        for(int i = n-1; i > 0; i--){
            for(int j = 0;j < i;j++){
                int temp;
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //2. 테이프를 부쳐야 하는 구간 2배로 늘리기 -> 좌 우 0.5를 1로 생각하기
        boolean [] pipe = new boolean[2*(arr[n-1]+2)];
        int j = 0;
        int count = 0;
        for(int i = 1; i < pipe.length; i++){
            if(j < n) {
                if ((i+1) / 2 == arr[j]) {
                    pipe[i] = true;
                    pipe[i+1] = true;
                    j++;
                }
            }
        }

        for(int i = 0; i < pipe.length; i++){
            if(pipe[i]){ //물이 새는 위치를 테이프로 감싸기
                for(int k = 0; k < 2*l; k++){ // 위치 1의 시작 인덱스와 위치 2의 끝 인덱스 사이의 거리는 2가 된다.
                    if(i+k == pipe.length) break;
                    pipe[i+k] = false;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
