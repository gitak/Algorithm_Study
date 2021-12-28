package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1652 {

    public static void main(String[] args) throws IOException {
        //입력시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int width = 0; //가로
        int length = 0; //세로
        int count = 0;
        int n = Integer.parseInt(br.readLine()); //방의 크기
        String[][] map = new String[n][n]; //map의 크기 초기화

        //map의 값 넣기
        for(int i = 0; i < n; i++){
            //구분자로 띄어쓰기가 없으면 StringTokenizer를 쓸 수 없다.
            String[] token = br.readLine().split("");
            for(int j = 0; j < n; j++){
                map[i][j] = token[j];
            }
        }
        br.close(); //입력 종료

        //Logic
        for(int i = 0; i < n; i++){
            count = 0;
            for(int j = 0; j < n; j++){
                //빈공간인 경우 count증가
                if(map[i][j].equals(".")){
                    count++;
                    continue;
                }
                else if(map[i][j].equals("X")){
                    //짐이 있지만 이전까지 빈공간의 크기가 2이상인 경우
                    if(count >= 2){
                        width++;
                    }
                    count = 0;
                }
            }

            //끝까지 도착했는데 빈공간의 크기가 2이상인 경우
            if(count >=2){
                width++;
            }
        }

        for(int i = 0; i < n; i++){
            count = 0; //count값을 0으로 초기화
            for(int j = 0; j < n; j++){
                //빈공간인 경우 count증가
                if(map[j][i].equals(".")){
                    count++;
                    continue;
                }
                else if(map[j][i].equals("X")){
                    //짐이 있지만 이전까지 빈공간의 크기가 2이상인 경우
                    if(count >= 2){
                        length++;
                    }
                    count = 0;
                }
            }

            //끝까지 도착했는데 빈공간의 크기가 2이상인 경우
            if(count >=2){
                length++;
            }
        }

        System.out.println(width +" "+length);
    }
}
