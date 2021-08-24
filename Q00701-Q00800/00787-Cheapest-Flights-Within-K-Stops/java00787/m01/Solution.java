package java00787.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 2021/8/24 9:03 上午
 * @Description:
 * 787. Cheapest Flights Within K Stops
 *
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation: The graph is shown.
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 *
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation: The graph is shown.
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 10^4
 * There will not be any multiple flights between two cities.
 * 0 <= src, dst, k < n
 * src != dst
 *
 * Time Complexity: O((n + len) * k)
 * Space Complexity: O(n * k)
 * Runtime: 6 ms, faster than 59.87% of Java online submissions for Cheapest Flights Within K Stops.
 * Memory Usage: 40.5 MB, less than 30.09% of Java online submissions for Cheapest Flights Within K Stops.
 */
class Solution {

    private int INF = 10000 * 101 + 1;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] help = new int[k + 2][n];

        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(help[i], INF);
        }

        help[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int s = flight[0], d = flight[1], cost = flight[2];
                help[t][d] = Math.min(help[t][d], help[t - 1][s] + cost);
            }
        }

        int res = INF;
        for (int t = 1; t <= k + 1; t++) {
            res = Math.min(res, help[t][dst]);
        }

        return res == INF ? -1 : res;
    }
}
