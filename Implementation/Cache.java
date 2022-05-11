package Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {

    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        int cacheSize =0;
        String[] cities = {"Jeju", "Jeju"};
        System.out.println(solution(cacheSize,cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        //cacheSize가 0인 경우 예외처리
        if (cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }

        for (int i = 0; i < cities.length; i++) {
            //모든 도시이름을 소문자로 변환
            String word = cities[i].toLowerCase();

            if (queue.size() < cacheSize) {
                //cache hit인 경우
                if (queue.contains(word)) {
                    queue.remove(word);
                    queue.add(word);
                    answer += 1;
                    continue;
                }else {
                    queue.add(word);
                    answer += 5;
                    continue;
                }
            }
            //cache hit인 경우
                if (queue.contains(word)) {
                    queue.remove(word);
                    queue.add(word);
                    answer += 1;
                }else {
                    queue.poll();
                    queue.add(word);
                    answer += 5;
                }

        }

        return answer;
    }
}
