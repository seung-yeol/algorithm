package 코딩테스트_고득점_Kit.이분법;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String... args) {
        입국심사 s = new 입국심사();
        System.out.println("답 : 28 : " + s.solution(6, new int[]{7, 10}));
        System.out.println("답 : 24 : " + s.solution(6, new int[]{6, 10}));
        System.out.println("답 : 3 : " + s.solution(5, new int[]{1, 1, 10}));
        System.out.println("답 : 18 : " + s.solution(11, new int[]{3, 4, 10}));
        System.out.println("답 : 6 : " + s.solution(3, new int[]{3, 4, 10}));
        System.out.println("답 : 6 : " + s.solution(1000000000, new int[]{3, 4, 1000000000}));
    }

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        //아오...
        long end = (long) times[times.length - 1] * (long) n;

        while (start <= end) {
            long mid = (end + start) / 2;
            long sum = 0;
            for (int time : times) {
                if (time > mid) break;
                sum += mid / time;
            }

            if (sum >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
