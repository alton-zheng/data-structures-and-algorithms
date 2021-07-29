package java01344.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/29 3:07 下午
 * @Description:
 * 1344. Angle Between Hands of a Clock
 *
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: hour = 12, minutes = 30
 * Output: 165
 * Example 2:
 *
 *
 *
 * Input: hour = 3, minutes = 30
 * Output: 75
 * Example 3:
 *
 *
 *
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 * Example 4:
 *
 * Input: hour = 4, minutes = 50
 * Output: 155
 * Example 5:
 *
 * Input: hour = 12, minutes = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * Answers within 10^-5 of the actual value will be accepted as correct.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Angle Between Hands of a Clock.
 * Memory Usage: 36.2 MB, less than 57.50% of Java online submissions for Angle Between Hands of a Clock.
 *
 */
class Solution {
    public double angleClock(int hour, int minutes) {
        double m = minutes / 5.0;
        double  h = hour % 12 + minutes / 60.0;
        double x = 360 * (Math.abs(m - h)) / 12;
        return Math.min(x, 360 - x);
    }
}
