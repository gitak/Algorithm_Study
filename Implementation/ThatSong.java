package Implementation;

public class ThatSong {
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int max_play_time = -1;

        //들은 악보의 #치환
        m = changeScore(m);

        for (String musicinfo : musicinfos) {
            String[] song = musicinfo.split(",");
            String title = song[2];

            //새로운 악보로 바꾸기
            String newScore = changeScore(song[3]);

            //시작시간과 끝난시간을 통해 재생시간 구하기
            String[] end = song[1].split(":");
            int end_time = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            String[] start = song[0].split(":");
            int start_time = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int play_time = end_time - start_time;

            //음악길이보다 재생시간이 긴 경우 -> 반복재생
            if (play_time > newScore.length()) {
                StringBuilder sb = new StringBuilder();

                //재생시간을 음악길이로 나눈 몫만큼 반복
                for (int i = 0; i < play_time / newScore.length(); i++) {
                    sb.append(newScore);
                }
                //몫을 제외한 나머지를 잘라서 붙임
                sb.append(newScore.substring(0, play_time % newScore.length()));
                newScore = sb.toString();
            }
            //재생시간만 악보붙이기
            else{
                newScore = newScore.substring(0, play_time);
            }

            //일치하는 악보가 있을때 재생시간이 긴 악보일 경우 업데이트
            if (newScore.contains(m) && play_time > max_play_time) {
                answer = title;
                max_play_time = play_time;
            }

        }

        //일치하는 악보가 없는 경우 "None"반환
        return max_play_time != -1 ? answer : "(None)";
    }

    //#이 들어가있는 두글자 음을 한글자 음으로 바꿔주는 메서드
     static String  changeScore(String oldScore) {
        oldScore = oldScore.replaceAll("C#", "H");
        oldScore = oldScore.replaceAll("D#", "I");
        oldScore = oldScore.replaceAll("F#", "J");
        oldScore = oldScore.replaceAll("G#", "K");
        String newScore = oldScore.replaceAll("A#", "L");

        return newScore;
    }
}
