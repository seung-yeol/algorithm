package 프로그래머스.코딩테스트_고득점_Kit.힙;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 라면공장 {
    public static void main(String... args) {
        new 라면공장().solution(4, new int[]{4, 5, 6, 7, 10, 15}, new int[]{5, 3, 2, 5, 5, 6}, 30);
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        LinkedList<DS> dsQ = new LinkedList<>();

        for (int i = 0; i < supplies.length; i++) {
            dsQ.add(new DS(dates[i], supplies[i]));
        }

        PriorityQueue<DS> pq = new PriorityQueue<>();
        while (stock < k) {
            for (int i = 0; i < dsQ.size(); i++) {
                DS ds = dsQ.get(i);
                if (stock >= ds.date) {
                    pq.add(ds);
                    dsQ.remove(i);
                    i--;
                } else break;
            }
            stock += pq.poll().supply;
            answer++;
        }

        return answer;
    }

    class DS implements Comparable<DS> {
        DS(int date, int supply) {
            this.date = date;
            this.supply = supply;
        }

        int date;
        int supply;

        @Override
        public int compareTo(DS o) {
            return this.supply >= o.supply ? -1 : 1;    //내림차순
        }
    }
}
