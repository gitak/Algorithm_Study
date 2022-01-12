package Implementation;

import java.util.*;

public class HotelroomAssignment {

    //(방 번호, 다음방 번호)를 저장하기 위한 HashMap
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1,3,4,1,3,1};
        for(long x : solution(k,room_number)){
            System.out.println(x);
        }
    }

    public static long[] solution(long k, long[] room_number) {

        long [] answer = new long[room_number.length];

        //배열 answer에 값 넣기
        for(int i = 0 ; i < room_number.length; i++){
            answer[i] = findEmptyRoom(room_number[i]);
        }
        return answer;
    }

    private static Long findEmptyRoom(long roomNumber){

        //처음 방에 배정되는 경우 map에 저장 및 해당 번호 출력
        if(!map.containsKey(roomNumber)){
            map.put(roomNumber, roomNumber+1);
            return roomNumber;
        }

        //재귀 호출을 통해 빈방을 찾은 후 map의 값을 갱신후  빈 방 번호 출력
        long emptyRoom = findEmptyRoom(map.get(roomNumber));
        map.put(roomNumber, emptyRoom);
        return emptyRoom;
    }
}
