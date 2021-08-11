import java.util.Scanner;

public class Sol11_6 {
    public static int n;
    public static int solution(int[] food_times, long k) {
        //Logic
        int count = 0;
        int answer = 0;
        int check = 0;
        //k > n이면 k값을 k-n으로 업데이트하여 다시 음식을 먹게 한다.
        for(; answer < k;answer++){
            if(check == food_times.length){
                //1. food_times의 배열을 확인하여 모든 배열의 원소가 0일 경우 answer = -1 반환
                answer = -1;
                break;
            }
            else if(answer == food_times.length){
                    answer = -1; // answer이 끝까지 갔다면 다시 처음 음식으로 돌아간다.
                }

            else {
                //먹을 음식이 없는 경우, 시간에 포함하지 않고 다음으로 넘어간다.
                if (food_times[answer] == 0) {
                    check += 1;
                    continue;
                }
                else {
                    food_times[answer] -= 1;
                    count += 1;

                }
            }
            //k초가 지난 후, 먹어야 될 음식의 위치를 반환
            if(count > k){
                answer++;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //입력 시작
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long k = sc.nextInt();
        int [] food_times = new int [n];
        for(int i = 0; i < n; i++){
            food_times[i] = sc.nextInt();
        }
        //입력 종료
        System.out.println(solution(food_times,k));

    }
}
