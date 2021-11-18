package BFS;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Back2589 {
    static int[] dx = {1, 0, -1, 0};// 시계방향 기준
    static int[] dy = {0, 1, 0, -1};
    static Queue q;
    static int n;
    static int m;
    static int result;
    static char[][] map;

    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        result = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int max = Integer.MIN_VALUE;
        sc.nextLine(); // 버퍼지우기
        map = new char[n][m];

        for(int i = 0; i < n; i++){
            String temp = sc.nextLine();
            for(int j = 0; j < m; j++){
                map[i][j] = temp.charAt(j);
            }
            //sc.nextLine();
        }
        sc.close(); //입력 종료
        //Logic

        q = new LinkedList(); //Queue생성

        //Queue에 계속 넣기
        for(int i = 0; i < n;i++) {
            for(int j = 0; j < m;j++) {
                if(map[i][j] == 'L') {
                    BFS(i,j);
                    if(result > max) {
                        max = result;
                    }
                    result = 0;
                }
            }
        }

        System.out.println(max);
    }
    private static void BFS(int i, int j){
        boolean[][] visited = new boolean[n][m];
        q.add(new pos(i,j,0));
        while(!q.isEmpty()) {
            pos temp = (pos) q.poll(); // temp 객체를 pos형으로 변환 & 가장 먼저 보관한 값 꺼내고 반환
            int x = temp.x;
            int y = temp.y;
            int count = temp.count;
            result = count; //현재 위치까지 걸린시간 저장
            visited[x][y] = true;
            for (int t = 0; t < 4; t++) { //4방향중 갈 수 있는 곳 검사
                int rx = x + dx[t];
                int ry = y + dy[t];
                if (rx < 0 || ry < 0 || rx >= n || ry >= m) { //map을 벗어냔 경우
                    continue;
                }
                else if (visited[rx][ry] == true || map[rx][ry] == 'W') { // 방문한 곳이거나 바다인 경우
                    continue;
                }
                else if (map[rx][ry] == 'L' && visited[rx][ry] == false) {
                    visited[rx][ry] = true;
                    q.add(new pos(rx, ry, count + 1));
                }
            }
        }
    }

     private static class pos { //내부 클래스로 선언 -> 위치와 시간을 저장할 클래스
        int x;
        int y;
        int count;
        pos(int x,int y,int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
}
