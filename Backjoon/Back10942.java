package Backjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back10942 {
    static int [] num; // 숫자를 저장할 배열
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //칠판에 적은 숫자의 개수;
        num = new int[n+1]; //배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine()); //질문의 개수

        //Logic
        //결과를 여러개 담을 때에는 StringBuilder 사용 -> 시간을 줄여준다.
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(Palindrome(s,e)){
                sb.append("1\n");
            }
            else{
                sb.append("0\n");
            }
        }
        br.close(); //입력 종료
        System.out.print(sb);
    }

    public static boolean Palindrome(int s, int e){
        if(s == e){
            return true;
        }
        else{
            int mid = (e - s) / 2; //s부터 e까지의 길이
            for(int i = 0; i <= mid; i++){
                //팰린드롬이 안되는 경우
                if(num[s+i] != num[e-i]){
                    return false;
                }
            }
            //팰린드롬이 되어서 for문을 탈출한 경우
            return true;
        }
    }
}
