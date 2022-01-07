package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2178 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    //상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(String.valueOf(sb.charAt(j)));
            }
            sb.setLength(0); //stringBuilder 초기화
        }
        br.close(); //입력 종료

        bfs(map);
        System.out.println(map[N-1][M-1]);
    }

    static boolean isRange(int new_x, int new_y){
        return new_x >=0 && new_y >= 0 && new_x < N && new_y < M;
    }

    static void bfs(int[][] map){
        Queue<Pos> q= new LinkedList<>();
        q.add(new Pos(0,0));
        visited[0][0] = true;

        while (!q.isEmpty()){
            Pos p = q.poll();
            for(int i = 0; i < 4; i++){
                int new_x = p.x + dx[i];
                int new_y = p.y + dy[i];
                if(isRange(new_x,new_y) && !visited[new_x][new_y]){
                    if(map[new_x][new_y] == 0) continue;
                        //(new_x, new_y)로 갈 수 있을 때
                        //방문처리 후 map[new_x][new_y]값 갱신
                        visited[new_x][new_y] = true;
                        q.add(new Pos(new_x, new_y));
                        // 방문처리를 이용해 그 때의 map[new_x][new_y]값이 최소값이 된다(중복하여 더해질 일이 없다)
                        map[new_x][new_y] = map[p.x][p.y] + 1;
                }
            }
        }
    }

    static class Pos{
        private int x;
        private int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
