package BFS;
import java.util.Scanner;
//import java.util.Queue;
//import java.util.LinkedList;

public class Back10026 {
    static int n;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static boolean[][] visited;
    //static Queue  q;
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        //q= new LinkedList<pos>();
        n = sc.nextInt();
        map = new char[n][n]; //map 초기화
        visited = new boolean[n][n]; //방문한 곳 초기화
        //visited_weak = new boolean[n][n]; //방문한 곳 초기화

        sc.nextLine(); // 버퍼에 있는 \n 지우기
        for(int i = 0; i < n; i++){
            String temp = sc.nextLine();
            for(int j = 0;j < n; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        sc.close(); //입력 종료

        //정상인이 보일 수 있는 범위 탐색
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    BFS(i,j,count);
                    count++;
                }
                else {
                    continue;
                }
            }
        }
        System.out.print(count+" ");

        count = 0; //count 초기화

        //적록색약인 사람이 보이는 범위 탐색
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]){
                    BFS_weak(i,j,count);
                    count++;
                }
                else{
                    continue;
                }
            }
        }
        System.out.println(count);


    }

    //정상인이 구별하는 범위 탐색
    public static void BFS(int x, int y,int count){
            visited[x][y] = true; //방문하기
            char check = map[x][y]; //현재 위치의 색깔 저장

            for(int i = 0; i < 4; i++){
                int new_x = x + dx[i];
                int new_y = y + dy[i];

                //map을 벗어나지 않는 경우
                if(new_x >=0 && new_x < n && new_y >=0 && new_y < n){
                    //방문하지 않은 곳이면서 다음색깔과 현재색깔이 같은 경우
                    if(!visited[new_x][new_y] && map[new_x][new_y] == check){
                        BFS(new_x,new_y, count);
                    }
               }
            }
    }

    //적록색약인 사람이 보이는 범위 탐색
    public static void BFS_weak(int x, int y, int count){
        visited[x][y] = false; //방문한 곳 뒤집기 -> 이미 정상인인 사람이 전부 다 탐색했으므로 방문하지 않은 위치가 true이다.
        char check = map[x][y];

        for(int i = 0; i < 4; i++){
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if(new_x >=0 && new_x < n && new_y >=0 && new_y < n){ //map을 벗어나지 않는 경우
                //아직 방문하지 않았을 때
                if(visited[new_x][new_y]){
                    //이전 색깔과 같은 경우
                    if(map[new_x][new_y] == check){
                        BFS_weak(new_x, new_y, count);
                    }

                    //이전 색깔이 'R'이나 'G' 일때, 다음 색깔이 'R'이나 'G'인 경우
                    else if ((check == 'G' && map[new_x][new_y] == 'R') || (check == 'R' && map[new_x][new_y] == 'G')) {
                            BFS_weak(new_x, new_y, count);
                        }
                }
            }
        }

    }
    static class pos{ //위치를 저장하는 클래스
        int x;
        int y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    /*

    public static void BFS_weak(int x, int y, int count){

        //Queue<pos> q = new LinkedList<pos>();
        //q.add(new pos(x,y));

        while(!q.isEmpty()){
            pos p = (pos) q.poll();
            visited[p.x][p.y] = false; //방문하기
            char check = map[p.x][p.y];

            for(int i = 0; i < 4; i++){
                int new_x = p.x + dx[i];
                int new_y = p.y + dy[i];

                if(new_x >=0 && new_x < n && new_y >=0 && new_y < n){ //map을 벗어나지 않는 경우
                    //아직 방문하지 않았고 이전 색깔과 같은 경우
                   if(visited[new_x][new_y] && map[new_x][new_y] == check){ //방문한 하지 않은 곳일때
                           q.add(new pos(new_x,new_y));
                   }
                   //아직 방문하지 않았고 이전 색깔이 'R'이나 'G'인 경우
                   if(visited[new_x][new_y] && (check  == 'R' || check == 'G')){
                       if(map[new_x][new_y] == 'R' || map[new_x][new_y] == 'G'){
                           q.add(new pos(new_x,new_y));
                       }
                   }

                }
            }

        }


    }

     */
}
