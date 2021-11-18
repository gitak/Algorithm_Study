package Sort;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Back1764 {
    public static void main(String[] args) {
        //입력시작
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //듣도 못한 사람의 수
        int m = sc.nextInt(); //보도 못한 사람의 수
        sc.nextLine(); //버퍼 지우기

        HashSet <String> hashSet = new HashSet<>(); // 듣도 못한 사람을 저장할 Hashset -> HashSet은 중복을 허락하지 않는다.
        ArrayList<String> name_nm = new ArrayList<>(); //듣도 보도 못한 사람의 수를 담을 ArrayList

        for(int i = 0; i < n; i++){
            hashSet.add(sc.nextLine());
        }

        for(int i = 0; i < m; i++){
            String temp = sc.nextLine();

            //보도 못한 사람이 듣도 못한 사람중있다면 ArrayList에 추가
            // HashSet의 contains() 메소드의 시간복잡도는 O(1)이다 -> 이중 for문을 사용할 필요x
            if(hashSet.contains(temp)) name_nm.add(temp);
        }

        //듣도 보도 못한 사람의 이름을 사전순으로 정렬
        Collections.sort(name_nm);

        //결과 출력
        System.out.println(name_nm.size());
        for(int i = 0; i < name_nm.size(); i++){
            System.out.println(name_nm.get(i));
        }
    }
}
