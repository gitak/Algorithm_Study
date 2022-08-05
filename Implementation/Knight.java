package Implementation;

import java.io.*;

public class Knight {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        //입력 종료

        int column = Integer.parseInt(String.valueOf(input.charAt(0) - 'a'));
        int row = Integer.parseInt(String.valueOf(input.charAt(1) - '0'));
        int sum = 0;
        sum += horizontalMove(column, row);
        sum += verticalMove(column, row);
        bw.write(sum + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    //1.수평으로 이동하는 경우
    static int horizontalMove(int col, int row) {
        int count = 0;
        if (col - 2 >= 0) {
            if (row - 1 > 0) {
                count++;
            }
            if (row + 1 < 9) {
                count++;
            }
        }

        if (col + 2 < 8) {
            if (row - 1 > 0) {
                count++;
            }
            if (row + 1 < 9) {
                count++;
            }
        }

        return count;
    }
    //1.수직으로 이동하는 경우
    static int verticalMove(int col, int row) {
        int count = 0;
        if (row - 2 > 0) {
            if (col - 1 >= 0) {
                count++;
            }
            if (col + 1 < 8) {
                count++;
            }
        }

        if (row + 2 < 9) {
            if (col - 1 >= 0) {
                count++;
            }
            if (col + 1 < 8) {
                count++;
            }
        }

        return count;
    }
}
