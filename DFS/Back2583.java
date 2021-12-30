package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back2583 {

    static int m; //모눈종이의 가로 길이
    static int n; //모눈종이의 세로 길이
    static int[][] map; //모눈종이
    static boolean[][] visited; //방문여부 확인
    //상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    //정사각형의 개수를 세기위한 변수
    static int count;

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();


        //1. 직사각형 그리기
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            //직사각형의 시작점과 끝점의 좌표
            int start_x = Integer.parseInt(st.nextToken());
            int start_y =  Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            //map에서 직사각형의 안에 있는 부분을 1로 채우기
            //좌표축을 바꿔서 map에 저장
            for(int x = m - end_y; x < m - start_y; x++){
                for(int y = start_x; y < end_x; y++){
                    map[x][y] = 1;
                }
            }
        } //입력 종료

        //2. 그려진 부분을 제외한 직사각형의 넓이 구하기
        //DFS를 통해 직사각형 넓이 구하기
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(map[i][j] == 0 && !visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    dfs(map, visited, i, j, count);
                    list.add(count);
                }
            }
        }
        //3. 직사각형의 넓이를 오름차순으로 정렬
        Collections.sort(list);

        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }


    static void dfs(int[][] map, boolean[][] visited, int x, int y, int cnt){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x,y));
        while (!q.isEmpty()){
            Pos p =  q.poll();
            for(int i = 0; i < 4; i++){
                int new_x = p.x + dx[i];
                int new_y = p.y + dy[i];

                //모눈종이 밖으로 나가지 않는 경우
                if(new_x >=0 && new_x < m && new_y >=0 && new_y < n){
                    //이동할 좌표가 방문하지 않았고 그려지지 않은 좌표인 경우
                    if(map[new_x][new_y] == 0 && !visited[new_x][new_y]){
                        visited[new_x][new_y] = true;
                        dfs(map, visited, new_x, new_y, count++);
                    }
                }
            }
        }
        return;
    }

    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
