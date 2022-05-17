package Graph;

public class TaxiFare {
    //각 노드별 간선의 비용을 담을 배열
    static int[][] dist = new int[200][200];
    static int INF = 200 * 100000; //간선당 최고 금액 * 최대 간선 수

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        //dist배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = INF;
            }
        }

        //간선 비용 갱신
        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0] - 1;
            int end = fares[i][1] - 1;
            int edge = fares[i][2];
            dist[start][end] = edge;
            dist[end][start] = edge;
        }

        floyd(n);
        //answer값 초기화
        int answer = INF;

        //s에서 출발하여 중간에 i를 거쳐 a,b로 가는 것이 더적은 비용일 경우 갱신
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, dist[s - 1][i] + dist[i][a - 1] + dist[i][b - 1]);
        }

        return answer;
    }

    //floyd-warshall 알고리즘
    static void floyd(int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //i에서 j로 가는 것이 i에서 k를 거쳐 j로 가는 것보다 오래 걸리는 경우
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

    }
}
