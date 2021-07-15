// Runtime: 72 ms, faster than 77.32% of C++ online submissions for Boats to Save People.
// Memory Usage: 42 MB, less than 46.20% of C++ online submissions for Boats to Save People.
class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {

        sort(people.begin(), people.end());

        int res = 0;
        // 由于最重的人只会小于等于船的限重，所以
        int left = 0, right = people.size() - 1;

        // 由于 people 可能为单数个人，所以 left = right 的情况也要考虑进去
        while (left <= right) {
            res++;
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
        }

        return res;
    }
};