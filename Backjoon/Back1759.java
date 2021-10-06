package Backjoon;
import java.util.Scanner;
import java.util.Arrays;

public class Back1759 {
    static String[] word;
    static boolean[] visited;
    static int l;  // 암호의 길이
    static int c; // 주어진 알파벳 개수

    //백트래킹 이용 -> start기준 start보다 작으면 뽑을 후보에서 제외, count가 암호의 길이와 같으면 해당 case 확인
    public static void comb(int start, int count){
        if(count == l){ //암호길이와 같은 경우
            int vow = 0; //모음의 개수
            int cons = 0; //자음의 개수
            String ans = ""; //문자열을 저장할 변수
            for(int i = 0; i < c; i++){
                if(visited[i]){
                    ans += word[i];
                    if(word[i].equals("a") || word[i].equals("e") || word[i].equals("i")
                            || word[i].equals("o") || word[i].equals("u")) vow++;
                    else cons++;
                }
            }
            // 모음이 1개 이상이면서 자음이 2개 이상 쓰인 경우
            if(vow >=1 && cons>= 2) System.out.println(ans);
            return;
        }

        for(int i = start; i < c; i++){
            visited[i] = true;
            comb(i+1, count+1); // 다음 지점 탐색
            visited[i] = false; // 방문한 흔적 지우기
        }
    }


    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine(); //버퍼 지우기

        word = new String[c];
        visited = new boolean[c];
        for (int i = 0; i < c; i++) {
            word[i] = sc.next();
        }
        sc.close(); //입력 종료

        Arrays.sort(word); // 입력한 배열 정렬
        //Logic
        comb(0,0);
    }
}




