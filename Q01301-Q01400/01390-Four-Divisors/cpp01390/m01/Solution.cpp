// Runtime: 16 ms, faster than 100.00% of C++ online submissions for Four Divisors.
// pMemory Usage: 12.5 MB, less than 47.59% of C++ online submissions for Four Divisors.

class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {

        int res = 0;

        for (int num: nums) {

            int cnt = 0;
            int sum = 0;

            for (int i = 1; i * i < num; i++) {
                if (num % i == 0) {
                    cnt += 2;
                    sum += i;
                    sum += num / i;
                }

                if (cnt > 4) {
                    break;
                }
            }

            int x = sqrt(num);
            if (x * x == num) {
                cnt++;
            }

            if (cnt == 4) {
                res += sum;
            }
        }

        return res;

    }
};