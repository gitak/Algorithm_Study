package BFS;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Back2667 {
    static int[][] map; //위치(지도)를 나타내기 위한 배열
    static int n; //지도의 크기
    static int count;//전체 단지수
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> list = new ArrayList<>(); //단지내 집의 수를 담기위한 ArrayList
    static boolean[][] visited; //해당 위치의 방문여부를 확인하기 위한 배열

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n]; //배열 초기화
        map = new int[n][n];

        //map 위치저장
        for(int i = 0 ; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        br.close(); //입력종료

        //Logic
        for(int i = 0; i < n; i++){
            for(int j= 0; j < n; j++){
                if(map[i][j] == 1 && !visited[i][j]){ //방문한 곳이 아니면서 집이 있는 경우
                   BFS(i,j);
                    count++;
                }
            }
        }

        Collections.sort(list);// 오름차순 정렬
        System.out.println(count);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    static void BFS(int x, int y){
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(x,y));
        visited[x][y] = true; //map의 (x,y) 방문처리
        int home_count = 1; // 현재 단지내 집수

       while(!q.isEmpty()) {
            pos p = q.poll();
            for (int i = 0; i < 4; i++) {
                int new_x = p.x + dx[i];
                int new_y = p.y + dy[i];

                //map을 벗어나지 않는 경우
                if(new_x >= 0 && new_x < n && new_y >=0 && new_y < n){
                    //새로운 위치에 집이 있고 방문한 적이 없는 경우
                    if(!visited[new_x][new_y] && map[new_x][new_y] == 1) {
                        q.add(new pos(new_x, new_y));
                        visited[new_x][new_y]= true;
                        home_count++;
                    }
                }
            }
        }
       //단지의 가구수 저장
        list.add(home_count);
    }

    static class pos{
        private int x;
        private int y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}