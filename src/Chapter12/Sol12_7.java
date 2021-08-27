package Chapter12;
import java.util.*;

public class Sol12_7 {
    public static ArrayList<Integer> dist;
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
        /*
        int[] sum = new int[home.size()]; //치킨집 중 m개를 선택했을 때 치킨거리가 가장 짧은 거리를 담을 배열

        for(int i = 0; i < chicken.size();i++){
            for(int j = 0; j < home.size();j++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
         */
        dist = new ArrayList<Integer>();
        boolean[] visited = new boolean[chicken.size()];
        int x = chicken.size();
        int y = home.size();
        combination(distance,visited,0,x,m);
        System.out.println(Collections.min(dist));

    }
    //조합 메서드 구현 -> 각각의 경우의 수(치킨집수Comb폐업시키지 않을 치킨집)중 집까지의 거리가 더 짧은 것을 선택 후 합하기 -> 차킨거리가 짧은 것을 선택
    public static void combination( int[][] distance,boolean[] visited,int start, int x, int r){
        if(r == 0){
            int min = 99999;
            int sum = 0;
            int count = 0;
            int[] num = new int[100];
            for(int i = 0; i < distance.length; i++){
                if(visited[i]){
                    num[count] = i;
                    count++;
                }
            }
            for(int i = 0; i < distance[0].length; i++){
                min = 99999;
                for(int j = 0; j < count; j++){
                    if(distance[num[j]][i] < min){
                        min = distance[num[j]][i];
                    }
                }
                sum += min;
            }

            dist.add(sum);
            return;
        }
        else{
            for(int i = start; i < x; i++){
                visited[i] = true;
                combination(distance,visited,start, i+1, r-1);
                visited[i] = false;
            }
        }


    }



}
