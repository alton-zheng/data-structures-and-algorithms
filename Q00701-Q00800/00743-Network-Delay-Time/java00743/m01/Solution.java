package java00743.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 2021/8/2 9:20 上午
 * @Description:
 *
 * 743. Network Delay Time #264
 *
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node,
 * and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k.
 * Return the time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
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
 * 枚举所有所有场景，得到结果集
 *
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Network Delay Time.
 * Memory Usage: 43.7 MB, less than 36.42% of Java online submissions for Network Delay Time.
 *
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int DEFAULT = 5501;

        int[][] help = new int[n + 1][n + 1];

        // 将 help 二维数组元素默认为 DEFAULT
        // 根据题意： source -> target 最长时间为 100，这里将 help 子数组值全部更新为先默认 所有和 + 1 —》 5501
        for (int i = 0; i <= n; i++) {
            Arrays.fill(help[i], DEFAULT);
        }

        // 根据 time 信息，更新信号源 -> dest : help[source][dest] 所花费时间
        // 执行完后， 所有的 source -> target 花费的时间都会正确的更新到 help 中
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

        // 将网络节点 k 初始化 为 0， k -> k 只需要花费 0， 因为此题从 k 出发
        distance[k] = 0;

        // 定义节点是否被访问到
        boolean[] visit = new boolean[n + 1];

        // 开始遍历网络节点
        for (int i = 1; i <= n; i++) {

            int source = -1;

            // 每次处理时，找到当前接收到信号时间最短的网络节点
            // 首次处理时， source 肯定等于 k, 也就是上面初始时间为 0 的网络节点 k
            for (int dest = 1; dest <= n; dest++)  {
                if (!visit[dest] && (source == -1 || distance[dest] < distance[source])) {
                    source = dest;
                }
            }

            // 将收到信号最短的网络节点是否访问属性设置为 true
            visit[source] = true;

            // 开始更新以 source 出发， dest 为目的地的时间
            for (int dest = 1; dest <= n; dest++) {
                distance[dest] = Math.min(distance[dest], distance[source] + help[source][dest]);
            }
        }

        // 遍历完后，所有节点的 distance 都更新完成
        // 定义结果变量 res
        int res = -1;

        // 遍历所网络节点的 cost distance
        // 取最大的 distance 值作为结果值
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, distance[i]);
        }

        // 返回结果值， DEFAULT 时，返回 -1
        return res == DEFAULT ? -1 : res;
    }
}
