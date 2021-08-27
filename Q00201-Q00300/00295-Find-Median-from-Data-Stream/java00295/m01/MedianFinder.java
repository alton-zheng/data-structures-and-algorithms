package java00295.m01;

import java.util.PriorityQueue;

/**
 * @Author: alton
 * @Date: Created in 2021/8/27 8:29 上午
 * @Description:
 *
 * 295. Find Median from Data Stream
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 *
 *
 * Constraints:
 *
 * -105 <= num <= 105
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 104 calls will be made to addNum and findMedian.
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 * If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 *
 * Time Complexity: O()
 * Space Complexity: O()
 *
 * Runtime: 194 ms, faster than 10.24% of Java online submissions for Find Median from Data Stream.
 * Memory Usage: 123.6 MB, less than 5.01% of Java online submissions for Find Median from Data Stream.
 *
 */
class MedianFinder {

    private PriorityQueue<Integer> minQ;
    private PriorityQueue<Integer> maxQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        minQ = new PriorityQueue<>((a, b) -> a - b);
        maxQ = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minQ.isEmpty() || num <= minQ.peek()) {
            minQ.add(num);
            if (maxQ.size() + 1 < minQ.size()) {
                maxQ.add(minQ.poll());
            }
        } else {
            maxQ.add(num);
            if (minQ.size() < maxQ.size()) {
                minQ.add(maxQ.poll());
            }
        }
    }

    public double findMedian() {
        if (maxQ.size() < minQ.size()) {
            return (double) minQ.peek();
        } else {
            return (minQ.peek() + maxQ.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
