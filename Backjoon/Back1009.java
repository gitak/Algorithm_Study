package Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1009 {
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] pattern = new int[10][4];

        //a의 b제곱을 10으로 나누었을 때, 1~10까지의 일의 자리수를 배열에 넣기(최대4번까지 다른 수가 나옴)
        //11 = (10 + 1)이므로 10보다 큰 수는 1 ~10까지의 일의자리 수와 같다.
        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 4; j++){
                if((int) Math.pow(i, j) % 10 != 0) {
                    pattern[i - 1][j - 1] = (int) Math.pow(i, j) % 10;
                }
                else{
                    pattern[i - 1][j - 1] = 10;
                }
            }
        }

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a%10 == 0){// a가 10의 배수인 경우
                System.out.println(pattern[9][(b-1)%4]);
            }
            else{
                System.out.println(pattern[(a%10)-1][(b-1)%4]);
            }
        }
        br.close(); //입력종료
    }
}
