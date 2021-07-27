package java01791.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/27 1:23 下午
 * @Description:
 * 1791. Find Center of Star Graph #246
 *
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 *
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
 * Example 2:
 *
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * The given edges represent a valid star graph.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Center of Star Graph.
 * Memory Usage: 64.5 MB, less than 72.41% of Java online submissions for Find Center of Star Graph.
 */
class Solution {
    public int findCenter(int[][] edges) {

        // 要么首条 edge 第一个节点(edges[0][0])是交点，
        // 要么首边 edge 第二个节点(edge[0][1])是交点
        return (edges[0][0]==edges[1][0] || edges[0][0]==edges[1][1])?edges[0][0] : edges[0][1];
    }
}
