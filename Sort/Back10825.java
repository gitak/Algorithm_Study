package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back10825 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Student> students = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        input();

        output();
    }

    private static void output() {
        //주어진 기준으로 정렬
        Collections.sort(students);

        for (Student student : students) {
            sb.append(student.name);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student student = new Student(name, kor, eng, math);
            students.add(student);
        }
    }

    static class Student implements Comparable<Student> {
        private String name;
        private int kor;
        private int eng;
        private int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            //국어점수가 감소하는 순서
            if (this.kor != o.kor) {
                return o.kor - this.kor;
            }
            //국어 점수가 같으면 영어 점수가 증가하는 순서
            else if (this.eng != o.eng) {
                return this.eng - o.eng;
            }
            //국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서
            else if (this.math != o.math) {
                return o.math - this.math;
            }
            //모든 점수가 같으면 이름이 사전 순으로 증가하는 순서
            return this.name.compareTo(o.name);

        }
    }
}
