package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jump {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //입력 종료


        System.out.println(solution(n));
    }

    //Logic
    //top-down vs bottom-up
    //0의 위치부터 시작하면 n보다 큰 경우도 처리해야 한다 -> n부터 시작해서 0에 도달하도록 한다. (n보다 커지는 경우를 처리할 필요x)
    public static int solution(int n) {
        int ans = 0;

        //n이 0이될 때 까지 반복
        while (n != 0) {
            //순간이동을 할 수 있는 경우
            if(n % 2 == 0){
                n /= 2;
            }
            //점프를 해야되는 경우
            else{
                n--;
                ans++;
            }
        }

        return ans;
    }
}
