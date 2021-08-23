package Chapter12;
import java.util.Scanner;

public class Sol12_4 {
    public static int n , m;
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        int[][] key = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                key[i][j] = sc.nextInt();
            }
        }
        n = sc.nextInt();
        int[][] lock = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lock[i][j] = sc.nextInt();
            }
        }//입력 종료
        System.out.println(solution(key,lock));
    }
    // 배열을 90도 회전하는 메서드
    static int [][] rotate(int[][] key){
        int x = key.length;
        int[][] rotate = new int[x][x];
        for(int i = 0; i < rotate.length;i++){
            for(int j = 0; j < rotate.length;j++){
                rotate[i][j] = key[x-1-j][i];
            }
        }
        return rotate;
    }

    //matrix값을 초기화하는 메서드
    static int [][] reset(int[][] before, int[][]after){
        int temp;
        int[][] reset = new int[before.length][before.length];
        for(int i = 0; i < before.length;i++){
            for(int j = 0; j < before.length;j++){
                temp = before[i][j];
                before[i][j] = after[i][j];
                after[i][j] = temp;
            }
        }
        return reset;
    }

        public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] matrix = new int[n+2*(m-1)][n+2*(m-1)];
        int count1 = 0; //lock에 저장된 1의합
        //matrix 중앙에 lock 값 저장
        for(int i = m-1; i < lock.length+m-1; i++){
            for(int j = m-1; j < lock.length+m-1;j++){
                matrix[i][j] = lock[i-(m-1)][j-(m-1)];
                if(lock[i-(m-1)][j-(m-1)] == 1) count1++;
            }
        }
        int[][] before = new int[n+2*(m-1)][n+2*(m-1)];
        before = matrix; //초기 matrix값 저장
        int count2 = 0; //key에 저장된 1의 합
        int n = 0; //회전횟수
        int check = count1; //matrix에 저장된 1의 개수
        for(int i = 0; i < matrix.length-(m-1); i++){
            for(int j = 0; j < matrix.length-(m-1); j++){
                n = 0;
                check = count1;
                while(n < 4) { //(i,j)에서 key값이 회전하는 경우
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            matrix[i + x][j + y] = key[x][y];
                            if (key[x][y] == 1) count2++;
                            if(matrix[i+x][j+y] == 1) check++;
                        }
                    }
                    if(count1+count2 == check){ //key값으로 lock이 열리는 경우
                        answer = true;
                        return answer;
                    }
                    else{ // key가 맞지 않는 경우
                           matrix = reset(before, matrix);
                           key = rotate(key);
                           count2 = 0; // matrix에서 key의 1의 개수 초기화
                           n++;
                    }
                }
            }
        }

        return answer;
    }

}
