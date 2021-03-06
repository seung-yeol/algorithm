package 프로그래머스.코딩테스트_고득점_Kit.스택큐;

import java.util.concurrent.LinkedBlockingQueue;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        for (int i : priorities) {
            queue.offer(i);
        }

        loop:
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int k : queue) {
                if (i < k) {
                    if (location == 0) {
                        location = queue.size();
                        System.out.println("location : " + location);
                    } else {
                        location--;
                    }
                    queue.offer(i);
                    continue loop;
                }
            }

            answer++;
            if (location == 0) {
                break;
            } else {
                location--;
            }

        }

        return answer;
    }
}
