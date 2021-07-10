package java00981.m02;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;
import java00278.m01.Solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: alton
 * @Date: Created in 7/10/21 8:51 AM
 * @Description: 981. Time Based Key-Value Store #191
 * <p>
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 * <p>
 * Implement the TimeMap class:
 * <p>
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * Output
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 * <p>
 * Explanation
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
 * timeMap.get("foo", 1);         // return "bar"
 * timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
 * timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
 * timeMap.get("foo", 4);         // return "bar2"
 * timeMap.get("foo", 5);         // return "bar2"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= key.length, value.length <= 100
 * key and value consist of lowercase English letters and digits.
 * 1 <= timestamp <= 107
 * All the timestamps timestamp of set are strictly increasing.
 * At most 2 * 105 calls will be made to set and get.
 * <p>
 * Time Complexity : O()
 * Space Complexity : O()
 */
class TimeMap {

    /**
     * Initialize your data structure here.
     */
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        map.computeIfAbsent(key, (k) -> {
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(0, "");
            return treeMap;
        }).put(timestamp, value);
    }

    public String get(String key, int timestamp) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(0, "");

        TreeMap<Integer, String> tm = map.getOrDefault(key, treeMap);

        Integer k = bs(tm, timestamp);

        return tm.get(k);

    }

    private int bs(TreeMap<Integer, String> treeMap, int timestamp) {


        if (timestamp >= treeMap.lastKey()) {
            return treeMap.lastKey();
        }

        if (timestamp <= treeMap.firstKey()) {
            return treeMap.firstKey();
        }

        Object[] arr = treeMap.keySet().toArray();

        int left = 0, right = arr.length - 1;

        while (left < right) {

            int mid = (right - left) / 2 + left;

            if (timestamp >= (int)arr[mid]) {
                if (timestamp < (int)arr[mid + 1]) {
                    return (int) arr[mid];
                }
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return treeMap.firstKey();
    }
}