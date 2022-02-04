package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Back14226 {

    public static void main(String[] args) throws IOException {
        //입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        br.close();//입력 종료

        bfs(S);
    }

    //이모티콘의 정보를 담을 클래스
    static class Emoticon{
        int clipboard = 0;
        int screen = 0;
        int second = 0;

        public Emoticon(int clipboard, int screen, int second) {
            this.clipboard = clipboard;
            this.screen = screen;
            this.second = second;
        }
    }

    //visited배열의 행은 클립보드 이모티콘 개수, 열은 화면 이모티콘 개수 -> 화면에 이모티콘이 S개가 있을 때 최소 시간을 구하기 위해
    static boolean[][] visited = new boolean[1001][1001];

    static void bfs(int S) {
        Queue<Emoticon> q = new LinkedList<>();
        q.offer(new Emoticon(0, 1, 0));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            Emoticon now_emoticon = q.poll();

            if (now_emoticon.screen == S) {
                System.out.println(now_emoticon.second);
                return;
            }

            //1. 클립보드에 복사
            q.offer(new Emoticon(now_emoticon.screen, now_emoticon.screen, now_emoticon.second + 1));

            //2. 클립보드의 이모티콘을 화면에 붙혀넣기
            if (now_emoticon.clipboard != 0 && now_emoticon.clipboard + now_emoticon.screen <= S
                    && !visited[now_emoticon.clipboard][now_emoticon.screen + now_emoticon.clipboard]) {

                q.offer(new Emoticon(now_emoticon.clipboard, now_emoticon.screen
                        + now_emoticon.clipboard, now_emoticon.second + 1));
                visited[now_emoticon.clipboard][now_emoticon.clipboard + now_emoticon.screen] = true;
            }

            //3. 화면에서 이모티콘 하나 삭제
            if (now_emoticon.screen >= 1 && !visited[now_emoticon.clipboard][now_emoticon.screen - 1]) {
                q.offer(new Emoticon(now_emoticon.clipboard, now_emoticon.screen - 1,
                        now_emoticon.second + 1));
                visited[now_emoticon.clipboard][now_emoticon.screen - 1] = true;
            }
        }

    }
}
