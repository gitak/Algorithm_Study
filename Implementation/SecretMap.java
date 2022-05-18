package Implementation;

public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];

        //arr1배열에 담긴 값을 10진수값의 2차원 정수배열로 변환
        for (int i = 0; i < arr1.length; i++) {
            //10진수를 2진수로 변환
            String temp = Integer.toBinaryString(arr1[i]);
            //자릿수를 맞추기 위해 앞에 0을 넣기
            while (temp.length() < n) {
                temp = "0" + temp;
            }

            for (int j = 0; j < n; j++) {
                map1[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            String temp = Integer.toBinaryString(arr2[i]);
            while (temp.length() < n) {
                temp = "0" + temp;
            }
            for (int j = 0; j < n; j++) {
                map2[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }


        //map1과 map2를 겹치기
        for (int i = 0; i < n; i++) {
            String password = "";
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 0 && map2[i][j] == 0) {
                    password += " ";
                }else{
                    password += "#";
                }
            }
            answer[i] = password;
        }


        return answer;
    }
}
