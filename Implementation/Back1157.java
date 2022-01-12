package Implementation;
import java.util.Scanner;
import java.util.ArrayList;

public class Back1157 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        int[] alphabet = new int[26];
        sc.close(); //입력 종료

        ArrayList<Character> str = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int max_idx = 0;
        int check = 0;
        if(temp.length() == 1){ //문자열이 1인 경우
            System.out.println(temp.toUpperCase());
            System.exit(0); //시스템 종료
        }
        else{
            for(int i = 0; i < temp.length(); i++){
                str.add(temp.charAt(i));
                if((int)str.get(i) >= 65 && (int)str.get(i) <= 90 ){ //대문자인 경우
                    continue;
                }
                else{
                    char temp1 = (char) (str.get(i) - 32); //대문자로 변환
                    str.set(i, temp1); //해당 위치의 arraylist값 바꾸기
                }
            }

        }

        //알파벳 개수 넣기
        for(int i = 0; i < str.size(); i++){
            alphabet[(int)(str.get(i)) -65]++;
        }

        //가장 많이 쓰인 알페벳 찾기 + 그 때의 위치
        for(int i = 0; i < alphabet.length;i++){
            if(alphabet[i] > max){
                max_idx = i;
                max = alphabet[i];
            }
        }

        //최댓값이 몇번 반복되었는지 확인
        for(int i = 0; i < alphabet.length;i++){
            if(max == alphabet[i]){
                check++;
            }
        }

        if(check == 1){
            System.out.println((char)(max_idx+65));
        }
        else{
            System.out.println("?");
        }
    }
}
