package Sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class ShuttleBus {

    public static void main(String[] args) {
        int n = 1; //셔틀 운행 횟수
        int t = 1; // 셔틀 운행 간격
        int m = 5; // 한 셔틀에 탈 수 있는 최대 크루 수
        String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};

        System.out.println(solution(n,t,m,timetable));

    }
    public static String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pq = new PriorityQueue<>();
        String answer = "";
        //timetable의 시간을 분으로 바꿔서 PriorityQueue에 넣기
        //time을 오름차순으로 정렬
        for(String crew : timetable){
            String[] crew_time = crew.split(":");
            int time = Integer.parseInt(crew_time[0]) * 60 + Integer.parseInt(crew_time[1]);
            pq.add(time);
        }

        int bus_start_time = 9 * 60; // bus가 처음 도착하는 시간
        int corn_time = 0;
        int total_crew = 0; //bus에 탑승할 수 있는 crew의 수

        //버스가 왕복하는 n번 왕복하는 경우
        for(int i = 0; i < n; i++){
            total_crew = 0;
            while (!pq.isEmpty()){
                int current_time = pq.peek(); //pq의 맨 앞의 데이터를 확인(첫 번째 데이터가 사리지지 x)
                if(current_time <= bus_start_time && total_crew < m){
                    pq.poll(); //pq의 맨 앞의 데이터 봅기(첫 번째 데이터가 사라진다.)
                    total_crew++;
                }
                else break;
                //콘의 시간 갱신
                corn_time = current_time -1;
            }

            bus_start_time += t; //bus 출발시간 갱신
        }

        //마지막 버스에 콘이 탈 수 있는 경우
        if(total_crew < m) corn_time = bus_start_time - t;

        //String.format() -> 문자열의 형식을 설정하는 메서드
        String hour = String.format("%02d", corn_time/60);
        String minute = String.format("%02d", corn_time%60);
        return answer = hour +":"+minute;
    }
}
