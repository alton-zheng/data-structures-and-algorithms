/**
 * 时间复杂度：O(nlog n)，其中 n 为 nums 数组的长度。二分查找最多需要二分 O(log n) 次，
 *           每次判断的时候需要 O(n) 遍历 nums 数组求解小于等于 mid 的数的个数，
 *           因此总时间复杂度为 O(nlogn)。
 * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
 */
class Solution1 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}