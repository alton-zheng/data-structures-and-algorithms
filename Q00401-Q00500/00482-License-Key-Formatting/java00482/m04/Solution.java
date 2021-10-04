package java00482.m04;

class Solution {
    public String licenseKeyFormatting(String s, int k) {

        StringBuilder res = new StringBuilder();

        int len = s.length();

        int r = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (s.charAt(i) != '-') {
                res.append((char) (c >= 'a' ? c - 32 : c));
                r++;
            }

            if (res.length() != 0 && r == k) {
                res.append('-');
                r = 0;
            }
        }

        String ans = res.reverse().toString();
        return ans.charAt(0) == '-' ? ans.substring(1) : ans;
    }
}
