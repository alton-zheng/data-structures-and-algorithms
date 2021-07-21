// Runtime: 28 ms, faster than 70.76% of C++ online submissions for Rotate Array.
// Memory Usage: 25 MB, less than 36.49% of C++ online submissions for Rotate Array.
class Solution {
public:
    void rotate(vector<int>& nums, int k) {

        int len = nums.size();

        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);

    }

private:
    void reverse(vector<int>& arr, int start, int end) {
        while (start < end) {
            swap(arr[start], arr[end]);
            start++;
            end--;
        }
    }
};