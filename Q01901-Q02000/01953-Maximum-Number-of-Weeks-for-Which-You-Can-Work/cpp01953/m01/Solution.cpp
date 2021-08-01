// Runtime: 124 ms, faster than 83.33% of C++ online submissions for Maximum Number of Weeks for Which You Can Work.
// Memory Usage: 75.5 MB, less than 33.33% of C++ online submissions for Maximum Number of Weeks for Which You Can Work.class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {

        // 定义两个变量， ohter 除了最长工作的周数， l 所有项目中，工作时长最长的时间
        long long l = *max_element(milestones.begin(), milestones.end());
        long long other = accumulate(milestones.begin(), milestones.end(), 0LL) - l;

        // 当  l 大于其它工作周数 + 1 时，意味着工作量最长的项目做不完
        return l > other + 1 ? 2 * other + 1 : l + other;
    }
};