package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2251 {

    static class Bucket{
        int[] bucket;

        public Bucket(int[] bucket) {
            this.bucket = new int[3];
            for (int i = 0; i < 3; i++) {
                this.bucket[i] = bucket[i];
            }
        }

        //from 물통에서 to 물통으로 물을 옮기는 메서드
        Bucket move(int from, int to, int[] Limit) {

            int[] new_bucket = {bucket[0], bucket[1], bucket[2]};

            //from 물통에서 to 물통으로 전부 부을 수 있는 경우
            if (bucket[from] + bucket[to] <= Limit[to]) {
                new_bucket[to] = bucket[from] + bucket[to];
                new_bucket[from] = 0;
            }
            //from 물통의 일부만 to 물통으로 옮길 수 있는 경우
            else {
                new_bucket[from] -= Limit[to] - new_bucket[to];
                new_bucket[to] = Limit[to];
            }

            return new Bucket(new_bucket);
        }
    }

    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        bfs(0, 0, Limit[2]);
        for (int i = 0; i <= 200; i++) {
            if(possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static void bfs(int x1, int x2, int x3) {
        //시작위치 방문처리
        Queue<Bucket> q = new LinkedList<>();
        visited[x1][x2][x3] = true;
        q.add(new Bucket(new int[]{x1, x2, x3}));

        while (!q.isEmpty()) {
            Bucket bc = q.poll();
            //a물통이 비어있을 때 c물통에 남아있는 물의 양 저장
            if(bc.bucket[0] == 0) possible[bc.bucket[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if(from == to) continue;
                    //from 물통에서 to 물통으로 물 옮기기
                    Bucket next_bc = bc.move(from, to, Limit);

                    //만약 바뀐 상태를 탐색한 적이 없는 경우
                    if (!visited[next_bc.bucket[0]][next_bc.bucket[1]][next_bc.bucket[2]]) {
                        visited[next_bc.bucket[0]][next_bc.bucket[1]][next_bc.bucket[2]] = true;
                        q.add(next_bc);
                    }
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Limit = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            Limit[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[201][201][201];
        possible = new boolean[201];
    }
}
