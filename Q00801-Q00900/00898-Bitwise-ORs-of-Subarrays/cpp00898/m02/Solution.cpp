// Runtime: 492 ms, faster than 80.21% of C++ online submissions for Bitwise ORs of Subarrays.
// Memory Usage: 97.7 MB, less than 98.33% of C++ online submissions for Bitwise ORs of Subarrays.
class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        int n = arr.size();
        if(n < 2) return n;
        unordered_set<int> res;

        for(int i = 0; i < n; i++) {
            res.insert(arr[i]);
            for(int j = i - 1; j >= 0; j--) {
                if((arr[j] & arr[i]) == arr[i]) break;
                arr[j] |= arr[i];
                res.insert(arr[j]);
            }
        }

        return res.size();
    }
};