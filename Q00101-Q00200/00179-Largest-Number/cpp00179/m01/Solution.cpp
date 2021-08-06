// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Largest Number.
// Memory Usage: 10.8 MB, less than 100.00% of C++ online submissions for Largest Number.
class Solution {
public:
    string largestNumber(vector<int>& nums) {

        int len = nums.size();

        sort(nums.begin(), nums.end(), [](const int a, const int b) {
           long x = 10, y = 10;
            while (x <= a) {
                x *= 10;
            }

            while(y <= b) {
                y *= 10;
            }

            return y*a + b > x*b + a;
        });

        if (nums[0] == 0) {
            return "0";
        }
        string res;

        for (int num: nums) {
            res += to_string(num);
        }

        return res;
    }
};