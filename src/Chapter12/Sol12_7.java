package Chapter12;
import java.util.*;

public class Sol12_7 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        ArrayList<Integer[]> home = new ArrayList<Integer[]>(); //집의 위치
        ArrayList<Integer[]> chicken = new ArrayList<Integer[]>(); //집의 위치
        // 집과 치킨집의 위치 저장
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
              map[i][j] = sc.nextInt();
              if(map[i][j] == 1) home.add(new Integer[]{i,j});
              if(map[i][j] == 2) chicken.add(new Integer[] {i,j});
            }
        } //입력 종료

        //Logic
        int[][] distance = new int[chicken.size()][home.size()]; // 집으로부터 치킨집까지의 거리를 담을 배열
        for(int i = 0; i < chicken.size(); i++) {//치킨거리를 각각 저장
            for (int j = 0; j < home.size(); j++) {
                distance[i][j] = Math.abs(home.get(j)[0]-chicken.get(i)[0])+Math.abs(home.get(j)[1]-chicken.get(i)[1]);
            }
        }
        int[] sum = new int[home.size()]; //치킨집 중 m개를 선택했을 때 치킨거리가 가장 짧은 거리를 담을 배열

        for(int i = 0; i < chicken.size();i++){
            for(int j = 0; j < home.size();j++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }


    }

    //조합 메서드 구현 -> 각각의 경우의 수(치킨집수C폐업시키지 않을 치킨집)중 집까지의 거리가 더 짧은 것을 선택 후 합하기 -> 차킨거리가 짧은 것을 선택
}
