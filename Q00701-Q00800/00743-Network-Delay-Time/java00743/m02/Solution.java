package java00743.m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: alton
 * @Date: Created in 2021/8/2 9:20 上午
 * @Description:
 *
 * 743. Network Delay Time #264
 *
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 *
 * Time Complexity: O(n^2 + m)
 * Space Complexity: O(n^2)
 * Dijkstra 算法
 * 小根堆替换了枚举方法中找到时间最短的网络节点
 *
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Network Delay Time.
 * Memory Usage: 43.7 MB, less than 36.42% of Java online submissions for Network Delay Time.
 *
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int DEFAULT = 60001;

        int[][] help = new int[n + 1][n + 1];

        // 将 help 二维数组元素默认为 DEFAULT
        for (int i = 0; i <= n; i++) {
            Arrays.fill(help[i], DEFAULT);
        }

        // 更新信号源 -> dest : help[source][dest] 所花费时间
        for (int i = 0; i < times.length; i++) {
            int[] cur = times[i];
            help[cur[0]][cur[1]] = cur[2];
        }

        // 定义维护到网络节点花费时间信息的变量
        int[] distance = new int[n + 1];

        // 默认为 DEFAULT
        for (int i = 0; i <= n; i++) {
            distance[i] = DEFAULT;
        }

        // 将网络节点 k 初始化 为 0， 因为此题从 k 出发
        distance[k] = 0;

        // 维护优先队列-小根堆,寻找与 「未确认节点」与起点距离最近的点
        // 本质上仅仅将枚举方法中找到当前延迟时间最小的网络节点换成了小根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {

            int[] p = pq.poll();
            int time = p[0], source = p[1];

            if (distance[source] < time) {
                continue;
            }

            for (int dest = 1; dest <= n; dest++) {
                int cur = distance[source] + help[source][dest];
                if (cur < distance[dest]) {
                    distance[dest] = cur;
                    pq.offer(new int[]{cur, dest});
                }
            }
        }

        int res = -1;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, distance[i]);
        }
        return res == DEFAULT ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}}, 4, 2));
    }
}
