package java00997.m01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: alton
 * @Date: Created in 6/18/21 10:09 PM
 * @Description:
 *
 * 997. Find the Town Judge #124
 *
 *In a town, there are n people labelled from 1 to n.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: n = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= n
 *
 * Runtime: 2 ms, faster than 99.88% of Java online submissions for Find the Town Judge.
 * Memory Usage: 46.6 MB, less than 59.33% of Java online submissions for Find the Town Judge.
 */
class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] help = new int[trust.length + 1];
        for (int[] t : trust) {
            help[t[0]]--;
            help[t[1]]++;

        }

        for (int i = 1; i <= trust.length; i++) {

            if (help[i] == trust.length - 1) {
                return i;
            }
        }

        return -1;
    }
}
