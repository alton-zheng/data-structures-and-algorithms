package java00847.m01;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: alton
 * @Date: Created in 2021/8/6 10:41 上午
 * @Description:
 * 847. Shortest Path Visiting All Nodes #276
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
 *
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * Example 2:
 *
 *
 * Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 1 <= n <= 12
 * 0 <= graph[i].length < n
 * graph[i] does not contain i.
 * If graph[a] contains b, then graph[b] contains a.
 * The input graph is always connected.
 *
 * Time Complexity: O(N^2*2^N)
 * Space Complexity: O(N*2^N)
 *
 * Runtime: 7 ms, faster than 93.59% of Java online submissions for Shortest Path Visiting All Nodes.
 * Memory Usage: 39 MB, less than 87.19% of Java online submissions for Shortest Path Visiting All Nodes.
 *
 */
class Solution {
    public int shortestPathLength(int[][] graph) {

        int len = graph.length;

        boolean[][] visit = new boolean[len][1 << len];

        Deque<int[]> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            visit[i][1 << i] = true;
        }

        int res = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.pop();
            int label = cur[0], mask = cur[1], l = cur[2];

            if (mask == (1 << len) - 1) {
                res = l;
                break;
            }

            for (int node : graph[label]) {
                int m = mask | (1 << node);

                if (!visit[node][m]) {
                    queue.offer(new int[]{node, m, l + 1});
                    visit[node][m] = true;
                }

            }
        }

        return res;
    }
}
