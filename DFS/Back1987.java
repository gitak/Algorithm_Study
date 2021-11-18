package DFS;
import java.util.Scanner;
import java.util.HashSet;

public class Back1987 {

    static char[][] map;
    static boolean[][] visited; //map의 방문여부를 확인할 2차원 배열
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int r; //세로의 길이
    static int c; //가로의 길이
    static int max = 0; // 말이 지날 수 있는 최대 칸수
    static HashSet<Character> hashSet = new HashSet<>(); //중복된 알파벳을 저장하지 않기 위해 HashSet 사용
    public static void main(String[] args) {
        //입력시작
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt(); //세로의 길이
        c = sc.nextInt(); //가로의 길이
        map = new char[r][c];
        visited = new boolean[r][c];
        sc.nextLine(); //버퍼 지우기

        for(int i = 0; i < r; i++){
            String temp = sc.nextLine();
            for(int j = 0; j < c; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        sc.close(); //입력 종료
        //Logic

        //초기 설정 (시작점 (0,0)을 기준으로 방문)
        visited[0][0] = true;
        hashSet.add(map[0][0]);

        //DFS실행
        DFS(0,0, 1);
        System.out.println(max);
    }

    public static int DFS(int x, int y, int count){
        if(max < count) // 말이 갈 수 있는 최대 칸수 갱신
            max = count;

       for(int i = 0; i < 4; i++){
           int new_x = x + dx[i];
           int new_y = y + dy[i];

           //map을 벗어나는 경우
           if(new_x < 0 || new_x >= r || new_y < 0 || new_y >= c){
               continue;
           }

           //새로운 위치가 지금까지 나오지 않은 알파벳이 있으면서 방문한 적이 없는 경우
           else if((!hashSet.contains(map[new_x][new_y])) && (!visited[new_x][new_y])){
               visited[new_x][new_y] = true;
               hashSet.add(map[new_x][new_y]);
               DFS(new_x, new_y, count+1);

               //방문했던 곳 원래대로 돌려놓기
               visited[new_x][new_y] = false;
               hashSet.remove(map[new_x][new_y]);
           }
       }
        return max;
    }
}
