package Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class FriendsBlock {

    static boolean[][] isVisited;

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] booard = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(m, n, booard));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        //map 초기화 및 생성 -> 배열로 만들기
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        boolean isGameContinue = true;
        while (isGameContinue) {
            //방문여부 초기화
            isVisited = new boolean[m][n];
            isGameContinue = false;

            //map에서 2*2 블록 확인
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    //(i,j)가 빈칸인 경우
                    if(map[i][j] == '#') continue;
                    if (checkFour(i, j,map)) {
                        isGameContinue = true;
                    }
                }
            }
            answer += eraseBlock(m, n, map);

        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        return answer;
    }

    //map의 (i,j)기준으로 2*2가 같은 블록인지 확인하는 메서드
    static boolean checkFour(int i, int j, char[][] map) {
        char targetBlock = map[i][j];
        if (targetBlock == map[i][j + 1] && targetBlock == map[i + 1][j] && targetBlock == map[i + 1][j + 1]) {
            isVisited[i][j] = true;
            isVisited[i][j + 1] = true;
            isVisited[i + 1][j] = true;
            isVisited[i + 1][j + 1] = true;
            return true;
        }
        return false;
    }

    //map에서 2*2가 되는 블록을 지우는 메서드
    static int eraseBlock(int m, int n, char[][] map) {
        int blockCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //같은 블록을 '.'으로 변환
                if (isVisited[i][j]) {
                    map[i][j] = '.';
                }
            }
        }

        //Queue를 통해 세로의 빈칸 제거
        for (int i = 0; i < n; i++) {
            Queue<Character> q = new LinkedList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (map[j][i] == '.') {
                    blockCount++;
                }else{
                    q.add(map[j][i]);
                }
            }

            int idx = m-1;
            //삭제한 블록 내리기
            while (!q.isEmpty()) {
                map[idx--][i] = q.poll();
            }

            for (int j = idx; j >= 0; j--) {
                map[j][i] = '#';
            }
        }

        return blockCount;
    }
}
