package java01487;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: alton
 * @Date: Created in 5/17/21 1:59 PM
 * @Description: 1487. Making File Names Unique
 * Given an array of strings names of size n. You will create n folders in your file system such that, at the ith minute, you will create a folder with the name names[i].
 * <p>
 * Since two files cannot have the same name, if you enter a folder name which is previously used, the system will have a suffix addition to its name in the form of (k), where, k is the smallest positive integer such that the obtained name remains unique.
 * <p>
 * Return an array of strings of length n where ans[i] is the actual name the system will assign to the ith folder when you create it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: names = ["pes","fifa","gta","pes(2019)"]
 * Output: ["pes","fifa","gta","pes(2019)"]
 * Explanation: Let's see how the file system creates folder names:
 * "pes" --> not assigned before, remains "pes"
 * "fifa" --> not assigned before, remains "fifa"
 * "gta" --> not assigned before, remains "gta"
 * "pes(2019)" --> not assigned before, remains "pes(2019)"
 * Example 2:
 * <p>
 * Input: names = ["gta","gta(1)","gta","avalon"]
 * Output: ["gta","gta(1)","gta(2)","avalon"]
 * Explanation: Let's see how the file system creates folder names:
 * "gta" --> not assigned before, remains "gta"
 * "gta(1)" --> not assigned before, remains "gta(1)"
 * "gta" --> the name is reserved, system adds (k), since "gta(1)" is also reserved, systems put k = 2. it becomes "gta(2)"
 * "avalon" --> not assigned before, remains "avalon"
 * Example 3:
 * <p>
 * Input: names = ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
 * Output: ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]
 * Explanation: When the last folder is created, the smallest positive valid k is 4, and it becomes "onepiece(4)".
 * Example 4:
 * <p>
 * Input: names = ["wano","wano","wano","wano"]
 * Output: ["wano","wano(1)","wano(2)","wano(3)"]
 * Explanation: Just increase the value of k each time you create folder "wano".
 * Example 5:
 * <p>
 * Input: names = ["kaido","kaido(1)","kaido","kaido(1)"]
 * Output: ["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
 * Explanation: Please note that system adds the suffix (k) to current name even it contained the same suffix before.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= names.length <= 5 * 10^4
 * 1 <= names[i].length <= 20
 * names[i] consists of lower case English letters, digits and/or round brackets.
 * <p>
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 */
class Solution {
    public String[] getFolderNames(String[] names) {

        if (names == null) {
            return null;
        }

        int nLen = names.length;

        Map<String, Integer> sNumber = new HashMap<>();

        for (int i = 0; i < nLen; i++) {
            final String s = names[i];
            if (sNumber.containsKey(s)) {
                while (sNumber.containsKey(names[i] = s + "(" + sNumber.getOrDefault(s, 1) + ")")) {
                    sNumber.put(s, sNumber.getOrDefault(s, 1) + 1);
                }
            }

            sNumber.put(names[i], sNumber.getOrDefault(names[i], 1));
        }

        return names;
    }

    public static void main(String[] args) {

        String[] input = new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        String[] res = new Solution().getFolderNames(input);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}





