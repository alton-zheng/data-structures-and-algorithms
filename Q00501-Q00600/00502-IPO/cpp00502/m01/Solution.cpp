class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {


        priority_queue<int, vector<int>, less<int>> pq;
        int idx = 0;
        int res = w;


        int len = profits.size();
        vector<pair<int, int>> help;

        for (int i = 0; i < len; i++) {
              help.push_back({capital[i], profits[i]});
        }

        sort(help.begin(), help.end());


        for (int i = 1; i <= k; i++) {
            while (idx < len && res >= help[idx].first) {
                pq.push(help[idx].second);
                idx++;
            }

            if (!pq.empty()) {
                res += pq.top();
                pq.pop();
            } else {
                break;
            }


        }

        return res;
    }
};