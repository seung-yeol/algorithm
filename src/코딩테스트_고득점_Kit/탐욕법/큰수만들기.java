package 코딩테스트_고득점_Kit.탐욕법;


public class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        int preInt = 99;    // char 48이 숫자 0임
        for (int i = 0; i < sb.length() && k > 0; i++) {
            int nextInt = sb.charAt(i);

            if (preInt >= nextInt) {
                preInt = nextInt;
            } else {
                k--;

                i--;
                sb.deleteCharAt(i);
                i--;
                if (i != -1) preInt = sb.charAt(i);
                else preInt = 99;
            }

            if (i == sb.length() - 1) {
                for (; k > 0; k--) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return sb.toString();
    }
}
