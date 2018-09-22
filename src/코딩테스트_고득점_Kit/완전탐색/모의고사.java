package 코딩테스트_고득점_Kit.완전탐색;

import java.util.LinkedList;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] player = new int[3];

        player[0] = getI(answers, first);
        player[1] = getI(answers, second);
        player[2] = getI(answers, third);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);

        for (int i = 1; i < player.length; i++) {
            if (player[list.peek()] < player[i]){
                list.clear();
                list.add(i);
            }
            else if (player[list.peek()] == player[i]){
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i) +1;
        }

        return answer;
    }

    private int getI(int[] answers, int[] arr) {
        int v = 0;

        int k = 0;
        for (int i : answers) {
            int position = k % arr.length;

            if (i == arr[position]) {
                v++;
            }

            k++;
        }
        return v;
    }
}
