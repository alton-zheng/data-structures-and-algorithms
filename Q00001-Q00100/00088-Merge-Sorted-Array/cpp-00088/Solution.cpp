class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if (n <= 0) {
            return;
        }
        int nums1CurIndex = m - 1;
        int nums2CurIndex = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {

            if (nums1CurIndex >= 0 && nums2CurIndex >= 0 && nums1[nums1CurIndex] > nums2[nums2CurIndex]) {
                nums1[i] = nums1[nums1CurIndex];
                nums1CurIndex--;
            } else if (nums2CurIndex >= 0) {
                nums1[i] = nums2[nums2CurIndex];
                nums2CurIndex--;
            } else {
                nums1[i] = nums1[nums1CurIndex];
                nums1CurIndex--;
            }
        }
    }
};