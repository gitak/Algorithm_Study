package Chapter13;
import java.util.*;

public class P339 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //도시의 개수
        int m = sc.nextInt(); //도로의 개수
        int k = sc.nextInt(); //도로의 정보
        int x = sc.nextInt(); //출발 도시의 번호
        for(int i = 0; i <m; i++){
            for(int j = 0; j <= 1; j++){
                System.out.println(i+1+" "+j+1);//노드 연결성분 넣기
            }
        }
        sc.close();//입력종료

    }
}
