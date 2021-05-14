package java01518;

/**
 * @Author: alton
 * @Date: Created in 5/14/21 10:12 AM
 * @Description:
 * 1518. Water Bottles
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
 *
 * The operation of drinking a full water bottle turns it into an empty bottle.
 *
 * Return the maximum number of water bottles you can drink.
 * Input: numBottles = 9, numExchange = 3
 * Output: 13
 * Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 9 + 3 + 1 = 13
 * Example 3:
 *
 * Input: numBottles = 15, numExchange = 4
 * Output: 19
 * Explanation: You can exchange 4 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 15 + 3 + 1 = 19.
 *
 * Example 3:
 *
 * Input: numBottles = 5, numExchange = 5
 * Output: 6
 * Example 4:
 *
 * Input: numBottles = 2, numExchange = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 *
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 *
 */
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        int res = numBottles;
        int remain = numBottles;
        while (remain >= numExchange) {
            int temp = remain / numExchange;
            res += temp;
            remain = remain % numExchange + temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWaterBottles(9, 3));
    }
}
