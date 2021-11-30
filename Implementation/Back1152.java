package Implementaion;
import java.util.*;
public class Back1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String new_str = str.trim();
        StringTokenizer st = new StringTokenizer(new_str," ");
        int count = 0;

        while(st.hasMoreTokens()){
            count++;
            st.nextToken(); //다음 토큰으로 넘어가기 위해 필요
        }
        System.out.println(count); // System.out.println(st.countTokens());
    }
}
