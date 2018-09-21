package 코딩테스트_고득점_Kit.스택큐;

import java.util.LinkedList;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int currentWeight = truck_weights[0];
        LinkedList<Truck> trucks = new LinkedList<>();
        trucks.add(new Truck(truck_weights[0], bridge_length));


        for (int i = 1; i < truck_weights.length; i++) {
            //도로 끝에 있는지 체크하기위해
            boolean firstCheck = false;
            for (Truck t : trucks) {
                t.remain--;
                if (t.remain == 0) {
                    firstCheck = true;
                }
            }
            if (firstCheck) {
                currentWeight -= trucks.pollFirst().weight;
            }

            int truckWeight = truck_weights[i];

            while (true) {
                if (currentWeight + truckWeight <= weight) {
                    currentWeight += truckWeight;
                    trucks.add(new Truck(truckWeight, bridge_length));
                    answer++;
                    break;
                } else {
                    Truck t = trucks.pollFirst();
                    currentWeight -= +t.weight;

                    answer += t.remain;

                    for (Truck tt : trucks) {
                        tt.remain -= t.remain;
                    }
                }
            }
        }

        answer += trucks.pollLast().remain;

        return answer;
    }

    class Truck {
        //무게
        int weight;
        //남은거리
        int remain;

        Truck(int weight, int remain) {
            this.weight = weight;
            this.remain = remain;
        }
    }
}
