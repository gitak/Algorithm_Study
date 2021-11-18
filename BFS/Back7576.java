package BFS;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Back7576 {
    static class tomato{ //토마토의 위치를 나타내기 위한 클래스
        int x;
        int y;
        tomato(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int m; //가로
    static int n; //세로
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int[][] board; //토마토 판
    static Queue<tomato> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m]; //토마토판

        q = new LinkedList<tomato>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) q.add(new tomato(i,j));
            }
        }

        System.out.println(BFS());
    }

    public static int BFS(){
        while (!q.isEmpty()){
            tomato t = q.poll();

            for(int i = 0; i < 4; i++){
                int new_x = t.x + dx[i];
                int new_y = t.y + dy[i];

                //보드판 밖으로 나가지 않았을 때
                if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < m){
                    //안익은 토마토가 있는 경우
                    if(board[new_x][new_y]  == 0){
                        q.add(new tomato(new_x,new_y)); //익은 토마토 추가

                        //익은 날짜를 얻기 위해 그 전의 위치의 값에서 +1  -> 놓친 요소
                        board[new_x][new_y] = board[t.x][t.y] + 1;
                    }
                }
            }
        }
        //최대 날짜를 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //안익은 토마토가 있는 경우
                if(board[i][j] == 0) return -1;

                result = Math.max(result,board[i][j]);
            }
        }
        //토마토가 모두 익은 경우 -> result는 1이 최대이다.
        if(result == 1){
            return 0;
        }
        else {
            return result-1; //걸린 일수는 최대 날짜에서 1을 빼줘야 한다.
        }

    }
}
