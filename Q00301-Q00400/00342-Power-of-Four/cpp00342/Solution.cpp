package cpp00342;

/**
 * @Author: alton
 * @Date: Created in 5/25/21 5:13 PM
 * @Description:
 */
class Solution {
public:
    bool isPowerOfFour(int n) {
        return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
};