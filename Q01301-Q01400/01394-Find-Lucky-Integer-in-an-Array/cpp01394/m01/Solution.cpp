// Runtime: 4 ms, faster than 93.29% of C++ online submissions for Find Lucky Integer in an Array.
// Memory Usage: 10.1 MB, less than 92.93% of C++ online submissions for Find Lucky Integer in an Array.
class Solution {
public:
    int findLucky(vector<int>& arr) {

        int cur = 0, count = -1;

        sort(arr.begin(), arr.end());

        for (int i = arr.size() - 1; i >= 0; i--) {

            if (cur != arr[i]) {
                if (count == cur) {
                    return cur;
                }

                cur = arr[i];
                count = 1;
            } else {
                count++;
            }
        }

        return count == cur ? cur : -1;

    }
};