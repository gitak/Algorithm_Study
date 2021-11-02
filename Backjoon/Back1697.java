package Backjoon;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back1697 {
    static int[] check; // 방문여부를 확인할 배열

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //수빈이의 위치
        int k = Integer.parseInt(st.nextToken()); //동생의 위치
        check = new int[100001]; // 수빈이와 동생이 위치할 수 있는 범위
        br.close(); //입력종료

        //Logic
        //최단시간을 묻는 문제 -> BFS나 DFS를 사용할 수 있는지 생각하기

        //예외 처리 -> 수빈이와 동생의 위치가 같은 경우
        if(n == k){
            System.out.println(0);
            return;
        }
        BFS(n,k);
        System.out.println(check[k]);

    }
    public static void BFS(int n, int k){ // BFS를 통해 check배열에는 각 위치에 최소 시간으로 도달할 수 있는 시간이 저장
        Queue<Integer> q = new LinkedList<>();
        check[n] = 0; // 수빈이의 위치 시간 0 으로 초기화
        q.offer(n);

        while (!q.isEmpty()){
            int x = q.poll();
            if(check[k] != 0) break; // 최소값을 찾은 경우

            if(((x-1) >= 0) && (check[x-1] == 0)){ // x-1 위치로 이동한 경우
                q.offer(x-1);
                check[x-1] = check[x] + 1; //해당 위치의 시간을 이전 시간에서 1초를 추가한 값으로 갱신
            }
            if((x < check.length - 1) && (check[x+1] == 0)){ // x+1 위치로 이동한 경우
                q.offer(x+1);
                check[x+1] = check[x] + 1;
            }
            if( (2*x < check.length) && (check[2*x] == 0)){// 2*x 위치로 이동한 경우
                q.offer(2*x);
                check[2*x] = check[x] + 1;
            }
        }
    }
}
