package 코딩테스트_고득점_Kit.스택큐;

import java.util.Arrays;
import java.util.LinkedList;

public class 주식가격 {
    public static void main(String... args){
        주식가격 주식가격 = new 주식가격();
        System.out.println("답 : [4,3,1,1,0] : " + Arrays.toString(주식가격.solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println("답 : [1,3,1,1,0] : " + Arrays.toString(주식가격.solution(new int[]{3, 2, 3, 2, 3})));
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        prices[prices.length - 1] = -1;
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i < prices.length; i++) {
            queue.add(i - 1);
            for (int j = 0; j < queue.size(); j++) {
                int kkk = queue.get(j);
                if (prices[kkk] > prices[i]) {
                    answer[kkk] = i - kkk;
                    queue.remove(j);
                    j--;
                }
            }
        }

        return answer;
    }
}
