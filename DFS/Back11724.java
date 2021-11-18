package DFS;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back11724 {
    static int n; //정점의 개수
    static int m; //간선의 개수
    static int count;//연결요소의 개수
    static StringTokenizer st;
    static BufferedReader br;
    static List<Integer>[] list;
    static boolean[] check; //방문한 곳을 확인할 배열

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수
        check = new boolean[n+1];
        list = new ArrayList[n+1]; // list와 check 초기화

        for(int i = 1; i <= n; i++) { //인접리스트 초기화
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //정점 u와v의 연결성분 표시
            list[u].add(v);
            list[v].add(u);
        }
        br.close(); //입력 종료

        //Logic

        //1부터 방문하지 않은 곳이 있으면 DFS를 통해 방문처리후 연결요수의 개수 추가
        for(int i = 1; i <= n; i++){
            if(!check[i]){
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void DFS(int vertex){
        if(check[vertex]) //해당 정점을 방문한 경우
            return;
        check[vertex] = true;
        /* for - each문
        for(int x : list[vertex]){
            if(!check[x]){
                DFS(x);
            }
        }

         */
        //해당 정점과 연결된 정점들을 모두 방문처리
        for(int i = 0; i < list[vertex].size(); i++){
            if(!check[list[vertex].get(i)]){
                DFS(list[vertex].get(i));
            }
        }
    }
}
