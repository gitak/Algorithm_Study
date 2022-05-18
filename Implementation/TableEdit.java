package Implementation;

import java.util.*;

public class TableEdit {

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution(n,k,cmd));
    }

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted_row = new Stack<>();
        int table_size = n;
        int pointing_index = k;

        for (int i = 0; i < cmd.length; i++) {
            //이동,삭제,복구중 어떤 연산인지 확인
            char operator = cmd[i].charAt(0);

            //아래,위로 이동하는 경우
            if (operator == 'D') {
                pointing_index += Integer.parseInt(cmd[i].substring(2));
            } else if (operator == 'U') {
                pointing_index -= Integer.parseInt(cmd[i].substring(2));
            }
            //삭제하는 경우
            else if (operator == 'C') {
                //삭제하는 위치를 저장
                deleted_row.push(pointing_index);
                table_size--;
                if(pointing_index == table_size) pointing_index--;
            }
            else if (operator == 'Z') {
                //가장 최근에 삭제된 index가 pointing_index보다 작은 경우
                if (deleted_row.pop() <= pointing_index) pointing_index++;
                table_size++;
            }
        }

        StringBuilder sb = new StringBuilder();
        //현재 table_size만큼 "O"생성
        for (int i = 0; i < table_size; i++) {
            sb.append("O");
        }
        //삭제된 행의 역순으로 X를 넣으면 원래 table이 완성된다.
        while (!deleted_row.isEmpty()) {
            sb.insert(deleted_row.pop(), "X");
        }

        String answer = sb.toString();
        return answer;
    }
}
