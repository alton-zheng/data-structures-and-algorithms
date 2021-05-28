
class Solution {
public:
    int totalHammingDistance(vector<int>& nums) {

        int res = 0, numsLen = nums.size();

        for (int l = 0;  l < 30; l++) {

            int one = 0;
            for (int num: nums) {
                one += (num >> l) & 1;
            }

            res += one * (numsLen - one);
        }

        return res;
    }
};