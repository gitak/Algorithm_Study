package Backjoon;
import java.util.Scanner;


public class Back1987 {
    static char[][] map;
    public static void main(String[] args) {
        //입력시작
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(); //세로의 길이
        int c = sc.nextInt(); //가로의 길이
        map = new char[r][c];
        sc.nextLine(); //버퍼 지우기

        for(int i = 0; i < r; i++){
            String temp = sc.nextLine();
            for(int j = 0; j < c; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        sc.close(); //입력 종료
        //Logic

    }
}
