package Backjoon;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;

public class Back2606 {
    static int count = 0;
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //컴퓨터 수
        int m = sc.nextInt(); //연결되어 있는 컴퓨터 쌍의 수
        boolean[] visited = new boolean[n+1]; //방문했는지 여부
        LinkedList<Integer>[] adjlist = new LinkedList[n+1]; //정점에 붙어있는 간선의 정보를 저장하기 위한 연결리스트

        for(int i = 0; i <= n; i++){
            adjlist[i] = new LinkedList<Integer>();
        }

        // 두 정점을 이어주는 간선만들기(양방향)
        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjlist[v1].add(v2);
            adjlist[v2].add(v1);
        }

        /*
        for(int i = 1; i <= n; i++){
            Collections.sort(adjlist[i]);
        }

         */

        sc.close(); //입력 종료

        BFS(1, adjlist, visited);
        System.out.println(count-1); //1번 컴퓨터 제외
    }

    public static void BFS(int v, LinkedList<Integer>[] adjlist, boolean[] visited){
        Queue <Integer> q = new LinkedList<Integer>();
        visited[v] = true; //탐색시작 노드에 방문표시
        q.add(v); //탐색시작 노드를 큐에 입력

        while (!q.isEmpty()){
            v = q.poll();
            //System.out.print(v+" ");
            count++;
            Iterator<Integer> iter = adjlist[v].listIterator(); // Iterator
            while(iter.hasNext()){ // 다음값이 있는지 체크
                int w = iter.next();
                if(!visited[w]){
                    visited[w] = true;
                    q.add(w);
                }
            }
        }

    }
}
