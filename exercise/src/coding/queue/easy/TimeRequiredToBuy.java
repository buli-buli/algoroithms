package coding.queue.easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassNAME TimeRequiredToBuy
 * @Description 买票需要的时间
 * @Author yu
 * @Date 2023/6/30 17:36
 * @Version 1.0
 */
public class TimeRequiredToBuy {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Pair<Integer, Integer>> tQueue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++){
            tQueue.add(new Pair<>(i, tickets[i]));
        }

        int num = tickets[k];
        int sum = 0;

        while(num > 0){
            Pair<Integer, Integer> one = tQueue.poll();
            if (one.getKey() == k){
                num--;
            }
            if (one.getValue() > 0){
                tQueue.add(new Pair<>(one.getKey(), one.getValue() - 1));
            }

            sum+=1;
        }

        return sum;
    }
}
