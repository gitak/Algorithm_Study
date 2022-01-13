package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //연산의 개수
        Queue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            //0이 입력되는 경우
            if(x == 0){

                if(pq.isEmpty()){
                    list.add(0);
                    continue;
                }

                list.add(pq.poll());
            }
            pq.add(x);
        }

        for(int x : list){
            System.out.println(x);
        }
    }
}
