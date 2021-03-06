package 프로그래머스.코딩테스트_고득점_Kit.해시;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<Integer, ArrayList<String>> map = new HashMap<>();
        Map<Integer, ArrayList<String>> map2 = new HashMap<>();

        initMap(participant, map);
        initMap(completion, map2);

        for (Integer c : map.keySet()) {
            ArrayList<String> s1 = map.get(c);
            ArrayList<String> s2 = map2.get(c);

            if (s2 == null) {
                return s1.get(0);
            }

            boolean b = false;
            if (s1.size() != s2.size()) {
                for (String s : s2) {
                    for (int i = 0; i < s1.size(); i++) {
                        if (s.equals(s1.get(i))) {
                            s1.remove(i);
                            b = false;
                            break;
                        }
                        else {
                            b = true;
                        }
                    }
                    if (b){
                        return s;
                    }
                }
                return s1.get(0);
            }
        }
        return answer;
    }

    private void initMap(String[] completion, Map<Integer, ArrayList<String>> map) {
        for (String s : completion) {
            Integer c = s.length();
            if (map.get(c) == null) {
                ArrayList<String> l = new ArrayList<>();
                l.add(s);
                map.put(c, l);
            } else {
                map.get(c).add(s);
            }
        }
    }
}
