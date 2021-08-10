import java.util.*;

public class Sol5_3 {
    public static int n, m;
    public static int[][] map;

    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = sc.next(); // \n은 str에 포함하면 안되므로 sc.next()를 써야한다.
            for(int j = 0; j < m; j++){
               map[i][j] = (str.charAt(j) - '0');
            }
            //sc.nextLine();
        }
        sc.close();//입력 종료

        // 모든 노드에 대해 음료수 채운다.
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }

    //Logic
    public static boolean dfs(int x, int y){
        // dfs탐색시 주어진 범위를 벗어난다면, 즉시 종료
        if(x<= -1 || x >= n || y <= -1 || y >= m){
            return false;
        }
        //구멍이 뚫린 부분을 찾으면 탐색
        if(map[x][y] == 0){
            //해당 노드를 방문 처리
            map[x][y] = 2;
            dfs(x-1, y);
            dfs(x,y-1);
            dfs(x+1,y);
            dfs(x,y+1);
            return true;
        }
        return false;
    }
}
