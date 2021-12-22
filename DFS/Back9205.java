package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back9205 {
    //플로이드-워셜 알고리즘: 그래프가 존재할때 모든 정점에서 다른 정점으로의 최단 거리를 구하는 알고리즘

    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //test case의 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); //편의점의 개수
            Pos[] points = new Pos[n + 3];
            int[][] dist = new int[n + 3][n + 3];

            //편의점의 위치 Pos배열에 넣기
            for (int j = 1; j < n + 3; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[j] = new Pos(x, y);
            }

            //위치를 토대로 해당 거리를 갈 수 있는지 dist배열에 기록
            for (int j = 1; j < n + 3; j++) {
                for (int k = 1; k < n + 3; k++) {
                    if (j == k) continue;
                    dist[j][k] = Math.abs(points[j].x - points[k].x) + Math.abs(points[j].y - points[k].y);
                    //if (dist[j][k] > 1000) dist[j][k] = 99999;
                }
            }

            //플로이드-워셜 알고리즘
            for (int k = 1; k < n + 3; k++) { //중간 지점
                for (int x = 1; x < n + 3; x++) { //출발 지점
                    for (int y = 1; y < n + 3; y++) { //도착 지점
                        if (x == y) continue; //자기자신인 경우
                        dist[x][y] = Math.min(dist[x][k] + dist[k][y], dist[x][y]);
                    }
                }
            }

            boolean[] visit = new boolean[n+3];
            visit[1] = true;
            check = false;
            DFS(1,dist,visit);
            if(check){
                sb.append("happy\n");
            }
            else{
                sb.append("sad\n");
            }

        }
        System.out.println(sb.toString());
    }

    //DFS를 이용해 현재 위치에서 1000m 이하로 갈 수 있는 거리만 방문
    public static void DFS(int now, int[][] dist, boolean[] visit) {
        if(check) return; //이미 방문한 경우
        if(now == dist.length-1){ // 마지막까지 도달한 경우
            check = true;
            return;
        }

        for(int i = 1; i < dist.length; i++){
            if(!visit[i]){
                if(dist[now][i] <= 1000){
                    visit[i] = true;
                    DFS(i,dist,visit);
                }
            }
        }

    }

    public static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}