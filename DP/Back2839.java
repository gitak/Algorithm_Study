package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back2839 {
	static BufferedReader br;
	static int N;


	public static void main(String[] args) throws IOException {
		input();
		logic();
	}

	private static void logic() throws IOException {
		if (N == 3) {
			System.out.println(1);
		} else if (N == 4) {
			System.out.println(-1);
		} else if (N == 5) {
			System.out.println(1);
		}
		else  {
			int[] dp = new int[N + 1];
			dp[1] = -1;
			dp[2] = -1;
			dp[3] = 1;
			dp[4] = -1;
			dp[5] = 1;
			for (int i = 6; i <= N; i++) {
				if (dp[i - 5] != -1) {
					dp[i] = dp[i - 5] + 1;
				} else if (dp[i - 3] != -1) {
					dp[i] = dp[i - 3] + 1;
				} else {
					dp[i] = -1;
				}
			}

			System.out.println(dp[N]);
		}

		br.close();
		return;
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	}
}
