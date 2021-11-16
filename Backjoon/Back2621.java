package Backjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2621 {
    //뽑은 카드숫자(1~9)의 개수를 담을 배열
    static int[] card = new int [10];
    //0이 R, 1이 B, 2가 Y, 3이 G -> 뽑은 카드 색깔의 개수를 담을 배열
    static int[] color = new int [4];
    static int[] two = new int[2];
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int n =Integer.parseInt(st.nextToken());

            //문자열 비교는 == 연산자가 아닌 equals()로 비교
            if(temp.equals("R")){
                card[n]++;
                color[0]++;
            }
            else if(temp.equals("B")){
                card[n]++;
                color[1]++;
            }
            else if(temp.equals("Y")){
                card[n]++;
                color[2]++;
            }
            else if(temp.equals("G")){
                card[n]++;
                color[3]++;
            }
        }
        br.close(); //입력 종료
        //Logic
        //카드의 개수와 카드의 색깔을 확인하는 메서드가 섞여있으므로 9가지 규칙을 else if문이 아닌 if문으로 처리해야한다
        if(equal_color() && (five_card() != 0)){
            System.out.println(900+five_card());
            return;
        }
        if(four_card() != 0){
            System.out.println(800 + four_card());
            return;
        }
        if(three_card() != 0 && two_card() != 0){
            System.out.println(700+ 10*three_card() + two_card());
            return;
        }
        if(equal_color()){
            for(int i = 9; i >= 1; i++){
                if(card[i] == 1){
                    System.out.println(600 + i);
                    return;
                }
            }
        }
        if(five_card() != 0){
            System.out.println(500+ five_card());
            return;
        }
        if(three_card() != 0){
            System.out.println(400 + three_card());
            return;
        }
        if(two_card_big() != two_card_small()){ //같은 숫자가 2개인 카드가 2세트 있을 때
            System.out.println(300 + two_card_big()*10 + two_card_small());
            return;
        }
        if(two_card_big() != 0){
            System.out.println(200 + two_card_big());
            return;
        }

            for(int i = 9; i >= 1; i--){
                if(card[i] == 1){
                    System.out.println(100 + i);
                    return;
                }
            }
    }

    //1. 카드 5장이 같은색이다.
    public static boolean equal_color(){
        for(int i = 0; i < 4; i++){
            if(color[i] == 5){
                return true;
            }
        }
        return false;
    }

    //2. 카드 5장이 연속적이다.
    public static int five_card(){
        for(int i = 1; i <= 5; i++){
            if(card[i] == 1 && card[i+1] == 1 && card[i+2] == 1 && card[i+3] == 1 && card[i+4] == 1){
                return i+4;
            }
        }
        return 0;
    }

    //3. 카드 4장의 숫자가 같다.
    public static int four_card(){
        for(int i = 1; i < 10; i++){
            if(card[i] == 4){
                return i;
            }
        }
        return 0;
    }

    //4. 카드 3장의 숫자가 같다.
    public static int three_card(){
        for(int i = 1; i < 10; i++){
            if(card[i] == 3){
                return i;
            }
        }
        return 0;
    }

    //5. 카드 2장의 숫자가 같다.
    public static int two_card(){
        for(int i = 1; i < 10; i++){
            if(card[i] == 2){
                return i;
            }
        }
        return 0;
    }

    //카드 2장의 숫자가 같은 때 더 작은 수를 뽑는 경우
    public static int two_card_small(){
        for(int i = 1; i < 10; i++){
            if(card[i] == 2){
                return i;
            }
        }
        return 0;
    }

    //카드 2장의 숫자가 같은 때 더 큰 수를큰뽑는 경우
    public static int two_card_big(){
        for(int i = 9; i >= 1; i--){
            if(card[i] == 2){
                return i;
            }
        }
        return 0;
    }
}
