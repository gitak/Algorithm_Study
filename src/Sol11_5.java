import java.util.Scanner;

public class Sol11_5 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []ball = new int[n];
        for(int i = 0; i < n; i++){
            ball[i] = sc.nextInt();
        } //입력 종료

        //Logic
        //1. 작은 무게부터 오름차순 정렬
        int temp;
        for(int i = n-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(ball[j] > ball[j+1]){
                   temp = ball[j+1];
                   ball[j+1] = ball[j];
                   ball[j] = temp;
                }
            }
        }

        //2. 1부터 m까지 무게를 하나씩 증가시켜, 해당 무게와 그 무게보다 큰 개수 구하기
        int sum = 0;// 해당무게 보다 적거나 같은 공의 개수
        int count = 0; //해당 무게의 개수
        int comb = 0; //공의 조합 개수
        for(int i = 1; i <= m; i++){
            count = 0; //해당 무게 개수 초기화
            for(int j = 0; j < n; j++){
                if(ball[j] == i){
                    count += 1;
                }
            }
            sum += count;
            comb = comb + (n - sum) * count;
        }
        System.out.println(comb);
    }
}
