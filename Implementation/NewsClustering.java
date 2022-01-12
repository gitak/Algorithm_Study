package Implementation;

import java.util.*;

public class NewsClustering {

    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        System.out.println(solution(str1,str2));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        List<String> stringList1 = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();
        int intersect = 0;
        double portion = 0;

        //str1과 str2에 있는 모든 문자열을 소문자로 바꾸고, 소문자를 제외한 나머지는 '*'로 변환한 뒤,
        //각각 new_str1과 new_str2에 저장
        String new_str1 = str1.toLowerCase();
        new_str1 = new_str1.replaceAll("[^a-z]","*");
        String new_str2 = str2.toLowerCase();
        new_str2 = new_str2.replaceAll("[^a-z]","*");

        //new_str1과 new_str2에서 '*'가 없는 경우 ArrayList에 저장
        for(int i = 0; i < new_str1.length()-1; i++){
            if(new_str1.substring(i,i+2).contains("*")){
                continue;
            }
            stringList1.add(new_str1.substring(i,i+2));
        }

        for(int i = 0; i < new_str2.length()-1; i++){
            if(new_str2.substring(i,i+2).contains("*")){
                continue;
            }
            stringList2.add(new_str2.substring(i,i+2));
        }

        //두 집합이 공집합인 경우(예외처리)
        if(stringList1.size() == 0 && stringList2.size() == 0){
            return answer = 65536;
        }

        //각각의 ArrayList에 있는 문자열을 HashMap에 저장
        //value값은 해당 문자열이 나온 횟수
        Map<String, Integer> map1 = new HashMap<>();
        for(String key : stringList1)
            map1.put(key, map1.getOrDefault(key,0)+1);

        Map<String, Integer> map2 = new HashMap<>();
        for(String key : stringList2)
            map2.put(key, map2.getOrDefault(key,0)+1);


        //변수 intersect에 교집합이 되는 문자열의 개수를 저장
        Iterator<String> keys = map1.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            if(map2.containsKey(key)){
                if(map1.get(key) < map2.get(key)){
                    intersect += map1.get(key);
                }
                else{
                    intersect += map2.get(key);
                }
            }
        }

        portion = (double) intersect / ((stringList1.size() + stringList2.size()) - intersect);
        portion *= 65536;

        return answer = (int)portion;
    }
}
