// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Three Divisors.
// Memory Usage: 5.9 MB, less than 33.33% of C++ online submissions for Three Divisors.
class Solution {
public:
    bool isThree(int n) {
        int cnt = 0;

        for (int i = 1; i <= sqrt(n); i++) {

            if (i * i == n) {
                cnt++;
            } else if (n % i == 0) {
                cnt += 2;
            }
        }

        return cnt == 3;
    }
};