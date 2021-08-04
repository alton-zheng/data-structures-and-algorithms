// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Subsets II.
// Memory Usage: 11.7 MB, less than 23.56% of C++ online submissions for Subsets II.


class Solution {

private:
    vector<vector<int>> res;
    vector<int> temp;
    int len;
    vector<int> nums;

    void dfs(bool isSelect, int idx) {
        if (idx == len) {
            res.push_back(temp);
            return;
        }

        dfs(false, idx + 1);
        if (idx > 0 && !isSelect && nums[idx - 1] == nums[idx]) {
            return;
        }

        temp.push_back(nums[idx]);
        dfs(true, idx + 1);
        temp.pop_back();
    }
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {

        len = nums.size();
        this -> nums = nums;

        sort(this -> nums.begin(), this -> nums.end());

        dfs(false, 0);

        return res;

    }
};