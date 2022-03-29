package Graph;

import java.util.ArrayList;
import java.util.List;

public class SheepAndWolf {
    //2진트리의 각 노드의 연결상태를 저장할 ArrayList
    static ArrayList<Integer>[] graphs;
    static int max_sheep = 0;
    static int[] Info;

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        int answer = solution(info, edges);
        System.out.println(answer);
    }

    public static int solution(int[] info, int[][] edges) {
        Info = info;
        //graphs 초기화
        graphs = new ArrayList[info.length];
        //2진트리의 연결상태를 graph에 저장
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            //부모 노드가 생성되지 않은 경우
            if (graphs[parent] == null) {
                graphs[parent] = new ArrayList<>();
            }
            graphs[parent].add(child);
        }

        List<Integer> visitingPlace = new ArrayList<>();
        visitingPlace.add(0);
        dfs(0,0,0,visitingPlace);
        return max_sheep;
    }

    static void dfs(int idx, int sheep, int wolf,List<Integer> visitingPlace) {

        //해당 노드에 도착했을때, 양과 늑대의 개수 최신화
        if(Info[idx] == 0){
            sheep++;
        } else{
            wolf++;
        }

        if(wolf >= sheep) return;
        max_sheep = Math.max(sheep, max_sheep);

        //현재 탐색해야될 노드중 현재 위치 제외
        List<Integer> nextVisitingPlace = new ArrayList<>(visitingPlace);
        nextVisitingPlace.remove(Integer.valueOf(idx));

        //현재 노드의 자식노드를 다음 방문할 곳에 추가
        if (graphs[idx] != null) {
            for (int child : graphs[idx]) {
                nextVisitingPlace.add(child);
            }
        }

        for (int next : nextVisitingPlace) {
            dfs(next, sheep,wolf,nextVisitingPlace);
        }
    }

}
