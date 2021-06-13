/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {

        int left = 1, right = n, mid;

        while (true) {
            mid = left + (right - left) / 2;
            switch (guess(mid)) {
                case 0:
                    return mid;
                case -1:
                    right = mid;
                    break;
                default:
                    left = mid + 1;
                    break;
            }
        }
    }
};