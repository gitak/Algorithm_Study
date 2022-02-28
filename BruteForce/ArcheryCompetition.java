package BruteForce;

public class ArcheryCompetition {

    static int[] answer = {-1};
    static int[] lion;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};

        int[] result = solution(5, info);

        for (int x : result) {
            System.out.println(x);
        }
    }


    public static int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info,1, n);
        return answer;
    }

    static void dfs(int[] info, int count, int n) {
        //n까지 완전탐색을 한 경우
        if (count == n+1) {
            int apeach_point = 0;
            int lion_point = 0;

            for (int i = 0; i <= 10; i++) {
                //둘 중 하나는 과녁을 맞힌 경우
                if (info[i] != 0 || lion[i] != 0) {

                    //어피치가 점수를 얻는 경우
                    if (info[i] >= lion[i]) {
                        apeach_point += 10 - i;
                    } else {
                        lion_point += 10 - i;
                    }

                }

            }


            if(lion_point > apeach_point) {
                //점수차가 같은 경우 가장 낮은 점수를 맞힌 점수로 갱신
                if(lion_point - apeach_point >= max)
                {
                    answer = lion.clone();
                    max = lion_point - apeach_point;
                }
            }

            return;
        }

        //라이언이 어피치한테 점수를 딸때 까지만 반복 (lion[i] <= info[i]) -> 그리디
        for (int i = 0; i <= 10 && lion[i] <= info[i]; i++) {
            lion[i]++;
            dfs(info,count+1, n);
            lion[i]--;
        }

    }
}
