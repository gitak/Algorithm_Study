package Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//DP 문제

public class Back14501 {
    static int max; //최댓값을 담기 위한 변수
    static int[] time; //상담 기간을 담을 배열
    static int[] price; //상담 가격을 담을 배열

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        time = new int[n+1]; //상담 기간을 담을 배열
        price = new int[n+1]; //상담 가격을 담을 배열

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        br.close(); //입력종료

        //Logic
        //점화식을 이용해 현재 나올 수 있는 최대 값을 저장하여 다음 값을 구하는데 사용 -> DP
        int[] dp = new int[n+1]; // n일에 얻을 수 있는 최대 수익을 담을 배열

        for (int i = 0; i < n; i++) {
            //날짜가 범위를 넘어가지 않는 경우
            if (i + time[i] <= n) { //마지막날에 끝나는 경우까지 포함시켜야 한다.
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + price[i]);
            }
            //현재 경우의 수가 0일 수 있기 때문에 이전의 최대값을 넣어준다.
            //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 한다.
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}
