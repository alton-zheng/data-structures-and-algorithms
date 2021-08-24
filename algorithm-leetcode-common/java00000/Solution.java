package java00000;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> help;
    int len = 0;
    String res = "";
    public String findDifferentBinaryString(String[] nums) {

        help = new HashMap<>();

        len = nums.length;
        for (int i = 0; i < len; i++) {
            help.put(nums[i], 0);
        }

        dfs(0, "");
        return res;
    }

    private void dfs(int start, String value)  {

        if (start == len) {
            if (!help.containsKey(value)) {
                res = value;
            }

            return;

        }

        if ("".equals(res) && start < len) {
            dfs (start + 1, value + "0");
        }


        if ("".equals(res) && start < len) {
            dfs(start + 1, value + "1");
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDifferentBinaryString(new String[]{"00", "01"}));
    }
}