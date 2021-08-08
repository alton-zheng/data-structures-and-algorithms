// Runtime: 348 ms, faster than 100.00% of C++ online submissions for Remove Stones to Minimize the Total.
// Memory Usage: 94.5 MB, less than 100.00% of C++ online submissions for Remove Stones to Minimize the Total.
class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {

        // 生效最大堆
        make_heap(piles.begin(), piles.end());

        for (int i = 0; i < k; i++){
            // 弹出最大值，将之减去 piles.back() / 2;
            pop_heap(piles.begin(), piles.end());
            piles.back() -= piles.back() / 2;

            // 然后，再压入
            push_heap(piles.begin(), piles.end());
        }

        // 累计
        return accumulate(piles.begin(), piles.end(), 0);
    }
};