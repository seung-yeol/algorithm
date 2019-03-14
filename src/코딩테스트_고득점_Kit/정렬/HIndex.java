package 코딩테스트_고득점_Kit.정렬;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int n = citations.length;
        int hIndex = 0;

        Arrays.sort(citations);

        for (int i = 0; i < n; i++) {
            int val = citations[n - 1 - i];
            if (val >= i + 1) {
                hIndex = i + 1;
            }
        }

        return hIndex;
    }
}
