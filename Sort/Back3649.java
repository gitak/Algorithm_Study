package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back3649 {
    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;

        //여러 테스트 케이스를 입력하기 위한 조건
        while ((temp = br.readLine() )!= null){

            int x = Integer.parseInt(temp) *10000000;
            int n = Integer.parseInt(br.readLine());
            int[] lego = new int[n];

            for (int i = 0; i < n; i++) {
                lego[i] = Integer.parseInt(br.readLine());
            }

            //이분탐색을 하기 위한 조건
            Arrays.sort(lego);
            boolean isMatch = false;
            int start = 0;
            int end = lego.length -1;

            //이분탐색
            if(n > 1){
                while (start < end) {
                    int sum = lego[start] + lego[end];
                    if (sum == x) {
                        System.out.println("yes "+ lego[start] +" "+ lego[end]);
                        isMatch = true;
                        break;
                    }
                    else if(sum > x) end--;
                    else start++;
                }
            }

            if(!isMatch) System.out.println("danger");
        }
        br.close();
    }
}
