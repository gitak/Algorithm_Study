package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back5639 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> bin_tree;

    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {
        traverse(0, bin_tree.size() - 1);
        System.out.println(sb);
    }


    //현재 subtree가 bin_tree[left..right]일 때, 후위 순회를 하는 함수
    static void traverse(int left, int right) {
        if(left > right) return;
        int mid = right; //왼쪽과 오른쪽 subtree를 가르는 기준 위치를 나타내는 변수
        for (int i = left + 1; i <= right; i++) {
            if (bin_tree.get(i) > bin_tree.get(left)) {
                mid = i - 1;
                break;
            }
        }

        //후위순회
        traverse(left + 1, mid);
        traverse(mid + 1, right);
        sb.append(bin_tree.get(left)).append('\n'); // 루트노드를 마지막에 출력
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        bin_tree = new ArrayList<>();
        while ((input = br.readLine()) != null) {
            bin_tree.add(Integer.parseInt(input));
        }
    }
}
