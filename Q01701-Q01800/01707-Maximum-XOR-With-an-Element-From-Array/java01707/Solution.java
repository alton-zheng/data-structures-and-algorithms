package java01707;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: alton
 * @Date: Created in 5/23/21 5:15 PM
 * @Description:
 * 1707. Maximum XOR With an Element From Array #33
 * You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].
 *
 * The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.
 *
 * Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * Output: [3,3,7]
 * Explanation:
 * 1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * Example 2:
 *
 * Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * Output: [15,-1,5]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 *
 * Time Complexity : O(NlogN+QlogQ+(N+Q)⋅L) 其中 N 是数组 nums 的长度，Q 是数组 \textit{queries}queries 的长度，
 * L 是 nums 中的每个元素的二进制表示的长度，算法中固定 L=30。排序 nums 的时间复杂度为 O(NlogN)，排序 queries 的时间复杂度为 O(QlogQ)，
 * 每次插入和查询的时间复杂度均为 O(L)，因此总的时间复杂度为 O(NlogN+QlogQ+(N+Q)⋅L)。
 * Space Complexity: O(Q+N⋅L)。我们需要 O(Q) 的空间来存储每个查询在排序前的 queries 中的位置，且 nums 中的每个元素至多需要 O(L) 个字典树节点来存储，O(Q+N⋅L)。
 */
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int numQ = queries.length;
        int[][] newQueries = new int[numQ][3];
        for (int i = 0; i < numQ; ++i) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = i;
        }
        Arrays.sort(newQueries, new Comparator<int[]>() {
            @Override
            public int compare(int[] query1, int[] query2) {
                return query1[1] - query2[1];
            }
        });

        int[] ans = new int[numQ];
        Trie trie = new Trie();
        int idx = 0, n = nums.length;
        for (int[] query : newQueries) {
            int x = query[0], m = query[1], qid = query[2];
            while (idx < n && nums[idx] <= m) {
                trie.insert(nums[idx]);
                ++idx;
            }
            if (idx == 0) { // 字典树为空
                ans[qid] = -1;
            } else {
                ans[qid] = trie.getMaxXor(x);
            }
        }
        return ans;
    }
}

class Trie {
    static final int L = 30;
    Trie[] children = new Trie[2];

    public void insert(int val) {
        Trie node = this;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new Trie();
            }
            node = node.children[bit];
        }
    }

    public int getMaxXor(int val) {
        int ans = 0;
        Trie node = this;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit ^ 1] != null) {
                ans |= 1 << i;
                bit ^= 1;
            }
            node = node.children[bit];
        }
        return ans;
    }
}
