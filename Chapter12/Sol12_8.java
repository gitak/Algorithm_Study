package Chapter12;
import java.util.*;

public class Sol12_8 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weak = new int[m];
        for(int i = 0; i < m; i++){
            weak[i] = sc.nextInt();
        }

        sc.nextLine();
        int k = sc.nextInt();
        int[] dist = new int[k];
        for(int i = 0; i < dist.length; i++){
            dist[i] = sc.nextInt();
        }
        sc.close();//입력 종료
        for(int i = m-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(weak[j] > weak[j+1]){
                    int temp = weak[j];
                    weak[j] = weak[j+1];
                    weak[j+1] = temp;
                }
            }
        }


    }

    public int solution(int n, int[] weak, int[] dist) {
        //Logic
        int answer = 0;


        return answer;
    }
}
