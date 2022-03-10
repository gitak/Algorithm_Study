package Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Report_Result {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] ans = solution(id_list, report, k);
//        for (int x : ans) {
//            System.out.println(x);
//        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        boolean[][] check = new boolean[n][n];
        StringTokenizer st;
        List<String> reportedPerson = new ArrayList<>();

        //user가 신고한 사람 체크(반복신고는 1회로 규정)
        for (int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i]);
            int indexOfUser = Arrays.asList(id_list).indexOf(st.nextToken());
            int intdexOfReportedPerson = Arrays.asList(id_list).indexOf(st.nextToken());
            check[indexOfUser][intdexOfReportedPerson] = true;
        }

        //정지되는 사람은 reportedPerson 리스트에 담기
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(check[j][i]) count++;
            }

            if (count >= k) {
                reportedPerson.add(id_list[i]);
            }
        }

        //신고한 사람이 정지된 경우 answer[i]값 1 증가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] && reportedPerson.contains(id_list[j])) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
