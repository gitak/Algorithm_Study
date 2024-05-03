package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back1541 {

	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		logic();
	}

	private static void logic() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		//초기상태 확인여부
		int sum = Integer.MAX_VALUE;

		StringTokenizer subtraction = new StringTokenizer(input, "-");
		while (subtraction.hasMoreTokens()){
			int temp = 0;

			//뺄셈으로 나뉜 토큰을 덧셈으로 분리
			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

			while (addition.hasMoreTokens()){
				temp += Integer.parseInt(addition.nextToken());
			}

			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			}else{
				sum -= temp;
			}
		}




		//1. - 로 구분하기
		// String[] subtraction = input.split("-");
		// for (int i = 0; i < subtraction.length; i++) {
		// 	int temp = 0;
		//
		// 	//뺄셈으로 나눈 토큰을 덧셈으로 분리후, 덧셈
		// 	String[] addition = subtraction[i].split("\\+");
		//
		// 	for (int j = 0; j < addition.length; j++) {
		// 		temp += Integer.parseInt(addition[j]);
		// 	}
		//
		// 	//첫 번째 토큰인 경우 sum을 초기화
		// 	if (sum == Integer.MAX_VALUE) {
		// 		sum = temp;
		// 	} else {
		// 		sum -= temp;
		// 	}
		// }

		System.out.println(sum);
	}


}
