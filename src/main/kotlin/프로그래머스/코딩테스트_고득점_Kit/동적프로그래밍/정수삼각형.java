package 프로그래머스.코딩테스트_고득점_Kit.동적프로그래밍;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int triangleLength = triangle.length;
        int[][] iii = new int[triangleLength][];
        iii[0] = new int[]{triangle[0][0]};

        for (int i = 1; i < triangleLength; i++) {
            int length = triangle[i].length;
            iii[i] = new int[length];

            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    iii[i][j] = iii[i - 1][0] + triangle[i][0];
                } else if (j == length - 1) {
                    iii[i][j] = iii[i - 1][j - 1] + triangle[i][j];
                } else {
                    if (iii[i - 1][j - 1] >= iii[i - 1][j]) {
                        iii[i][j] = iii[i - 1][j - 1] + triangle[i][j];
                    } else {
                        iii[i][j] = iii[i - 1][j] + triangle[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < iii[triangleLength - 1].length; i++) {
            int i1 = iii[triangleLength - 1][i];
            if (answer < i1) {
                answer = i1;
            }
        }

        return answer;
    }
}
