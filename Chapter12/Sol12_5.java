package Chapter12;
import java.util.*;

public class Sol12_5 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //보드의 크기
        int k = sc.nextInt(); //사과의 개수
        int[][] map = new int[n][n];
        for(int i = 0; i < k;i++){ //해당 위치에 사과 넣기
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x-1][y-1] = 1;
        }
        int l = sc.nextInt(); //뱀의 방향전환 횟수
        sc.nextLine(); //개행문자(\n) 지우기 = 버퍼 지우기
        String[] str = new String [l];
        for(int i = 0; i < l; i++){
            str[i] = sc.nextLine();
        }
        sc.close(); //입력 종료

        //방향을 바꾸는 시간과 어느 방향으로 꺾는지 각각 배열에 저장
        int [] second = new int[l];
        String [] direction = new String[l];
        for(int i = 0; i < l;i++){
           String [] temp = str[i].split(" ");
           second[i] = Integer.parseInt(temp[0]);
           direction[i] = temp[1];
        }

        int[][] snake = new int[k+1][2]; //뱀의 몸통위치를 담을 2차원 배열
        int head_x = 0, head_y= 0;
        int count = 0; //뱀의 사과를 먹은 횟수
        int rotate = 0;
        int[] dx = {0,1,0,-1}; //시계방향으로 회전했을 때 인덱스값 변화
        int[] dy = {1,0,-1,0};
        int time = 0, t= 0;
        boolean check = false;

        int x1, x2, y1, y2;

        while(true){
            time++;
            head_x += dx[rotate]; head_y += dy[rotate]; // head의 위치
            System.out.println(head_x+" "+head_y);
            if(count > 3){ //뱀이 몸통이랑 부딫히는 경우
                for(int i = 1; i <= count; i++){
                    if(head_x == snake[i][0] && head_y == snake[i][1]){
                        check = true;
                        break;
                    }
                }
                if(check) break;
            }
            if(second[t] == time){
                if(t < l-1) {
                    switch (direction[t]) { //방향전환
                        case "D":
                            rotate++;
                            if (rotate == 4) rotate = 0;
                            break;
                        case "L":
                            rotate--;
                            if (rotate == -1) rotate = 3;
                            break;
                    }
                    t++;
                }
                else{ //t = l-1인 경우
                    switch (direction[t]) { //방향전환
                        case "D":
                            rotate++;
                            if (rotate == 4) rotate = 0;
                            break;
                        case "L":
                            rotate--;
                            if (rotate == -1) rotate = 3;
                            break;
                    }
                }

                 //뱀이 방향전환 후 이동하는 경우

                    if(map[head_x][head_y] == 1){ //이동한 칸에 사과가 있는 경우
                        count++;
                        map[head_x][head_y] = 0; // 먹은 사과 없애기
                        x1 = snake[0][0];
                        y1 = snake[0][1];
                        snake[0][0] = head_x;
                        snake[0][1] = head_y;// 몸통첫번째의 위치
                        for (int i = 1; i <= count; i++) { //뱀의 몸통위치 바꾸기
                            x2 = snake[i][0];
                            y2 = snake[i][1];
                            snake[i][0] = x1; //몸통의 위치 갱신
                            snake[i][1] = y1;
                            x1 = x2;
                            y1 = y2;
                        }
                    }

                    //이동한 칸에 사과가 없는 경우
                    else {
                        x1 = snake[0][0];
                        y1 = snake[0][1];
                        snake[0][0] = head_x;
                        snake[0][1] = head_y;// 몸통첫번째의 위치
                        for (int i = 1; i <= count; i++) { //뱀의 몸통위치 바꾸기
                            x2 = snake[i][0];
                            y2 = snake[i][1];
                            snake[i][0] = x1; //몸통의 위치 갱신
                            snake[i][1] = y1;
                            x1 = x2;
                            y1 = y2;
                        }
                    }
            }

             else if(head_x >= n || head_x < 0 || head_y >= n|| head_y < 0){ //뱀이 맵 밖으로 나가는 경우
                break;
            }

            else{ //뱀이 이동하는 경우

                if(map[head_x][head_y] == 1){ //이동한 칸에 사과가 있는 경우
                    count++;
                    map[head_x][head_y] = 0; // 먹은 사과 없애기
                    x1 = snake[0][0];
                    y1 = snake[0][1];
                    snake[0][0] = head_x;
                    snake[0][1] = head_y;// 몸통첫번째의 위치
                    for (int i = 1; i <= count; i++) { //뱀의 몸통위치 바꾸기
                        x2 = snake[i][0];
                        y2 = snake[i][1];
                        snake[i][0] = x1; //몸통의 위치 갱신
                        snake[i][1] = y1;
                        x1 = x2;
                        y1 = y2;
                    }
                }

                //이동한 칸에 사과가 없는 경우
                else {
                    x1 = snake[0][0];
                    y1 = snake[0][1];
                    snake[0][0] = head_x;
                    snake[0][1] = head_y;// 몸통첫번째의 위치
                    for (int i = 1; i <= count; i++) { //뱀의 몸통위치 바꾸기
                        x2 = snake[i][0];
                        y2 = snake[i][1];
                        snake[i][0] = x1; //몸통의 위치 갱신
                        snake[i][1] = y1;
                        x1 = x2;
                        y1 = y2;
                    }
                }
            }

            for(int i = 0; i <= count; i++){
                for(int j = 0; j < 2;j++){
                    System.out.print(snake[i][j]+"  ");
                }
            }
            System.out.println();
        }

        System.out.println(time);
    }
}
