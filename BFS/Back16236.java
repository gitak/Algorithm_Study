package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back16236 {
    static int n;
    static int[][] map;

    //아기상어의 위치를 담을 LinkedList
    static Queue<Pos> shark = new LinkedList<>();
    static int count, time;
    static int sharkSize = 2;
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    //먹이의 위치를 담을 우선순위 큐
    static Queue<Pos> feed = new PriorityQueue<>(new Comparator<Pos>() {
        //아기상어와 가장 가까울 때, 가장 위, 가장 왼쪽이 우선순위가 높도록 비교하는 메서드
        @Override
        public int compare(Pos o1, Pos o2) {
            if(o1.distance==o2.distance) {
                if(o1.x==o2.x) return o1.y-o2.y;
                else return o1.x-o2.x;
            }
            return o1.distance-o2.distance;
        }
    });

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark.add(new Pos(i,j,0));
                    map[i][j] = 0; // 상어의 처음 위치 초기화
                }
            }
        }
        br.close(); //입력 종료

        findFeed();
    }

    //map을 벗어나는지 확인하는 메서드
    static boolean range(int x, int y){
        return x>=0 && y >= 0 && x<n && y <n;
    }

    //아기상어가 먹이를 먹을 때 처리하기 위한 메서드
    static void eat(){
        Pos eat = feed.poll();
        count++;

        if(count == sharkSize){
            sharkSize++;
            count = 0;
        }
        //아기상어 위치 초기화
        shark.add(new Pos(eat.x, eat.y, 0));
        time += eat.distance;
        map[eat.x][eat.y] = 0;
        feed.clear();
    }

    static void findFeed(){
        while(true){
            boolean[][] visited = new boolean[n][n];

            while(!shark.isEmpty()){
                Pos temp = shark.poll();
                visited[temp.x][temp.y] = true;

                for(int i = 0; i < 4; i++){
                    int new_x = temp.x + dx[i];
                    int new_y = temp.y + dy[i];

                    //map을 안벗어나고 방문하지 않았을 때
                    if(range(new_x,new_y) && !visited[new_x][new_y]){
                        //아기상어가 이동할 수 있는 경우
                        if(map[new_x][new_y] >= 0 && map[new_x][new_y] <=sharkSize){
                            //먹이정보로 넣을 수 있는 경우
                            if(map[new_x][new_y] > 0 &&map[new_x][new_y] < sharkSize){
                                feed.add(new Pos(new_x, new_y, temp.distance+1));
                            }
                            //방문처리 후 shark의 이동경로 추가
//                            visited[new_x][new_y] = true;
                            shark.add(new Pos(new_x, new_y, temp.distance+1));
                        }
//                        else if(map[new_x][new_y]==0) {
//                            shark.add(new Pos(new_x,new_y,temp.distance+1));
//                            visited[new_x][new_y]=true;
//                        }

                    }
                }
            }

            if(!feed.isEmpty())
                eat();
            else // 먹을 수 있는 고기가 없는 경우
                break;
        }

        System.out.println(time);
    }

    //위치와 거리를 나타내기 위한 클래스
    static class Pos{
        private int x;
        private int y;
        private int distance;

        Pos(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}