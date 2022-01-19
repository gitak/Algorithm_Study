package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChuseokTraffic {
    public static void main(String[] args) {
        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};

        System.out.println(solution(lines));

    }

    public static int solution(String[] lines) {
        int answer = 0;

        List<Time> timeList = new ArrayList<>();

        //lines에서 시작시간과 마지막 시간에 대한 정보를 timeList에 저장
        for(int i = 0; i < lines.length; i++){
            String[] temp = lines[i].split(" |s");
            String[] time = temp[1].split(":");
            double end_time = Double.parseDouble(time[0])*3600 + Double.parseDouble(time[1])*60 +
                    Double.parseDouble(time[2]);
            double start_time = end_time - Double.parseDouble(temp[2])  + 0.001;
            timeList.add(new Time(start_time,end_time));
        }

        //로그의 끝나는 시간이 빠른 것 기준으로 정렬
        Collections.sort(timeList, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return (int)(o1.end_time - o2.end_time);
            }
        });


        for(int i = 0; i < timeList.size(); i++){
            int count = 0;
            for(int j = i; j < timeList.size(); j++){
                if(isRange(timeList.get(j), timeList.get(i).end_time)){
                    count++;
                }
            }
            //가장 많은 처리량인 경우 answer에 저장
            if(answer < count)
                answer = count;
        }

        return answer;
    }

    //로그가 비교하려는 시간안에 존재하는지 확인하는 메서드
    static boolean isRange(Time time, double sec){
        //1. 응답 시작 시간이 구간에 걸쳐있는 경우
        if(time.start_time >= sec && time.start_time < sec+1)
            return true;
        //2. 응답 종료 시간이 구간에 걸쳐있는 경우
        else if(time.end_time >= sec && time.end_time < sec+1)
            return true;
        //3. 처리 시간이 구간에 걸쳐있는 경우
        else if(time.start_time < sec && time.end_time > sec+1)
            return true;
        return false;
    }

    //로그의 시작 시간과 종료시간을 담을 클래스
    static class Time{
        double start_time, end_time;

        public Time(double start_time, double end_time) {
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }
}
