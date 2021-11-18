package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skill {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String skill = br.readLine();
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill,skill_trees));
    }

    public static int solution(String skill, String[] skill_trees){
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        //skill_trees의 요소별로 접근
        for(int i = 0 ; i < skill_trees.length; i++){
            //i번째 skill_trees의 요소중 skill에 있는 문자가 있으면 sb에 추가
            for(int j = 0 ; j < skill_trees[i].length(); j++){
                if(skill.contains(String.valueOf(skill_trees[i].charAt(j)))){
                    sb.append(skill_trees[i].charAt(j));
                }
            }
            int n = sb.length(); //skill_trees[i]에서 skill에 있는 문자를 포함한 길이
            if(n == 0){ //skill_trees[i]에서 선행스킬이 없는 경우
                answer++;
                continue;
            }

            //sb의 길이만큼 skill에 저장된 문자열 자르기
            String temp = skill.substring(0,n);

            //temp와 sb에 저장된 문자열이 같은지 비교(sb는 객체이므로 안에 저장된 문자열을 보려면 toString()함수를 써야 한다.)
            if(temp.equals(sb.toString())){
                answer++;
            }
            sb.setLength(0); //StringBuilder 초기화
        }
        return answer;
    }
}
