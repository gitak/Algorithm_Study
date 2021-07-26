import java.util.Scanner;

public class Sol10_1 {
    public static void main(String[] args) {
        //입력시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] guild = new int[n];
        int max = 0;
        int count = 0; //그룹의 수
        for(int i = 0 ; i < n; i++){
            guild[i] = sc.nextInt();
        }
        sc.close();//입력종료

        //Logic
        for(int i = 0; i < n; i++){
            if(max < guild[i]) {
                max = guild[i];
            }
        }

        int [] check = new int [max]; //공포도 별 인원수를 저장할 배열
        for(int i = 0; i < n; i++){
            check[guild[i]-1]++;
        }

        for(int i = 0; i < max; i++){ // 공포도가 적은 인원수부터 그룹으로 묶을 수 있는 갯수
            count += check[i] / (i+1);
        }
        System.out.println(count);

    }
}
