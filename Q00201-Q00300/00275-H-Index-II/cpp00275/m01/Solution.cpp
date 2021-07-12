// Runtime: 28 ms, faster than 14.47% of C++ online submissions for H-Index II.
// Memory Usage: 18.7 MB, less than 42.89% of C++ online submissions for H-Index II.
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int len = citations.size();
        int left = 1 , right = len + 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            // 论文引用次数下表（len - mid） 值大于等于 mid 说明 h 至少不比 mid 小
            if (citations[len - mid] >= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
};