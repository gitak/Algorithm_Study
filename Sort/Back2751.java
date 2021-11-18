package Sort;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;

public class Back2751 {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close(); //입력종료

        //Logic
        Collections.sort(list); //오름차순 정렬

        //for - each 구문
        for(int value : list){
            sb.append(value).append("\n");
        }

        System.out.print(sb);
    }
}
