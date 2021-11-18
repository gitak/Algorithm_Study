package Test;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
public class Main {
    static double time; //남은 휴가 시간
    static String[][] planes = new String[1000][3]; // 여행일정
    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        time =Double.parseDouble(br.readLine()); //남은 휴가 시간

        for(int i = 0; i < 2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            planes[i][0] = st.nextToken();
            planes[i][1] = st.nextToken();
            planes[i][2] = st.nextToken();
        }

        solution(time, planes);
    }

    public static String solution(double time, String[][] planes){
        int diff = 0;

        //1.비행기 출발시간, 도착시간 24시간 기준으로 바꾸기
        for(int i = 0; i < planes.length; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;

            //출발시간
            while(true){
                if(planes[i][1].charAt(count) - '0' >= 0 && planes[i][1].charAt(count) - '0' <= 9){ //숫자인 경우
                    sb.append(planes[i][1].charAt(count));
                    count++;
                }
                else{
                    break;
                }
            }
            count = 0;

                if (planes[i][1].contains("PM")) { // 그 시각에 12를 더한다.
                    int x = Integer.parseInt(sb.toString()) + 12;
                    planes[i][1] = String.valueOf(x);
                } else {
                    planes[i][1] = sb.toString();
                }

                sb.setLength(0); //sb 초기화
                //도착시간

            while(true){
                if(planes[i][2].charAt(count) - '0' >= 0 && planes[i][2].charAt(count) - '0' <= 9){ //숫자인 경우
                    sb.append(planes[i][2].charAt(count));
                    count++;
                }
                else{
                    break;
                }
            }
            count = 0;

            if (planes[i][2].contains("PM")) { // 그 시각에 12를 더한다.
                int x = Integer.parseInt(sb.toString()) + 12;
                planes[i][2] = String.valueOf(x);
            } else {
                planes[i][2] = sb.toString();
            }

        }

        //2. 시간 비교후
        for(int i = 0; i < planes.length; i++){
            diff = 0;
            int depart = Integer.parseInt(planes[i][1]);
            int arrive = Integer.parseInt(planes[i][2]);

            if(depart >= 18 && arrive <= 13){
                return planes[i][0];
            }

            if(depart >= 18 && arrive > 13){
                diff = arrive -13;
                if((double)diff < time){
                    return planes[i][0];
                }
                else{
                    continue;
                }
            }

            if(depart <18 && arrive <= 13){
                diff = 18 - depart;
                if((double)diff < time){
                    return planes[i][0];
                }
                else{
                    continue;
                }
            }

            if(depart < 18 && arrive > 13){
                diff = (18 - depart) + (arrive - 13);
                if((double)diff < time){
                    return planes[i][0];
                }
                else{
                   continue;
                }
            }
        }
        return "호치민";


    }
}


 */