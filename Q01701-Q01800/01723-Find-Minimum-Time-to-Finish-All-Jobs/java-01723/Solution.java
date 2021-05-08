/**
 * 1723. Find Minimum Time to Finish All Jobs
 * You are given an integer array jobs, where jobs[i] is the amount of time it takes to complete the ith job.
 *
 * There are k workers that you can assign jobs to. Each job should be assigned to exactly one worker. The working time of a worker is the sum of the time it takes to complete all jobs assigned to them. Your goal is to devise an optimal assignment such that the maximum working time of any worker is minimized.
 *
 * Return the minimum possible maximum working time of any assignment.
 *
 *
 *
 * Example 1:
 *
 * Input: jobs = [3,2,3], k = 3
 * Output: 3
 * Explanation: By assigning each person one job, the maximum time is 3.
 * Example 2:
 *
 * Input: jobs = [1,2,4,7,8], k = 2
 * Output: 11
 * Explanation: Assign the jobs the following way:
 * Worker 1: 1, 2, 8 (working time = 1 + 2 + 8 = 11)
 * Worker 2: 4, 7 (working time = 4 + 7 = 11)
 * The maximum working time is 11.
 *
 *
 * Constraints:
 *
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 *
 * Time  Complexity: O(nlogn+log(S−M)×n!)
 * 其中 n 是数组 jobs 的长度，
 * S 是数组 jobs 的元素之和，
 * M 是数组 jobs 中元素的最大值。
 * 最坏情况下每次二分需要遍历所有分配方案的排列，但经过一系列优化后，实际上可以规避掉绝大部分不必要的计算。
 * Space Complexity: O(n) 空间复杂度主要取决于递归的栈空间的消耗，而递归至多有 nn 层。
 */
class Solution {
    class Solution {
        public int minimumTimeRequired(int[] jobs, int k) {
            Arrays.sort(jobs);
            int low = 0, high = jobs.length - 1;
            while (low < high) {
                int temp = jobs[low];
                jobs[low] = jobs[high];
                jobs[high] = temp;
                low++;
                high--;
            }
            int l = jobs[0], r = Arrays.stream(jobs).sum();
            while (l < r) {
                int mid = (l + r) >> 1;
                if (check(jobs, k, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public boolean check(int[] jobs, int k, int limit) {
            int[] workloads = new int[k];
            return backtrack(jobs, workloads, 0, limit);
        }

        public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
            if (i >= jobs.length) {
                return true;
            }
            int cur = jobs[i];
            for (int j = 0; j < workloads.length; ++j) {
                if (workloads[j] + cur <= limit) {
                    workloads[j] += cur;
                    if (backtrack(jobs, workloads, i + 1, limit)) {
                        return true;
                    }
                    workloads[j] -= cur;
                }
                // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
                // 或者当前工作恰能使该工人的工作量达到了上限
                // 这两种情况下我们无需尝试继续分配工作
                if (workloads[j] == 0 || workloads[j] + cur == limit) {
                    break;
                }
            }
            return false;
        }
    }
}