class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        vector<bool> res(queries.size());

        vector<long> help(candiesCount.size() + 1);

        for (int i = 1; i < candiesCount.size() + 1; i++) {
            help[i] = help[i - 1] + candiesCount[i - 1];
        }

        for (int q = 0; q < queries.size(); q++) {
            int candiesType = queries[q][0], days = queries[q][1], dailyCap = queries[q][2];
            res[q] = !(days + 1 > help[candiesType + 1] || ((long)(days + 1) * dailyCap) < help[candiesType] + 1);
        }

        return res;
    }
};