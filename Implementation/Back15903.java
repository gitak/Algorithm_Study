package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back15903 {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //카드의 개수
        int m = Integer.parseInt(st.nextToken()); // 카드를 합체하는 횟수
       Queue<Long> card = new PriorityQueue<>();
        long score = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            card.add(Long.parseLong(st.nextToken()));
        }
        br.close();//입력종료

        for(int i = 0; i < m; i++){
            long x = card.poll();
            long y = card.poll();
            card.add(x+y);
            card.add(x+y);
        }


        for(long x : card){
            score += x;
        }

        System.out.println(score);
    }
}
