class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
         int preOnePosition = -k - 1;

         for (int i = 0; i < nums.size(); i++) {

             if (nums[i] == 1) {

                 if (i - preOnePosition - 1 < k) {
                     return false;
                 }
                 preOnePosition = i;
             }
         }

         return true;
    }
};