package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1946 {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine()); //지원자 수
            int[] applicant = new int[N+1];

            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                //서류 심사 순위 기준으로 정렬을 하는 효과 (숫자가 1부터 연속되기 때문에)
                int rank = Integer.parseInt(st.nextToken());
                applicant[rank] = Integer.parseInt(st.nextToken());
            }

            int newcomer_count = 1;
            int min = applicant[1]; //서류심사 1등한 사람의 면접시험 점수로 초기화

            for(int j = 2; j <= N; j++){
                if(applicant[j] < min){ // 자신보다 서류심사 점수가 높은 사람들 중 가장 등수가 높은 사람과 비교
                    newcomer_count++;
                    min = applicant[j];
                }
            }

            System.out.println(newcomer_count);
        }
        br.close();//입력 종료
    }
}
