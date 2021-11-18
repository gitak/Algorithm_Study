package Greedy;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back1931 {
    static ArrayList<conference> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //회의의 최대개수

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); //회의 시작시간
            int end = Integer.parseInt(st.nextToken()); //회의 종료시간
            list.add(new conference(start, end));
        }
        br.close(); //입력종료

        //Logic
        Collections.sort(list); //시간이 빠른 순으로 정렬
        /*
        for(conference c : list){
            System.out.println(c.start+", "+c.end);
        }

         */

        //가장 빨리 끝나는 시간을 선택
        int count = 1;
        int end = list.get(0).end;

        //list의 가장 빨리 끝나는 시간부터 선택
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).start < end){ //list의 i번째 시작시간이 이전의 끝나는 시간보다 빠른 경우
                continue;
            }
            else{ //list의 i번째 시작시간이 이전의 끝나는 시간을 지났을 경우
                end = list.get(i).end;
                count++;
            }
        }
        System.out.println(count);
    }

    static class conference implements Comparable<conference>{
        int start; //시작시간
        int end; //종료시간
        conference(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        //conference클래스의 종료시간을 기준으로  비교하기 위해 Comparable인터페이스를 구현해야 한다.
        public int compareTo(conference o) {
            if(this.end - o.end == 0){ // 종료시간이 같은 경우 시작 시간이 빠른 순으로 정렬
                return this.start- o.start;
            }
            else{ //종료시간이 다르다면 종료시간이 빠른 순으로 정렬
                return this.end - o.end;
            }
        }
    }
}
