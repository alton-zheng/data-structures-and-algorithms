class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {

        int cnt = 0;
        int res = 0;

        for (int num: nums) {
            if (num == 1) {
                cnt++;
            } else {
                res = max(res, cnt);
                cnt = 0;
            }
        }

        res = max(res, cnt);

        return res;
    }
};