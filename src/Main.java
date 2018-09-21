import 코딩테스트_고득점_Kit.정렬.K번째수;
import 코딩테스트_고득점_Kit.해시.완주하지못한선수;

public class Main {

    public static void main(String[] args) {
        K번째수 k = new K번째수();
        int[] s = k.solution(	new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}} );
        for (Integer i : s) {
            System.out.println(i);
        }
    }
}