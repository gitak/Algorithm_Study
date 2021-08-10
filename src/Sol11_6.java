import java.util.Scanner;

public class Sol11_6 {
    public static int n;
    public static int solution(int[] food_times, long k) {
        //Logic
        int count = 1;
        int answer = 0;
        int check = 0;
        //k > n이면 k값을 k-n으로 업데이트하여 다시 음식을 먹게 한다.
        for(; answer < k; answer++){
            if(check == n){
                //1. food_times의 배열을 확인하여 모든 배열의 원소가 0일 경우 answer = -1 반환
                answer = -1;
                break;
            }
            else if(count == k){
                //2. 시간이 k초가 되었을 때 종료
                break;
            }
            else {
                if(answer == n){
                    answer = -1; // answer이 끝까지 갔다면 다시 처음 음식으로 돌아간다.
                    continue;
                }
                else if (food_times[answer] == 0) {
                    check += 1;
                    continue;
                }
                else {
                    food_times[answer] -= 1;
                    count += 1;
                    continue;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int [] food_times = new int [n];
        for(int i = 0; i < n; i++){
            food_times[i] = sc.nextInt();
        }
        long k = sc.nextInt();//입력 종료
        System.out.println(solution(food_times,k));

    }
}
