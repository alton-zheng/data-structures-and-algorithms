package java01185;

/**
 * @Author: alton
 * @Date: Created in 5/31/21 5:37 PM
 * @Description:
 *
 * 1185. Day of the Week #62
 * Given a date, return the corresponding day of the week for that date.
 *
 * The input is given as three integers representing the day, month and year respectively.
 *
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 *
 *
 *
 * Example 1:
 *
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * Example 2:
 *
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * Example 3:
 *
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 *
 *
 * Constraints:
 *
 * The given dates are valid dates between the years 1971 and 2100.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * The formula solution
 */
class Solution {
    String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public String dayOfTheWeek(int d, int m, int y) {
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int c = y / 100;
        y = y % 100;
        int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
        return days[(w + 7) % 7];
    }
}
