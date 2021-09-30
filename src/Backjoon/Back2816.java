package Backjoon;
import java.util.Scanner;

public class Back2816 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //채널의 수
        int idx1 = 0, idx2 = 0;
        sc.nextLine(); // 정수 입력한 뒤 남은 버퍼 지우기
        String[] channel = new String[n];
        for(int i = 0; i < n; i++){
            channel[i] = sc.nextLine();
            if(channel[i].equals("KBS1")) {
                idx1 = i; // KBS1의 위치 저장
            }
            else if( channel[i].equals("KBS2")){
                idx2 = i; //KBS2의 위치 저장
            }
        }
        sc.close(); //입력 종료

        //Logic
        if(idx1 > idx2){ // KBS2의 위치가 변하는 경우
            idx2++;
        }

        //화살표를 KBS1의 위치로 옮긴후, 맨 위로 위치변경
       for(int i = 0; i < idx1; i++){
           System.out.print("1");
       }
        for(int i = 0; i < idx1; i++){
            System.out.print("4");
        }

        //화살표를 KBS2의 위치로 옮긴 후, 두 번째로 위치변경
        for(int i = 0; i < idx2; i++){
            System.out.print("1");
        }
        for(int i = 0; i < idx2-1; i++){
            System.out.print("4");
        }
    }
}
