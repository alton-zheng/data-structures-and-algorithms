package java00726.m01;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 7/5/21 2:05 PM
 * @Description:
 * 726. Number of Atoms #176
 *
 * Given a chemical formula (given as a string), return the count of each atom.
 *
 * The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 *
 * One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
 *
 * Two formulas concatenated together to produce another formula. For example, H2O2He3Mg4 is also a formula.
 *
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
 *
 * Given a formula, return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 *
 *
 * Example 1:
 *
 * Input: formula = "H2O"
 * Output: "H2O"
 * Explanation: The count of elements are {'H': 2, 'O': 1}.
 * Example 2:
 *
 * Input: formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * Example 3:
 *
 * Input: formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * Example 4:
 *
 * Input: formula = "Be32"
 * Output: "Be32"
 *
 *
 * Constraints:
 *
 * 1 <= formula.length <= 1000
 * formula consists of English letters, digits, '(', and ')'.
 * formula is always valid.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(H)
 *
 * Runtime: 3 ms, faster than 90.77% of Java online submissions for Number of Atoms.
 * Memory Usage: 37.8 MB, less than 37.07% of Java online submissions for Number of Atoms.
 *
 */
class Solution {

    int curIdx, len;
    String formula;

    public String countOfAtoms(String formula) {
        this.curIdx = 0;
        this.len = formula.length();
        this.formula = formula;

        Deque<Map<String, Integer>> stack = new LinkedList<>();

        stack.push(new HashMap<>());

        // 每一组括号一个 stack 元素， 用来存储括号内的 Atom 个数
        while (curIdx < len) {

            char ch = formula.charAt(curIdx);

            if (ch == '(') {

                curIdx++;
                stack.push(new HashMap<>());

            } else if (ch == ')') {

                curIdx++;

                // 解析括号右侧的数字，用来累乘
                int num = parseNum();

                // 弹出括号内的 Altom 数目
                Map<String, Integer> popMap = stack.pop();

                // 获取当前括号前的括号或 Altom 数目
                Map<String, Integer> topMap = stack.peek();

                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int altomNum = entry.getValue();

                    // 将上一层括号内或最外层的原子数量乘上 num
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + altomNum * num);

                }
            } else {

                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();

                // 统计当前原子数目
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num);

            }
        }

        Map<String, Integer> map = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);

        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            res.append(atom);
            if (count > 1) {
                res.append(count);
            }
        }
        return res.toString();
    }

    private String parseAtom() {
        StringBuilder atom = new StringBuilder();

        // 扫描首字母
        atom.append(formula.charAt(curIdx++));

        while (curIdx < len && Character.isLowerCase(formula.charAt(curIdx))) {
            // 扫描小写字母
            atom.append(formula.charAt(curIdx++));
        }
        // 将整个 atom 返回
        return atom.toString();
    }

    private int parseNum() {

        // 少于 2 的 Atom 在化学表达式中是不显性展示的
        if (curIdx == len || !Character.isDigit(formula.charAt(curIdx))) {
            return 1;
        }

        int num = 0;

        while (curIdx < len && Character.isDigit(formula.charAt(curIdx))) {
            // 扫描数字，将所有连一起的数字组合成数值
            num = num * 10 + formula.charAt(curIdx++) - '0';
        }
        return num;
    }
}