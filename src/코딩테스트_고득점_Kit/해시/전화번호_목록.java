package 코딩테스트_고득점_Kit.해시;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Map<Integer, LinkedList<String>> map = new HashMap<>();

        for (String s : phone_book) {
            int key = Integer.parseInt(s.substring(0, 1));
            LinkedList<String> tmp = map.getOrDefault(key, new LinkedList<>());
            tmp.add(s);
            map.put(key, tmp);
        }

        for (LinkedList<String> list : map.values()) {
            for (int i = 0; i < list.size() - 1; i++) {
                String k = list.get(i);
                int kLength = k.length();
                for (int j = i + 1; j < list.size(); j++) {
                    String kk = list.get(j);

                    if (kk.length() >= kLength) {
                        if (kk.startsWith(k)) return false;
                    } else if (k.startsWith(kk)) return false;
                }
            }
        }

        return true;
    }
}
