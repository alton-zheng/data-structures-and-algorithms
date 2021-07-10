package java00981.m01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 7/10/21 8:51 AM
 * @Description:
 * 981. Time Based Key-Value Store #191
 *
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 *
 * Implement the TimeMap class:
 *
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 *
 *
 * Example 1:
 *
 * Input
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * Output
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 *
 * Explanation
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
 * timeMap.get("foo", 1);         // return "bar"
 * timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
 * timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
 * timeMap.get("foo", 4);         // return "bar2"
 * timeMap.get("foo", 5);         // return "bar2"
 *
 *
 * Constraints:
 *
 * 1 <= key.length, value.length <= 100
 * key and value consist of lowercase English letters and digits.
 * 1 <= timestamp <= 107
 * All the timestamps timestamp of set are strictly increasing.
 * At most 2 * 105 calls will be made to set and get.
 *
 * Time Complexity : O()
 * Space Complexity : O()
 *
 * Runtime: 107 ms, faster than 98.29% of Java online submissions for Time Based Key-Value Store.
 * Memory Usage: 114.2 MB, less than 65.96% of Java online submissions for Time Based Key-Value Store.
 */
class TimeMap {

    private final Map<String, List<KeyValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<KeyValue> keyValues = map.getOrDefault(key, new ArrayList<>());
        keyValues.add(new KeyValue(timestamp, value));
        map.put(key, keyValues);
    }

    public String get(String key, int timestamp) {

        List<KeyValue> keyValues = map.getOrDefault(key, new ArrayList<>());
        KeyValue keyValue = new KeyValue(timestamp, String.valueOf((char) 127));

        int i = binarySearch(keyValues, keyValue);

        if (i > 0) {
            return keyValues.get(i - 1).value;
        }

        return "";
    }

    private int binarySearch(List<KeyValue> keyValues, KeyValue target) {

        if (keyValues.size() == 0) {
            return 0;
        }
        int left = 0, right = keyValues.size() - 1;

        // 最大 version 的 kv 对小于等于 target 值，返回 kv 对的大小
        // target 值比等于或大于写入的当前 Key 的最大版本
        if (keyValues.get(right).compareTo(target) <= 0) {
            return right + 1;
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            KeyValue keyValue = keyValues.get(mid);
            if (keyValue.compareTo(target) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    final class KeyValue implements Comparable<KeyValue> {

        int version;
        String value;

        public KeyValue(int version, String value) {
            this.version = version;
            this.value = value;
        }


        @Override
        public int hashCode() {
            return version % Integer.MAX_VALUE + value.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof KeyValue) {
                KeyValue kv = (KeyValue) obj;
                return this.version == kv.version && this.value.equals(kv.value);
            }
            return false;
        }

        @Override
        public int compareTo(KeyValue kv) {
            if (this.version != kv.version) {
                return this.version - kv.version;
            } else {
                return this.value.compareTo(kv.value);
            }
        }
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
