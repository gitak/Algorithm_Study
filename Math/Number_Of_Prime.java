package Math;

import java.util.StringTokenizer;

public class Number_Of_Prime {
    public static void main(String[] args) {
        int n = 110011;
        int k = 10;

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        StringTokenizer st = new StringTokenizer(convertNotation(n, k), "0");
        while (st.hasMoreTokens()) {
            Long x = Long.parseLong(st.nextToken());
            if (isPrime(x)) {
                answer++;
            }
        }

        return answer;
    }

    //n을 k진법으로 변환하는 메서드 -> Integer.toString(int n, int k)와 같은 기능
    static String convertNotation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    //소수인지 확인하는 메서드
    static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        } else if (num == 2) {
            return true;
        }else{
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
