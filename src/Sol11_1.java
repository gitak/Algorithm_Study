import java.util.Scanner;

public class Sol11_1 {
    public static void main(String[] args) {
        //입력시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] guild = new int[n];
        int max = 0;
        int count = 0; //그룹의 수
        int remainder = 0; //그룹으로 안묶인 나머지 인원 수
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
            count += check[i] / (i+1) ;
            check[i] = check[i] % (i+1);
            if((check[i] + remainder) / (i+1) != 0 ){ //나머지 인원과 현재인원을 합쳤을 때 하나의 그룹이 되는 경우
                count++;
                check[i] = check[i] - remainder;
                remainder = check[i];
            }
            else{
                remainder += check[i];
            }
        }
        System.out.println(count);

    }
}
