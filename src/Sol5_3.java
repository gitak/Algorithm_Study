import java.util.*;

public class Sol5_3 {
    public static void main(String[] args) {

        //입력 시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]map = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = sc.next(); // \n은 str에 포함하면 안되므로 sc.next()를 써야한다.
            for(int j = 0; j < m; j++){
               map[i][j] = (str.charAt(j) - '0');
            }
            //sc.nextLine();
        }
        sc.close();
        //입력 종료

        //Logic


    }
}
