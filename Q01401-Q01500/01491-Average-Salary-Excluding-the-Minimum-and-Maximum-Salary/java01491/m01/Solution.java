package java01491.m01;

/**
 * @Author: alton
 * @Date: Created in 6/12/21 4:57 PM
 * @Description:
 *
 * 1491. Average Salary Excluding the Minimum and Maximum Salary #10
 *
 * Given an array of unique integers salary where salary[i] is the salary of the employee i.
 *
 * Return the average salary of employees excluding the minimum and maximum salary.
 *
 *
 *
 * Example 1:
 *
 * Input: salary = [4000,3000,1000,2000]
 * Output: 2500.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
 * Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
 * Example 2:
 *
 * Input: salary = [1000,2000,3000]
 * Output: 2000.00000
 * Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
 * Average salary excluding minimum and maximum salary is (2000)/1= 2000
 * Example 3:
 *
 * Input: salary = [6000,5000,4000,3000,2000,1000]
 * Output: 3500.00000
 * Example 4:
 *
 * Input: salary = [8000,9000,2000,3000,6000,1000]
 * Output: 4750.00000
 *
 *
 * Constraints:
 *
 * 3 <= salary.length <= 100
 * 10^3 <= salary[i] <= 10^6
 * salary[i] is unique.
 * Answers within 10^-5 of the actual value will be accepted as correct.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
 * Memory Usage: 36.7 MB, less than 48.92% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
 *
 */
class Solution {
    public double average(int[] salary) {

        double count = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < salary.length; i++) {
            count += salary[i];
            if (min > salary[i]) {
                min = salary[i];
            }

            if (max < salary[i]) {
                max = salary[i];
            }

        }

        return (count - min - max) / (salary.length - 2);
    }
}
