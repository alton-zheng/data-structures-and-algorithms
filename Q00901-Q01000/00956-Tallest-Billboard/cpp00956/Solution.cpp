class Solution {

private:
    vector<vector<int>> help;
    int getTallestBillboard(vector<int>& rods, int curIndex, int sum) {
        if (curIndex == rods.size()) {
            return sum == 5000 ? 0 : INT_MIN;
        }

        if (!help[curIndex][sum]) {
            return help[curIndex][sum];
        }

        int res = getTallestBillboard(rods, curIndex + 1, sum);
        res = max(res, getTallestBillboard(rods, curIndex + 1, sum + rods[curIndex]));
        res = max(res, rods[curIndex] + getTallestBillboard(rods, curIndex + 1, sum - rods[curIndex]));

        help[curIndex][sum] = res;
        return res;
    }
public:
    int tallestBillboard(vector<int>& rods) {

        help = vector<vector<int>>(rods.size(), vector<int>(10001, INT_MIN));
        return getTallestBillboard(rods, 0, 5000);
    }
};