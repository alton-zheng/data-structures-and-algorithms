package java00412;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 5/22/21 8:09 AM
 * @Description:
 * 412. Fizz Buzz #30
 * <p>
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i if non of the above conditions are true.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 * <p>
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 104
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }

        return res;
    }
}
