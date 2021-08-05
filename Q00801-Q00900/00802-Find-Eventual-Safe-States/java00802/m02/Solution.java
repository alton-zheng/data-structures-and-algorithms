package java00802.m02;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 2021/8/5 2:35 下午
 * @Description：
 * Runtime: 18 ms, faster than 39.66% of Java online submissions for Find Eventual Safe States.
 * Memory Usage: 47 MB, less than 96.92% of Java online submissions for Find Eventual Safe States.
 *
 * 802. Find Eventual Safe States
 *
 * We start at some node in a directed graph, and every turn, we walk along a directed edge of the graph. If we reach a terminal node (that is, it has no outgoing directed edges), we stop.
 *
 * We define a starting node to be safe if we must eventually walk to a terminal node. More specifically, there is a natural number k, so that we must have stopped at a terminal node in less than k steps for any choice of where to walk.
 *
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 *
 * The directed graph has n nodes with labels from 0 to n - 1, where n is the length of graph. The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph, going from node i to node j.
 *
 *
 *
 * Example 1:
 *
 * Illustration of graph
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Example 2:
 *
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * graph[i] is sorted in a strictly increasing order.
 * The graph may contain self-loops.
 * The number of edges in the graph will be in the range [1, 4 * 104].
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int len = graph.length;

        int[] help = new int[len];
        List<List<Integer>> rg = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            rg.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            for (int g: graph[i]) {
                rg.get(g).add(i);
            }

            help[i] = graph[i].length;
        }

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (help[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.pop();
            for(int i : rg.get(cur)) {
                if (--help[i] == 0) {
                    queue.add(i);
                }
            }
        }


        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (help[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
