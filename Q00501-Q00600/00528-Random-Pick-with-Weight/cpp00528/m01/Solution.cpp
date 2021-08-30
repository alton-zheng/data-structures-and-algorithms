// Runtime: 121 ms, faster than 22.49% of C++ online submissions for Random Pick with Weight.
// Memory Usage: 40.9 MB, less than 8.54% of C++ online submissions for Random Pick with Weight.
class Solution {
private:
    mt19937 gen;
    uniform_int_distribution<int> dis;
    vector<int> pre;
public:
    Solution(vector<int>& w) : gen(random_device{}()), dis(1, accumulate(w.begin(), w.end(), 0)) {
        partial_sum(w.begin(), w.end(), back_inserter(pre));
    }

    int pickIndex() {
        int x = dis(gen);
        return lower_bound(pre.begin(), pre.end(), x) - pre.begin();
    }

}