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
        sc.nextLine(); //개행문자(\n) 지우기 = 버퍼 지우
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

        int count = 0; // 시간을 담기 위한 변수
        List<Integer>snake = new ArrayList<Integer>(); //뱀의 길이를 표현하기 위한 동적배열
        int[][] head = new int[n][n]; //벰의 머리 위치
        int x = 0, y= 0;
        int prev_x, prev_y;
        int[] dx = {0,1,0,-1}; //시계방향으로 회전했을 때 인덱스값 변화
        int[] dy = {1,0,-1,0};
        int t = 0;
        boolean check = false;
        /*
        while(true){
            count++;
            if(second[t] == count){

            }
            if(x>=10 || x < 0 || y >= 10|| y < 0){ //뱀이 맵 밖으로 나가는 경우
                break;
            }
            else{
                for(int i = 0; i < snake.size(); i++){ //뱀이 자기 자신의 몸통과 부딪히는지 확인
                       if(head[x][y] == snake.get(i)){
                           break;
                       }
                }
                if(check){ //뱀이 자기 자신의 몸통과 부딪히는 경우
                    break;
                }
                int temp;
                if(map[x][y] == 1){ //머리가 있는 곳에 사과가 있는 경우

                }


            }
        }


         */

    }
}
