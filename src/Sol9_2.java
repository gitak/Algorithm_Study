import java.util.*;

public class Sol9_2 {
    public static void main(String[] args) {
        //입력 시작
        final int INF = 9999999;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int graph [][] = new int[n][n];
        //graph 초기화
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                if( i == j) {
                    graph[i][j] = 0;
                }
                else {
                    graph[i][j] = INF;
                }
            }
        }

        //graph 설정
        for(int i = 0; i < m ; i++){
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            graph[temp1-1][temp2-1] = 1;
            graph[temp2-1][temp1-1] = 1;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();
        sc.close(); //입력 종료

       //Logic
        //플로이드 마샬 알고리즘
        for(int t = 0; t < n; t++){ // t는 거쳐가는 노드
           for(int i = 0; i < n; i++){ //i는 시작하는 노드
               for(int j = 0; j < n; j++){ // j는 도착하는 노드
                   if(graph[i][j] > graph[i][t] + graph[t][j]){
                       graph[i][j] = graph[i][t] + graph[t][j];
                   }
               }
           }
       }

        //x번 회사에 못 도달하는 경우 나누기

       if(graph[0][k-1] == INF || graph[k-1][x-1] == INF){
           System.out.println(-1);
       }
       else{
           System.out.println(graph[0][k-1] + graph[k-1][x-1]);
       }

    }
}
