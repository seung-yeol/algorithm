package 프로그래머스.코딩테스트_고득점_Kit.정렬;

import java.util.Comparator;
import java.util.LinkedList;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];

            LinkedList<Integer> s = new LinkedList<>();
            for (int j = start-1; j < end; j++) {
                s.add(array[j]);
            }
            s.sort(new Ascending());

            answer[i] = s.get(target-1);
        }

        return answer;
    }

    class Ascending implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }

    }
}
