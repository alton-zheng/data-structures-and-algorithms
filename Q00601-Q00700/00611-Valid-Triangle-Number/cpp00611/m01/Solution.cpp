class Solution {
public:
    int triangleNumber(vector<int>& nums) {

        int res = 0;
        int len = nums.size();

        if (len < 3) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            int x = nums[i];
            for (int j = i + 1; j < len; j++) {

                int y = nums[j];
                for (int k = j + 1; k < len; k++) {

                    int z = nums[k];
                    if (x + y > z && x + z > y && y + z > x) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
};