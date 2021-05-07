#include <iostream>
#include <vector>

using namespace std;

/// Time Complexity: O(n)
/// Space Complexity: O(1)
class Solution {
public:
    int xorOperation(int n, int start) {

        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= (start + 2*i);
        }

        return res;
    }
};


int main() {

    cout << Solution().xorOperation(3, 2) << endl;

    return 0;
}
