package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Back11652 {

    static int n;
    static long[] cards;
    static HashMap<Long, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        //sort();
        hashMapCount();
    }

    private static void hashMapCount() {
        int min_card_cnt = 0;
        long min_card = 0;

        for (Long card : hashMap.keySet()) {
            //카드 개수가 더 많은 카드로 갱신되는 경우
            if (hashMap.get(card) > min_card_cnt) {
                min_card_cnt = hashMap.get(card);
                min_card = card;
            }
            //현재 가장 많은 카드 수와 동일한 카드 수인 경우
            else if (hashMap.get(card) == min_card_cnt) {
                min_card = Math.min(card, min_card);
            }
        }
        System.out.println(min_card);
    }

    private static void sort() {
        //Todo 1. 카드정렬
        Arrays.sort(cards);

        //curCnt = 현재 숫자의 개수, minCnt = 최솟값의 카드 개수, min = 카드 숫자가 많은 것중 최솟값
        int curCnt = 1;
        int minCnt= 1;
        long min = cards[0];

        //Todo 2. 카드값 비교
        for (int i = 1; i < n; i++) {
            //지금 보고있는 값이 이전 값과 같은 경우
            if (cards[i] == cards[i - 1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }

            if (curCnt > minCnt) {
                minCnt = curCnt;
                min = cards[i];
            }

        }
        System.out.println(min);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        /* 정렬 방식
        cards = new long[n];
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            cards[i] = x;
        }
         */

        for (int i = 0; i < n; i++) {
            long card = Long.parseLong(br.readLine());
            //hashMap에 카드 개수 갱신
            hashMap.put(card, hashMap.getOrDefault(card, 0) + 1);
        }
    }
}
