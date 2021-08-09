

// Runtime: 1200 ms, faster than 11.73% of C++ online submissions for Super Ugly Number.
// Memory Usage: 135.6 MB, less than 5.22% of C++ online submissions for Super Ugly Number.

class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {

        unordered_set<long> help;
        priority_queue<long, vector<long> , greater<long>> heap;

        help.insert(1);
        heap.push(1);

        for (int i = 1; i <= n; i++) {
            long item = heap.top();
            heap.pop();

            if (i == n) {
                return (int)item;
            }
            for (int prime: primes) {
                long cur = item * prime;
                if (help.insert(cur).second) {
                    heap.push(cur);
                }
            }
        }

        return 1;
    }
};