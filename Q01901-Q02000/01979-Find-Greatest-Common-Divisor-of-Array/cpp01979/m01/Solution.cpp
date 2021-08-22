// Runtime: 4 ms, faster than 57.14% of C++ online submissions for Find Greatest Common Divisor of Array.
// Memory Usage: 12.5 MB, less than 23.81% of C++ online submissions for Find Greatest Common Divisor of Array.
class Solution {
public:
    int findGCD(vector<int>& nums) {

        int minV = *min_element(nums.begin(), nums.end());
        int maxV = *max_element(nums.begin(), nums.end());

        return gcd(minV, maxV);
    }
};