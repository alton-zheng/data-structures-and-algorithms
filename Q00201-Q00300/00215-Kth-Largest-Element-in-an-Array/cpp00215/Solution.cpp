// Runtime: 4 ms, faster than 97.87% of C++ online submissions for Kth Largest Element in an Array.
// Memory Usage: 10 MB, less than 82.09% of C++ online submissions for Kth Largest Element in an Array.
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        srand(time(0));
        return getKthLargest(nums, 0, nums.size() - 1, k - 1);
    }

private:
  int getKthLargest(vector<int>& nums, int startIndex, int endIndex, int target) {
        int temp = rand() % (endIndex - startIndex + 1) + startIndex;
        swap(nums[startIndex], nums[temp]);
        int curIndex = quickOrder(nums, startIndex, endIndex);

        if (curIndex == target) {
            return nums[curIndex];
        }

        return curIndex < target
                ? getKthLargest(nums, curIndex + 1, endIndex, target)
                : getKthLargest(nums, startIndex, curIndex - 1, target);

    }

   int quickOrder(vector<int>& nums, int startIndex, int endIndex) {
        int compare = nums[startIndex];
        int i = startIndex, j = endIndex + 1;

        while (true) {
            while (++i <= endIndex && nums[i] > compare);
            while (--j >= startIndex && nums[j] < compare);

            if (i >= j) {
                break;
            }
            swap(nums[i], nums[j]);
        }

        swap(nums[startIndex], nums[j]);
        return j;
    }

};