import java.util.Scanner;

public class Sol11_3 {
    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        sc.close();//입력종료

        int count0 = 0;
        int count1 = 0;
        String comp = String.valueOf(temp.charAt(0)); //현재 문자를 이전 문자와 비교하기 위한 변수

        for(int i = 1; i < temp.length(); i++){
            String x = String.valueOf(temp.charAt(i));
            if(comp.equals(x)){ //이전문자와 현재문자가 서로 같은지 확인
                continue;
            }
            else{
                if(comp.equals("0")){
                    count0 += 1;
                }
                else{
                    count1 += 1;
                }
                comp = x;
            }
        }
        System.out.println(Math.min(count0,count1));

    }
}
