import java.util.*;

public class Sol9_3 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //도시의 개수
        int m = sc.nextInt(); //통로의 개수
        int c = sc.nextInt(); //보내고자 하는 도시
        int count = 0  ; //메시지를 받는 총 도시의 개수
        final int INF = 999999999;
        int [][] map = new int[n][n];
        boolean [] check = new boolean[n]; //해당 노드에 방문했는지 변수
        int [] distance = new int[n]; //최단 거리를 저장할 변수
        int max = 0;

        for(int i = 0; i < n;i++){
            distance[i] = INF; //거리 값 초기화
            for(int j = 0; j < n ; j++){
                map[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++){ //map 초기화
            int num1 = sc.nextInt(); //특정도시 X
            int num2 = sc.nextInt(); //특정도시 Y
            map[num1-1][num2-1] = sc.nextInt(); //X에서 Y까지 걸리는 시간

        }

        sc.close(); //입력 종료

        //Logic

        //시작노드값 초기화
        distance[c-1] = 0;
        check[c-1] = true;

        //연결노드 distance 갱신
        for(int i = 0; i < n; i++){
            if(!check[i] && map[c-1][i] != INF){
                distance[i] = map[c-1][i];
            }
        }

        //시작 노드를 제외하고 n-1번 반복
        for(int a = 0; a < n-1; a++){
            int min = INF;
            int min_index = -1;

            for(int i = 0; i < n; i++){ //시작 노드에서 최소값 찾기
                if(!check[i]){
                    if(distance[i] < min){
                        min = distance[i];
                        min_index = i;
                    }
                }

            }

            check[min_index] = true;
            for(int i = 0; i < n; i++){
                //시작노드에서 i번째 노드까지 갈때 min_index를 거쳐서 가는 것과 비교
                if(!check[i] && map[min_index][i] != INF){
                    if(distance[i] > distance[min_index] + map[min_index][i]){
                        distance[i] = distance[min_index] + map[min_index][i];
                    }
                }
            }
        }
        //다익스트라 알고리즘 끝

        for(int i = 1; i < n; i++){
            if(max < distance[i]){
                max = distance[i];
            }
            if(map[c-1][i] != INF){
                count += 1;
            }
        }

        System.out.print(count+"  ");
        System.out.println(max );




    }
}
