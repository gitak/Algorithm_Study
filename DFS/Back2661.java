package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2661 {
    static int n;
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //입력종료
        backtracking("");
    }

    //backtracking으로 순차적으로 조건에 맞는 수를 찾는 메서드
    public static void backtracking(String str){
        if(str.length() == n){
            System.out.println(str);
            System.exit(0); //최초 출력후 프로세스 강제 종료
        }

        //가장 작은 수를 만들기 위해서는 i=1부터 실행
        for(int i = 1; i <= 3 ; i++){
            if(isGoodSequence(str + i))
                backtracking(str + i);
        }
    }

    //좋은 수열인지 판별하는 메서드
    //마지막으로 들어온 문자열을 기준으로 길이가 1 부터 str.length()/2 까지 확인한다.
    public static boolean isGoodSequence(String str){
        for(int i = 1; i <= str.length()/2; i++){
            String start = str.substring(str.length() - 2*i, str.length() - i);
            String end = str.substring(str.length() - i, str.length());
            if(start.equals(end)) return false;
        }
        //문자열의 길이가 1인 경우 for문을 할 필요X(예외처리)
        return true;
    }
}
