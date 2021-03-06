package 프로그래머스.코딩테스트_고득점_Kit.동적프로그래밍;

public class 타일장식물 {
    public long solution(int N) {
        long preBig = 1;
        long preSmall = 1;

        for (int i = 1; i < N; i++) {
            long newSmall = preBig;
            preBig = preBig + preSmall;
            preSmall = newSmall;
        }

        return preSmall * 2 + preBig * 2;
    }
}
