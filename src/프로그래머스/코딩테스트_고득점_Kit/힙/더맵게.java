package 프로그래머스.코딩테스트_고득점_Kit.힙;

import java.util.ArrayList;
import java.util.List;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        boolean isFail = true;

        //귀찮아서 그냥 정렬시킴(이렇게하면 시간은 더걸려도 그래도 최소힙 구조니까..)
        for (int i : scoville) {
            if (i < K) {
                list.add(i);
            } else {
                isFail = false;
            }
        }
        list.sort(null);

        while (list.size() > 1) {
            answer++;
            int a = getMinimum(list);
            int b = getMinimum(list);
            int sum = a + b * 2;

            if (K > sum) {
                list.add(sum);
                backHeapify(list, list.size());
            } else isFail = false;
        }
        if (list.size() == 1 && !isFail) {
            answer++;
        }

        if (isFail) {
            return -1;
        }

        return answer;
    }

    //데이터 삽입시 사용되는 힙형태로 변경하는 메서드
    private void backHeapify(List<Integer> list, int childPosition) {
        if (childPosition < 2) {
            return;
        }
        Integer parent = list.get(childPosition / 2 - 1);
        Integer me = list.get(childPosition-1);

        if (me < parent) {
            list.set(childPosition / 2 - 1, me);
            list.set(childPosition - 1, parent);
            backHeapify(list, childPosition / 2);
        }
    }

    //데이터 꺼낼시 사용되는 힙형태로 변경하는 메서드
    private void heapify(List<Integer> list, int parentPosition) {
        if (list.size() < parentPosition) {
            return;
        }

        Integer me = list.get(parentPosition - 1);
        Integer left;
        Integer right;

        if (list.size() > parentPosition * 2) {
            left = list.get(parentPosition * 2 - 1);
            right = list.get(parentPosition * 2);

            if (left <= right) {
                if (left < me) {
                    list.set(parentPosition - 1, left);
                    list.set(parentPosition * 2 - 1, me);
                    heapify(list, parentPosition * 2);
                }
            } else {
                if (right < me) {
                    list.set(parentPosition - 1, right);
                    list.set(parentPosition * 2, me);
                    heapify(list, parentPosition * 2 + 1);
                }
            }
        } else if (list.size() > parentPosition * 2 - 1) {
            left = list.get(parentPosition * 2 - 1);

            if (left < me) {
                list.set(parentPosition - 1, left);
                list.set(parentPosition * 2 - 1, me);
            }
        }
    }

    //힙에서 최소값 꺼내는 메서드
    private int getMinimum(ArrayList<Integer> list) {
        int minimum = list.get(0);
        if (list.size() > 1) {
            int last = list.remove(list.size() - 1);
            list.set(0, last);
            heapify(list, 1);
        }
        else list.clear();

        return minimum;
    }
}
