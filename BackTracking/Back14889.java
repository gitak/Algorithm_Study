package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back14889 {

	static int N;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;


	public static void main(String[] args) throws IOException {
		input();
		logic();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}

	}

	private static void logic() {
		comb(0, 0);
		System.out.println(min);
	}

	//count는 조합 개수(재귀 깊이)
	private static void comb(int idx, int count) {

		//팀 조합이 완성될 경우
		if (count == N / 2) {
			diff();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}

	//두 팀의 능력치 차이를 구하는 함수
	static void diff() {
		int team_start = 0;
		int team_link = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {

				//i번째 사람과 j번째 사람이 true인 경우 스타트팀 점수 계산
				if (visited[i] == true && visited[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}else if(visited[i] == false & visited[j] == false){
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}

		int val = Math.abs(team_start - team_link);

		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}

		min = Math.min(min, val);

	}
}

