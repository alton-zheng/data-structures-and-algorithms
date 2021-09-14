package java00524.m02;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 2021/9/14 10:38 上午
 * @Description:
 */
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(
                dictionary,
                (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b)
        );

        for (String t: dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }

            if (i == t.length()) {
                return t;
            }
        }
        return "";
    }
}
