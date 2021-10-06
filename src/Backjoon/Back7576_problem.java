package Backjoon;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Back7576_problem {
    static int [][] map;
    static int []dx = {-1, 1, 0, 0}; //상하좌우
    static int []dy = {0, 0, -1, 1};
    static int n, m;
    static int count = 0; //최소로 걸리는 시간
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        Queue<pos> queue = new LinkedList<pos>(); //익은 토마토 위치 담기
        m = sc.nextInt(); //가로
        n = sc.nextInt(); //세로
        map = new int[n][m];
        int count1 = 0; //익은 토마토의 개수
        int count2 = 0; //익지 않은 토마토의 개수
        //map 만들기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    count1++;
                    queue.add(new pos(i,j));
                }

                else if(map[i][j] == 0) count2++;
            }
        }
        sc.close();//입력 종료

        //Logic
        // 이미 토마토가 다 익은 경우
        if(count2 == 0 && count1 != 0){
            System.out.println(0);
        }
        else { //익지 않은 토마토가 있는 경우 & 익은 토마토가 있는 경우
            //같은 시간에 pos의 위치를 저장하기 위한 배열
            // pos[] position = new pos [n*m];
            int num = 0;

            while (!queue.isEmpty()) { //같은 시간대의 익은 토마토의 위치를 position 배열에 담기
                pos p = queue.poll();
                num++;


                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < 4; j++) {
                        int new_x = p.x + dx[j];
                        int new_y = p.y + dy[j];

                        //map을 벗어나지 않는 경우
                        if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
                            if (map[new_x][new_y] == 0) {
                                queue.add(new pos(new_x, new_y));
                                map[new_x][new_y] = map[p.x][p.y] + 1;

                            }
                        }
                    }
                }
            }
            count2 = 0;// 안익은 토마토의 개수 초기화
            int result = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 0) {
                        count2++;
                    }
                    result = Math.max(result, map[i][j]);
                }
            }

            if(count2 != 0){
                System.out.println(-1);
            }
            else{
                System.out.println(result-1);
            }
        }


    }

    static class pos{ //익은 토마토의 위치를 나타내기 위한 클래스
        int x;
        int y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
