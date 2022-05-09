package Implementation;

import java.util.ArrayList;

public class PuppetDraw {
    //같은 인형이 몇번 나오는지 세는 변수
    static int count;
    //인형의 정보를 넣을 ArrayList
    static ArrayList<Integer> basket;

    public static void main(String[] args) {

        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        basket = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            draw(board,moves[i]);
        }
        answer = count * 2;
        return answer;
    }

    //인형을 뽑는 메서드
    static void draw(int[][] board, int number) {
        //moves가 이동할 수 있는 범위
        int move_range = board.length;
        for (int i = 0; i < move_range; i++) {
            if (board[i][number - 1] == 0) {
                continue;
            }
            isSamePuppet(board[i][number-1]);
            System.out.println(board[i][number-1]);
            board[i][number-1] = 0;
            board = makeBoard(board);
            break;
        }
    }

    //바구니 맨위와 뽑은 인형이 같은지 확인하는 메서드
    static void isSamePuppet(int puppet) {
        //바구니가 비어있는 경우
        if (basket.isEmpty()) {
            basket.add(puppet);
        }else{
            //뽑은 인형과 바구니 맨위에 있는 인형이 같은 경우
            if (basket.get(basket.size() - 1) == puppet) {
                basket.remove(basket.size()-1);
                count++;
            }else{
                basket.add(puppet);
            }
        }
    }

    //수정된 화면을 만들어주는 메서드
    static int[][] makeBoard(int[][] board){
        int[][] temp = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                temp[i][j] = board[i][j];
            }
        }

        return temp;
    }
}
