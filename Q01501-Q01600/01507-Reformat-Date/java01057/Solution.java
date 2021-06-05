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
 * string concat
 *
 * Runtime: 6 ms, faster than 51.99% of Java online submissions for Reformat Date.
 * Memory Usage: 39.2 MB, less than 7.84% of Java online submissions for Reformat Date.
 *
 */
class Solution {

    private static final Map<String, String> months = getMonthsDate();

    public String reformatDate(String date) {

        String[] help = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(help[2]).append("-");
        sb.append(months.get(help[1])).append("-");
        sb.append(help[0].length() == 4 ? help[0].substring(0, 2) : "0" + help[0].charAt(0));

        return sb.toString();
    }

    private static Map<String, String> getMonthsDate(){
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }
}
