package java00502.m01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @Author: alton
 * @Date: Created in 2021/9/8 8:41 上午
 * @Description:
 */
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int len = profits.length;
        int idx = 0;
        Help[] help = new Help[len];

        for (int i = 0; i < len; ++i) {
            help[i] = new Help(capital[i], profits[i]);
        }

        Arrays.sort(help);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (idx < len && help[idx].cap <= w) {
                pq.add(help[idx].profit);
                idx++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }

    class Help implements Comparable<Help> {

        private int profit, cap;

        public Help(int cap, int profit) {
            this.profit = profit;
            this.cap = cap;
        }

        public int getProfit() {
            return profit;
        }

        public int getCap() {
            return cap;
        }

        @Override
        public int compareTo(Help o) {
            return this.cap - o.cap;
        }
    }
}
