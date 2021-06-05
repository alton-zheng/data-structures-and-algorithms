package java01057;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 6/5/21 5:59 PM
 * @Description:
 * 1507. Reformat Date #78
 *
 * Given a date string in the form Day Month Year, where:
 *
 * Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 * Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
 * Year is in the range [1900, 2100].
 * Convert the date string to the format YYYY-MM-DD, where:
 *
 * YYYY denotes the 4 digit year.
 * MM denotes the 2 digit month.
 * DD denotes the 2 digit day.
 *
 *
 * Example 1:
 *
 * Input: date = "20th Oct 2052"
 * Output: "2052-10-20"
 * Example 2:
 *
 * Input: date = "6th Jun 1933"
 * Output: "1933-06-06"
 * Example 3:
 *
 * Input: date = "26th May 1960"
 * Output: "1960-05-26"
 *
 *
 * Constraints:
 *
 * The given dates are guaranteed to be valid, so no error handling is necessary.
 *
 * Time Complexity: O(1)
 * Space Complexity； O(1)
 * array split
 *
 * Runtime: 10 ms, faster than 16.41% of Java online submissions for Reformat Date.
 * Memory Usage: 37.3 MB, less than 75.63% of Java online submissions for Reformat Date.
 *
 */
class Solution3 {
    public String reformatDate(String date) {

        String[] mon = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer>  monthPair = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            monthPair.put(mon[i - 1], i);
        }

        int len = date.length();

        String[] help = date.split(" ");
        int day = Integer.valueOf(help[0].substring(0, help[0].length() - 2));
        int month = Integer.valueOf(monthPair.get(help[1]));
        int year = Integer.valueOf(help[2]);

        return String.format("%d-%02d-%02d", year, month, day);

    }

    public static void main(String[] args) {
        System.out.println(new Solution3().reformatDate("20th Oct 2052"));
    }
}
