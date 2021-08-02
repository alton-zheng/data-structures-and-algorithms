// Runtime: 100 ms, faster than 92.24% of C++ online submissions for Network Delay Time.
// Memory Usage: 37.4 MB, less than 91.66% of C++ online submissions for Network Delay Time.
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {

        int DEFAULT = 600001;
        vector<vector<int>> help(n + 1, vector<int>(n + 1, DEFAULT));

        for(vector<int>& time: times) {
            help[time[0]][time[1]] = time[2];
        }

        vector<int> distance(n + 1, DEFAULT);
        distance[k] = 0;

        vector<bool> visit(n + 1);


        for (int i = 1; i <= n; i++) {

            int source = -1;

            for (int dest = 1; dest <= n; dest++) {
                if (!visit[dest] && (source == -1 || distance[dest] < distance[source])) {
                    source = dest;
                }
            }

            visit[source] = true;

            for (int dest = 1; dest <= n; dest++) {
                distance[dest] = min(distance[dest], distance[source] + help[source][dest]);
            }
        }

        int res = -1;
        for (int i = 1; i <= n; i++) {
            res = max(res, distance[i]);
        }

        return res == DEFAULT ? -1 : res;


    }
};