package Implementation;

public class LockAndKey {
    static int n;
    static int m;

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }
    public static boolean solution(int[][] key, int[][] lock) {
        //key와 lock의 돌기개수 각각 저장
        int key_count = protrusionCount(key);
        int lock_count = protrusionCount(lock);
        n = lock.length;
        m = key.length;
        int[][] map = new int[n + (2 * m) - 2][n +(2 * m) - 2];
        boolean answer = false;

        //1. 전체 map에 자물쇠 붙이기
        for (int i = m - 1; i < m + n-1; i++) {
            for (int j = m - 1; j < m + n - 1; j++) {
                map[i][j] = lock[i - (m - 1)][j - (m - 1)];
            }
        }


        //2. 순서대로 key를 넣고 확인
        for (int i = 0; i < m + n - 1; i++) {
            for (int j = 0; j < m + n - 1; j++) {
                //2. 90도씩 돌아가면서 확인
                for (int k = 0; k < 4; k++) {
                    //map의 값 초기화
                    int[][] copy_map = copyMap(map);

                    //key를 90도 돌린후 복사한map에 붙여넣기
                    key = rotateKey(key);
                    pasteKey(copy_map,key, i, j);
                    int map_count = protrusionCount(copy_map);

                    //lock안이 1로 채워져있고 map의 돌기수가 key와 lock의 돌기수를 합친 값과 같은 경우
                    if (checkLock(copy_map) && key_count + lock_count == map_count) {
                        answer = true;
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

    //2차원 배열을 복사하는 메서드
    static int[][] copyMap(int[][] map) {
        int[][] temp = new int[map.length][map[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = map[i][j];
            }
        }

        return temp;
    }

    //열쇠를 90도 회전시키는 메서드
    static int[][] rotateKey(int[][] key) {
        int[][] temp = new int[key.length][key.length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                temp[j][m - 1 - i] = key[i][j];
            }
        }

        return temp;
    }

    //돌기의 개수를 세는 메서드
    static int protrusionCount(int[][] key) {
        int count = 0;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                if(key[i][j] == 1) count++;
            }
        }

        return count;
    }

    //자물쇠안이 1로 채워져있는지 확인하는 메서드
    public static boolean checkLock(int map[][]) {
        for (int i = m - 1; i < n + m - 1; i++) {
            for (int j = m - 1; j < n + m - 1; j++)
                if (map[i][j] == 0)
                    return false;
        }

        return true;
    }


    //map의 빈곳에 key를 붙이는 메서드(lock에 돌기와 key에 돌기가 만나는 경우 1로 처리)
    static void pasteKey(int[][] map, int[][] key,int posX,int posY) {
        for (int i = posX; i < posX + m; i++) {
            for (int j = posY; j < posY + m; j++) {
                if(map[i][j] == 0) map[i][j] += key[i - posX][j - posY];
            }
        }
    }
}
