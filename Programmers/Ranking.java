package Programmers;

import java.io.IOException;
import java.util.*;

public class Ranking {
    static Map<String, ArrayList<Integer>> allinfo; //info에 대한 정보를
    static ArrayList<Integer> in;
    public static void main(String[] args) throws IOException {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210",
                "python frontend senior chicken 150","cpp backend senior pizza 260",
                "java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200","cpp and - and senior and pizza 250",
                "- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        solution(info, query);
    }

    //Logic
    //비교연산을 줄여주는 탐색 -> 이진탐색
        /*1. info로 주어지는 데이터들을 공백을 포함한 query에 뽑힐 수 있는 모든 경우의 수를 만들기 - 조합
          2. 이진탐색은 정렬된 데이터에서만 가능한 알고리즘이기 때문에 정렬된 데이터가 필요 ->  점수를 기준으로 정렬 - 자료구조, 정렬
          3. 정렬된 점수 데이터를 통해 이진탐색을 하여 query[]에 해당하는 인원 수를 찾기 - 이진 탐색
         */

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        allinfo = new HashMap<>();

        //1. info의 모든 경우의 수 map에 저장
        for (int i = 0; i < info.length; i++) {
            //info[i]번째에 대한 정보를 " "을 기준으로 나눈다.
            dfs("", 0, info[i].split(" "));
        }

        // 2. map에 저장된 점수 list 오름차순으로 정렬

        //list에 allinfo의 key값을 저장
        List<String> list = new ArrayList<>(allinfo.keySet());
        for(int i=0; i<list.size(); i++) {
            //scoreList에 list값에 해당하는 점수를 저장
            List<Integer> scoreList = allinfo.get(list.get(i));
            Collections.sort(scoreList);
        }

        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            //str[0]에는 list[i]값이, str[1]에는 scorelist[i]에 해당하는 값이 저장된다.
            String[] str = query[i].split(" ");
            int score = Integer.parseInt(str[1]);

            answer[i] = search(str[0], score);
        }
        return answer;
    }

    //String pos는 문자열
    public static void dfs(String pos, int depth, String[] info){
            if(depth == 4){
                //해쉬맵 allinfo에서 key값으로 pos가 없는경우 해당key에 점수 넣기
                if(!allinfo.containsKey(pos)){
                    in = new ArrayList<>();
                    in.add(Integer.parseInt(info[4]));
                    allinfo.put(pos, in);
                }
                else{
                    allinfo.get(pos).add(Integer.parseInt(info[4]));
                }
                return;
            }
            dfs(pos+"-",depth+1, info);
            dfs(pos+info[depth], depth+1, info);
        }

    // 이분 탐색
    static int search(String str, int score) {
        //str에 해당하는 값이 allinfo에 없는 경우
        if(!allinfo.containsKey(str)) return 0;
        List<Integer> scoreList = allinfo.get(str);
        int start= 0, end = scoreList.size()-1;
        while(start<=end) {

            int mid =(start+end)/2;
            if(scoreList.get(mid) <score) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return scoreList.size()-start;
    }
}
