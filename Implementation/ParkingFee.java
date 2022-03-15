package Implementation;

import java.util.*;

public class ParkingFee {

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT",
                "22:59 5961 IN", "23:00 5961 OUT"};


        int[] answer = solution(fees, records);
        for (int x : answer) {
            System.out.println(x);
        }
    }

    public static int[] solution(int[] fees, String[] records) {

        //주차장에 있는 차의 정보를 저장할 해쉬맵
        Map<String, Integer> parking = new HashMap<>();
        //차량별 누적 주차 시간을 저장할 해쉬맵
        Map<String, Integer> cumulativeTime = new HashMap<>();
        //차량의 번호를 저장할 arrayList
        List<String> cars = new ArrayList<>();

        for (String record : records) {
            String[] car_info = record.split(" ");
            int time = hour_to_minute(car_info[0]);
            String car = car_info[1];

            //새로운차가 주차하는 경우
            if (!cars.contains(car)) {
                cars.add(car);
                cumulativeTime.put(car, 0);
            }

            //해당 차량이 주차가 되어있는 경우
            if (parking.containsKey(car)) {

                //누적된 주차시간에서 추가된 주차시간 만큼을 더해서 다시 넣은 후 출차 처리
                //해쉬맵에 있는 기존의 key값에 새로운 value값을 넣으면 새로운 value값으로 대체
                cumulativeTime.put(car, cumulativeTime.get(car) + (time - parking.get(car)));
                parking.remove(car);
            } else {

                //출차한 차량이 다시 입차한 경우
                parking.put(car, time);
            }
        }

        int[] answer = new int[cars.size()];
        //차량번호 오름차순으로 정렬
        Collections.sort(cars);

        for (int i = 0; i < cars.size(); i++) {
            answer[i] = fees[1];
            String car = cars.get(i);

            //누적시간중 기본시간 제외
            int time = cumulativeTime.get(car) - fees[0];

            //아직 주차장에 있는경우 마지막 시간으로 계산
            if (parking.containsKey(car)) {
                time += (hour_to_minute("23:59") - parking.get(car));
            }

            //기본시간을 넘기는 경우 단위시간당 요금 추가
            if (time > 0) {
                answer[i] += (Math.ceil(time / (fees[2]*1.0)) * fees[3]);
            }
        }

        return answer;
    }

    static int hour_to_minute(String time) {
        String[] temp = time.split(":");

        return Integer.valueOf(temp[0]) * 60 + Integer.valueOf(temp[1]);
    }
}
