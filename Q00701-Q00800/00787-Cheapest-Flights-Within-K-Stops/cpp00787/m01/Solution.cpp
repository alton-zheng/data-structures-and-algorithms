/**
Runtime: 188 ms, faster than 20.25% of C++ online submissions for Cheapest Flights Within K Stops.
Memory Usage: 49.6 MB, less than 11.37% of C++ online submissions for Cheapest Flights Within K Stops.
*/
class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {

        int INF = 101 * 10000 + 1;
        vector<int> help(n, INF);

        help[src] = 0;

        int res = INF;

        for (int t = 1; t <= k + 1; t++) {
            vector<int> h(n, INF);

            for (vector<int> flight: flights) {
                int s = flight[0], d = flight[1], c = flight[2];

                h[d] = min(h[d], help[s] + c);
            }

            help = move(h);

            res = min(res, help[dst]);


        }

        return res == INF ? -1 : res;
    }
};