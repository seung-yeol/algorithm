package level5;

import kotlin.Pair;

import java.util.LinkedList;

public class ChooSeok {

    public int Solution(String[] lines) {
        int answer = 0;

        LinkedList<Pair<Double,Double>> list = new LinkedList<>();

        for (String s : lines) {
            String[] ss = s.split(" ");

            String time = ss[1];
            String sProcess = ss[2];

            String[] splitted = time.split(":");

            double end = Double.valueOf(splitted[0]) * 3600 + Double.valueOf(splitted[1]) * 60 + Double.valueOf(splitted[2]);
            double process = Double.valueOf(sProcess.substring(0, sProcess.length() - 1));
            double start = end - process + 0.001;

            Pair<Double,Double> vo = new Pair<>(start, end);

            list.add(vo);

            int current = 0;

            double d = vo.getSecond() - list.peekFirst().getSecond();
            if (d >= 3.999) {
                list.pollFirst();
            }

            current = getCurrent(list, current);

            if (answer < current) answer = current;
        }

        while (list.size() != 0){
            int current = getCurrent(list, 0);
            if (answer < current) answer = current;

            list.pollFirst();
        }

        return answer;
    }

    private int getCurrent(LinkedList<Pair<Double,Double>> list, int current) {
        for (int i = 0; i < list.size(); i++) {
            double dd = list.get(i).getFirst() - list.peekFirst().getFirst();

            System.out.println("dd : " + dd);

            if (dd < 1) {
                System.out.println("dd : ");
                current++;
            }
        }
        return current;
    }
}