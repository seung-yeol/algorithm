package 프로그래머스.코딩테스트_고득점_Kit.탐욕법;

import java.util.HashMap;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i + 1, 1);
        }
        for (int i : lost) {
            map.put(i, map.get(i) - 1);
        }
        for (int i : reserve) {
            map.put(i, map.get(i) + 1);
        }

        int pre = map.get(1);
        for (int i = 2; i < n + 1; i++) {
            Integer k = map.get(i);

            if (k == 0) {
                if (pre == 2){
                    map.put(i, 1);
                    map.put(i-1, 1);
                }
                else if ( map.containsKey(i+1) && map.get(i + 1) == 2) {
                    map.put(i, 1);
                    map.put(i + 1, 1);
                }
            }
            pre = map.get(i);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i+1) >= 1){
                answer++;
            }
        }

        return answer;
    }
}
