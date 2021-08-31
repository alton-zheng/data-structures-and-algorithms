
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            int left = i + 1, right = arr.size() - i,
            left_even = (left + 1) / 2,right_even = (right + 1) / 2,
            left_odd = left / 2, right_odd = right / 2;
            res += (left_odd * right_odd + left_even * right_even) * arr[i];
        }

        return res;
    }
};