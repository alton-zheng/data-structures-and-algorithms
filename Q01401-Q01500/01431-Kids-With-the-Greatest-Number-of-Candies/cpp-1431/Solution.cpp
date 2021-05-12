class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int max = *max_element(candies.begin(), candies.end());

        vector<bool> res;

        for (int candy: candies) {
            res.push_back(candy + extraCandies >= maxCandies);
        }

       return res;

    }
};