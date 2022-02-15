package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//트라이 자료구조도 함께 공부
public class Back5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //test case의 개수
        boolean[] check = new boolean[t];

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); //전화번호의 수
            String[] phonebook= new String[n];

            for (int j = 0; j < n; j++) {
                phonebook[j] = br.readLine();
            }
            //기존의 숫자 정렬은 1, 9, 10, 44, 34, 4로 입력되었을때 정렬 결과가 1, 4, 9, 10, 34, 44
            // String으로 입력하고 1, 9, 10, 44, 34, 4를 정렬하면 결과가 1, 10, 34, 4, 44
            //입력) 911 91155 993 91222 99333
            //String 오름차순 정렬 후) 911 91155 91222 993 99333
            Arrays.sort(phonebook);

            for(int j = 1 ; j < n; j++){
                //startsWith(): 대상 문자열이 특정 문자 또는 특정 문자열로 시작되는지 확인
                //endsWith(): 대상 문자열이 특정 문자열로 끝나는지 확인
                // 둘다 공백이 있다면 공백까지 체크한다.
                if(phonebook[j].startsWith(phonebook[j-1])){
                    check[i] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < t; i++){
            System.out.println(check[i] ? "NO" : "YES");
        }

    }
}
