// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Sum of All Odd Length Subarrays.
// Memory Usage: 8.5 MB, less than 12.72% of C++ online submissions for Sum of All Odd Length Subarrays.


class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {

        vector<int> help(arr.size() + 1);

        for (int i = 0; i < arr.size(); i++) {
            help[i + 1] = help[i] + arr[i];
        }

        int res = 0;

        for(int i = 0; i < arr.size(); i ++)
            for(int odd = 1; i + odd - 1 < arr.size(); odd += 2)
                res += help[i + odd] - help[i];
        return res;
    }
};