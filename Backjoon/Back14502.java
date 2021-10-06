package Backjoon;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Back14502 {
    static class virus{ //virus의 위치를 나타내기 위한 클래스
        int x;
        int y;
        virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n,m;
    static int[][] map;
    static int[] dx={0,1,0,-1}; //시계방향 기준
    static int[] dy={1,0,-1,0};
    static int result = Integer.MIN_VALUE; //안전지역의 개수

    //벽 세우기
    public static void DFS(int depth){
        //벽을 3개 세운 경우
        if(depth == 3){
            BFS();
            return;
        }
        //벽을 3개 못 세운 경우
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //벽을 세울 수 있는 경우
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    DFS(depth + 1); // -> 벽을 3개 세운 뒤, 재귀호출 하도록 한다.
                    map[i][j] = 0; //map을 원래대로 돌리기
                }
            }
        }
    }

    public static void BFS(){
        int[][] virus_map = new int[n][m];
        Queue<virus> queue = new LinkedList<virus>();

        /*
        1차원 배열의 경우 배열.clone()으로 깊은 복사를 할 수 있다.
        하지만 2차원 배열은 이중 for문을 통해 깊은 복사를 할 수 있다.
        얕은 복사: 주소 값을 참조(원본 값이 바뀌면 같이 바뀐다.)
        깊은 복사: 새로운 메모리 공간에 원본 값을 복사         */

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                virus_map[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < n; i++){ //virus가 있는 위치를 virus_map에 넣기
            for(int j = 0; j < m; j++){
                if(virus_map[i][j] == 2){
                    queue.add(new virus(i,j));
                }
            }
        }

        while (!queue.isEmpty()){
            virus v = queue.poll();
            for(int i = 0; i < 4; i++){
                int new_x = v.x + dx[i];
                int new_y = v.y + dy[i];

                //map을 벗어나지 않기 위한 조건
                if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < m){
                    //바이러스가 퍼질 수 있는 경우
                    if(virus_map[new_x][new_y] == 0){
                        virus_map[new_x][new_y] = 2;
                        queue.add(new virus(new_x,new_y));
                    }
                }
            }
        }
        //안전한 공간의 개수
        safe(virus_map);

    }

    public static void safe(int[][] virus_map){
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(virus_map[i][j] == 0) count++;
            }
        }
        result = Math.max(result, count); // result 결과값 업데이트
    }

    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        sc.close(); //입력 종료
        //Logic
        DFS(0); // 벽을 세우면서 바이러스 뿌리기
        System.out.println(result);
    }
}
