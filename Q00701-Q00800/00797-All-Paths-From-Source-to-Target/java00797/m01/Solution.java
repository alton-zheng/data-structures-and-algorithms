package java00797.m01;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 2021/8/25 3:56 下午
 * @Description:
 * 797. All Paths From Source to Target
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 *
 *
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * Example 3:
 *
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 * Example 4:
 *
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 * Example 5:
 *
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 *
 * Time Complexity: O(n * n^2)
 * Space Complexity: O(n)
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for All Paths From Source to Target.
 * Memory Usage: 40.3 MB, less than 91.55% of Java online submissions for All Paths From Source to Target.
 */
class Solution {

    private List<List<Integer>> res;
    private Deque<Integer> stack;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        stack = new LinkedList<>();

        stack.addLast(0);

        int len = graph.length;
        dfs(graph, 0, len - 1);

        return res;
    }

    private void dfs(int[][] graph, int cur, int target) {
        if (cur == target) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int g: graph[cur]) {
            stack.offerLast(g);
            dfs(graph, g, target);
            stack.pollLast();
        }
    }
}
