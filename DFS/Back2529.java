package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Back2529 {

    static String[] sign;
    static int k; //부등호의 개수
    static boolean[] visited;
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        visited = new boolean[10];
        sign = br.readLine().split(" ");
//        for(int i = 0; i < k; i++){
//            sign[i] = st.nextToken();
//        }
        br.close(); //입력 종료

        dfs("", 0);
        Collections.sort(answer);
        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));

    }

    static void dfs(String number, int depth){

        //k개의 부등호 순서를 만족하는 경우
        if(depth == k+1){
            answer.add(number);
            return;
        }

        //0~9까지 가능한 숫자중에서
        for(int i = 0; i <= 9; i++){
            //해당 위치를 이미 방문한 곳인 경우 skip
            if(visited[i]) continue;

            //처음 dfs를 하는 경우나 부등호관계를 만족하는 경우
            if(depth == 0 || checkSignNumber(number.charAt(number.length() - 1) - '0', i, sign[depth - 1])){
                visited[i] = true;
                dfs(number + i, depth + 1);
                visited[i] = false;
            }
        }
    }

    //a와 b가 부등호관계를 만족하는 정수인지 확인하는 메서드
   static boolean checkSignNumber(int a, int b, String sign){
        if(sign.equals("<"))
            return a < b;
        else{
            return a > b;
        }
   }
}
