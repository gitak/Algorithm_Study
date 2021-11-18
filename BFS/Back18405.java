package BFS;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Back18405 {
    static int [][] map; //바이러스가 위치하는 map
    static boolean [][] visited;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int s; //기준이 되는 초
    static int n; // 시험관의 길이
    static int x, y;
    static PriorityQueue<Pos> pq = new PriorityQueue<>();
    // 우선순위 큐란? : 큐에서 pop 할 때 자기가 정한 기준으로 뺄 수 있는 것.
    // 우선순위 큐를 쓰는 이유?
    // 1. 제일 먼저 고려해야 할 것 : 시간대가 작은 것 부터 뺴야한다  큐에 2초  /1초  이렇게 2개 있을경우 1초 부터 빼야함
    // 2. 시간대가 같을시 작은 바이러스 숫자를 빼야 함.

    //우선순위 큐를 구현하기 위해 Comparable 인터페이스 구현
    static class Pos implements Comparable<Pos>{ //좌표의 현재 위치를 저장하는 클래스
        int x;
        int y;
        int time;
        int virus_num;
        Pos(int x, int y, int time, int virus_num){
            this.x = x;
            this.y = y;
            this.time = time; // 바이러스 퍼질 때 걸리는 시간
            this.virus_num = virus_num; //그 칸에 해당하는 바이러스 번호
        }

        @Override
        public int compareTo(Pos o) {
            //시간을 기준으로 우선순위 큐 비교 -> 시간이 낮을 수록 우선순위가 높다.
            //시간이 같을 때, 바이러스 번호가 작은 것이 우선순위가 높다.
            if(this.time - o.time == 0){
                return this.virus_num - o.virus_num;
            }
            // 시간이 다르다면 시간이 작은것이 우선순위가 더 높다.
            return this.time - o.time;
        }
    }

    public static void BFS(){
        while (!pq.isEmpty()){
            Pos p = pq.poll();

            //주어진 시간대를 넘어가면 '0' 출력 -> 해당 위치에 도달했을 때 s초가 지난 경우
            if(p.time > s){
                System.out.println(0);
                return;
            }

            //p.time <= s 일때와 같다 -> 앞에 if문에서 걸러지기 때문
            //주어진 좌표와 같고 해당 위치에 바이러스가 있을 때
            if(p.x == x-1 && p.y == y-1 && map[p.x][p.y] != 0){
                System.out.println(p.virus_num);
                return;
            }

            for(int i = 0; i < 4; i++){
                int new_x = p.x + dx[i];
                int new_y = p.y + dy[i];

                //map을 벗어나지 않고
                //해당 위치가 '0'인 경우 -> 방문할 수 있는 경우
                if(new_x >=0 && new_x < n && new_y >=0 && new_y < n){
                    if(!visited[new_x][new_y]){
                        visited[new_x][new_y] = true;
                        map[new_x][new_y] = p.virus_num;
                        pq.add(new Pos(new_x, new_y,p.time+1, p.virus_num));
                    }
                }
            }

        }
    }


    public static void main(String[] args) {
        //입력시작
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt(); // 바이러스 종류의 개수
        map = new int[n][n]; //map과 visited 초기화
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j= 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // s초 (x,y)의 바이러스 종류
        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        sc.close(); //입력 종료

       //Logic

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //해당위치에 바이러스가 있는경우
                if(map[i][j] != 0){
                    visited[i][j] = true; //방문처리
                    pq.add(new Pos(i, j, 0, map[i][j])); //우선순위 큐에 넣기 -> 우선 순위가 높은것 부터 뺄 수 있다.
                }
            }
        }
        BFS();
    }
}
