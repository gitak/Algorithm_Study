package Chapter12;
import java.util.Scanner;

public class Sol12_3 {
    public static void main(String[] args) {
        //입력시작
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();//입력 종료
        System.out.println(solution(input));
    }
    //Logic
    public static int solution(String s) {
        int answer = s.length();
        //1. 1개 단위(step)부터 압축 단위를 늘려가면서 확인
        for(int step = 1; step < s.length()/2 + 1; step++){ //문자열 길이의 절반이 지나면 반복문 탈출
            String compressed = "";
            String prev = s.substring(0,step); // 앞에서부터 step만큼의 문자열 추출
            int cnt = 1;

            //단위(step) 크기 만큼 증가시키며 이전 문자열과 비교
            for(int j = step; j < s.length(); j+= step){
                //이전 상태와 동일하다면 압축 횟수(count) 증가
                String sub = "";

                //sub에 비교할 다음 문자열 담기
                for(int k = j; k < j + step; k++){
                    if(k < s.length()){
                        sub += s.charAt(k);
                    }
                }
                if(prev.equals(sub)){
                    cnt += 1;
                }
                else{ //다른 문자열이 나온 경우(더 이상 압축하지 못하는 경우)
                    if(cnt>=2){
                        compressed += cnt + prev;
                    }
                    else{
                        compressed += prev;
                    }
                    prev = sub;
                    cnt = 1;
                }
            }
            // 남아있는 문자열에 대해서 처리
            compressed += (cnt >= 2)? cnt + prev : prev;
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
