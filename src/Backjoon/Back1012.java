package Backjoon;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Back1012 {
    static int[][] map; //배추의 위치를 저장할 map
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int m; // 가로의 길이
    static int n; // 세로의 길이

    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트 케이스 개수
        int[] count = new int[t]; //필요한 최소 흰지렁이의 수를 담아놓을 배열

        for(int i = 0; i < t; i++) {
            m = sc.nextInt(); // 가로의 길이
            n = sc.nextInt(); // 세로의 길이
            map = new int[m][n]; // map 초기화
            int k = sc.nextInt(); // 배추의 개수

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1; // 배추의 위치 저장
            }
            for(int j = 0; j < m; j++){
                for(int r = 0; r < n; r++){
                    if(map[j][r] == 1) { // 배추가 있는 곳 일때
                        map[j][r] = 2; //지나간 표시
                        count[i]++;
                        DFS(j, r);
                    }
                }
            }
        }

        for(int i = 0; i < t; i++){
            System.out.println(count[i]);
        }
        sc.close(); //입력 종료
    }

    //배추가 연결되어 있는 부분을 하나로 처리하기 위한 메서드 -> DFS
    static void DFS(int x, int y){
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(x,y)); //q에 배추의 위치 넣기

        while (!q.isEmpty()){
            pos p = q.poll();

            for(int i = 0; i < 4; i ++){
                int new_x = p.x + dx[i];
                int new_y = p.y + dy[i];

                //새로운 좌표가 맵을 벗어나지 않았을 때
                //배추가 있는 경우
                if(new_x >=0 && new_x < m && new_y >=0 && new_y < n){
                    if(map[new_x][new_y] == 1){ //이동할 곳에 배추가 있을 때
                        map[new_x][new_y] = 2; // 지나간 경로를 '2'로 바꾸기
                        q.add(new pos(new_x,new_y));
                    }
                }
            }
        }
    }

    //위치를 나타내기 위한 클래스
    static class pos{
        int x;
        int y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
