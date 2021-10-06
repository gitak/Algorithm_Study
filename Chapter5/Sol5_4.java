package Chapter5;

import java.util.Scanner;

public class Sol5_4 {
    public static int n, m;
    public static int [][] map;
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int [n][m];

        for(int i = 0; i < n; i++){
            String temp = sc.next();
            for(int j = 0; j < m; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        } //입력 종료
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(bfs(i,j)){

                }
            }
        }
    }
    public static boolean bfs(int x, int y){
        //최단거리로 가려면 왼쪽이나 아래쪽으로 움직여야 한다.

        //주어진 미로를 벗어날 경우 즉시 종료
        if(x <= -1 || x >=n || y <= -1 || y >= n){
            return false;
        }
        //몬스터가 없는 경로로 이동
        else if(map[x][y] == 1){
            map[x][y] = 2; //방문처리
            bfs(x+1,y);
            bfs(x,y+1);

        }
        else{
            return false;
        }
        return false;
    }

}
