package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back19236 {

    //12시 방향 기준 반시계 방향으로 이동할 때 방향
    static int[]dx = {-1,-1,0,1,1,1,0,-1};
    static int[]dy = {0,-1,-1,-1,0,1,1,1};
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[4][4];
        List<Fish> fishList = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                int number = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) -1; //dx배열과 dy배열에 각각 index로 들어가기 때문에
                Fish fish = new Fish(i, j, dir, number,true);
                map[i][j] = number;
                fishList.add(fish);
            }
        }
        br.close(); //입력 종료

        //물고기를 오름차순으로 정렬
        Collections.sort(fishList, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.number - o2.number;
            }
        });

        //map의 (0,0)에 있는 fish객체 반환후
        //Shark 객체를 초기화 한 후
        //map의 정보 갱신(상어의 위치는 -1로 표현)
        Fish fish = fishList.get(map[0][0] - 1);
        Shark shark = new Shark(0,0,fish.dir, fish.number);
        fish.isAlive = false; //fish와 fishList.get(map[0][0] - 1) 둘 다 같은 객체를 가리키기 때문에 값이 변경된다.
        map[0][0] = -1;

        dfs(map, shark, fishList);
        System.out.println(maxSum);

    }

    //상어의 위치와 방향 먹은 물고기번호의 합을 나타내기 위한 클래스
    static class Shark{
        int x, y, dir, eatSum;

        public Shark(int x, int y, int dir, int eatSum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eatSum = eatSum;
        }
    }

    //물고기의 위치와 방향, 번호, 살아있는지의 여부를 나타내기 위한 클래스
    static class Fish{
        int x, y, dir, number;
        boolean isAlive;

        public Fish(int x, int y, int dir, int number, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.number = number;
            this.isAlive = isAlive;
        }
    }

    //map을 복사하는 메서드
    static int[][] copyMap(int[][] map){
        int[][] temp = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    //fishList를 복사하는 메서드
    static List<Fish> copyFishList(List<Fish> fishList){
        List<Fish> temp =  new ArrayList<>();
        fishList.forEach(e -> temp.add(new Fish(e.x, e.y, e.dir, e.number, e.isAlive)));
        return temp;
    }

    static boolean isRange(int x, int y){
        return x>=0 && x < 4 && y >= 0 && y <4;
    }

    //물고기가 이동할 수 있는지 확인하는 메서드
    static void moveFish(int[][] map, Fish fish, List<Fish> fishList){
        //해당 번호의 물고기가 죽은경우
        if(!fish.isAlive) return;

        for(int i = 0; i < 8; i++){
            int nextDir = (fish.dir + i) % 8;
            int new_x = fish.x + dx[nextDir];
            int new_y = fish.y + dy[nextDir];

            //물고기가 이동할 수 있는 경우
            if(isRange(new_x,new_y) && map[new_x][new_y] >= 0){

               //이동하는 칸이 빈칸인 경우
               if(map[new_x][new_y] == 0){
                   map[fish.x][fish.y] = 0;
                   fish.x = new_x;
                   fish.y = new_y;

               }else{
                   //(new_x, new_y)와 (fish.x, fish.y)의 값 변경
                   Fish temp = fishList.get(map[new_x][new_y] -1);
                   temp.x = fish.x;
                   temp.y = fish.y;
                   map[fish.x][fish.y] = temp.number;

                   fish.x = new_x;
                   fish.y = new_y;
               }

               map[new_x][new_y] = fish.number;
               fish.dir = nextDir;
               return;
            }
        }
    }


    //상어가 물고기를 먹는 경우를 재귀적으로 dfs를 이용해 찾는 메서드
    static void dfs(int[][]map, Shark shark, List<Fish> fishList){
        if(maxSum < shark.eatSum)
            maxSum = shark.eatSum;

        //모든 물고기를 번호 순으로 이동
        fishList.forEach(e->moveFish(map, e, fishList));

        //최대 상어가 이동할 수 있는 경우의 수는 3가지
        for(int i = 1; i < 4; i++){
            int new_x = shark.x + dx[shark.dir]*i;
            int new_y = shark.y + dy[shark.dir]*i;

            if(isRange(new_x,new_y) && map[new_x][new_y] > 0){
                int[][] new_map = copyMap(map);
                List<Fish> new_fishList = copyFishList(fishList);

                new_map[shark.x][shark.y] = 0;
                //(new_x, new_y)에 위치하는 물고기를 상어가 먹는 경우 처리
                Fish f = new_fishList.get(map[new_x][new_y] - 1);
                Shark new_shark = new Shark(f.x, f.y, f.dir, shark.eatSum + f.number);
                f.isAlive = false;
                new_map[f.x][f.y] = -1;

                dfs(new_map, new_shark, new_fishList);

            }
        }
    }
}
