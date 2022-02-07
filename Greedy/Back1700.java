package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1700 {
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());// 멀티탭 구멍의 개수
        int k = Integer.parseInt(st.nextToken());// 전기용품 총 사용 횟수

        List<Integer> devices = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            devices.add(Integer.parseInt(st.nextToken()));
        }
        br.close(); //입력 종료

        Set<Integer> multitap = new HashSet<>();
        int count = 0;

        for (int i = 0; i < k; i++) {
            int device_number = devices.get(i);

            //1. 현재 멀티탭에 제품이 꽂혀 있는 경우
            if(multitap.contains(device_number)) continue;

            //2. 제품이 멀티탭 구멍 갯수보다 적은 경우 -> hashSet에 추가
            if (multitap.size() < n) {
                multitap.add(device_number);
                continue;
            }

            //3. 멀티탭 구멍에 제품이 모두 꽂혀있을때
            //현재 멀티탭에 꽂힌 제품들중 가장 마지막에 사용되는 제품을 뺀다 -> 그리디 알고리즘
            int max = 0;
            int stuck_number = 0;
            for (int stuck : multitap) {
                int temp = 0 ;
                List<Integer> sub = devices.subList(i + 1, k);

                if (sub.contains(stuck)) {
                    temp = sub.indexOf(stuck) + 1;
                }else{
                    //sub에 없는 경우 sub 바로 뒤에 있는 것으로 간주
                    temp = sub.size();
                }

                //멀티탭에 꽂힌 제품중 가장 마지막에 사용되는 제품 갱신
                if (temp > max) {
                    max = temp;
                    stuck_number = stuck;
                }
            }

            multitap.remove(stuck_number);
            multitap.add(device_number);
            count++;
        }

        System.out.println(count);
    }
}
