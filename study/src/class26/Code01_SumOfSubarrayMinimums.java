package class26;

// 测试链接：https://leetcode.com/problems/sum-of-subarray-minimums/
// subArrayMinSum1是暴力解
// subArrayMinSum2是最优解的思路
// sumSubarrayMins是最优解思路下的单调栈优化
// Leetcode上不要提交subArrayMinSum1、subArrayMinSum2方法，因为没有考虑取摸
// Leetcode上只提交sumSubarrayMins方法，时间复杂度O(N)，可以直接通过
public class Code01_SumOfSubarrayMinimums {

	/**
	 * 暴力解
	 * 所有 [i, j] 区域最小值之和
	 * @param arr
	 * @return
	 */
	public static int subArrayMinSum1(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int min = arr[i];
				for (int k = i + 1; k <= j; k++) {
					min = Math.min(min, arr[k]);
				}
				ans += min;
			}
		}
		return ans;
	}

	// 没有用单调栈

	/**
	 *
	 * @param arr
	 * @return
	 */
	public static int subArrayMinSum2(int[] arr) {
		// left[i] = x : arr[i]左边，离arr[i]最近，<=arr[i]，位置在x
		int[] left = leftNearLessEqual2(arr);
		// right[i] = y : arr[i]右边，离arr[i]最近，< arr[i],的数，位置在y
		int[] right = rightNearLess2(arr);

		// 定义 ans 变量
		int ans = 0;

		// 遍历 arr
		for (int i = 0; i < arr.length; i++) {
			// start -> i - left[i] 也就是left, start 个数符合条件
			int start = i - left[i];

			// 右边符合条件的 end 数
			int end = right[i] - i;
			ans += start * end * arr[i];
		}
		return ans;
	}

	/**
	 * arr 中每一个位置 i，求左边 <= arr[i] 的位置
	 * 没有，取 -1
	 * @param arr
	 * @return
	 */
	public static int[] leftNearLessEqual2(int[] arr) {
		int N = arr.length;
		int[] left = new int[N];
		for (int i = 0; i < N; i++) {
			int ans = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] <= arr[i]) {
					ans = j;
					break;
				}
			}
			left[i] = ans;
		}
		return left;
	}

	/**
	 * 	 arr 中每一个位置 i，求右边 < arr[i] 的位置
	 * 	 没有，取 -1
	 * @param arr
	 * @return
	 */
	public static int[] rightNearLess2(int[] arr) {
		int N = arr.length;
		int[] right = new int[N];
		for (int i = 0; i < N; i++) {
			int ans = N;
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j]) {
					ans = j;
					break;
				}
			}
			right[i] = ans;
		}
		return right;
	}

	/**
	 * 与上面方法思路是一致的
	 * 求 left, right 的方法改成了单调栈
	 * @param arr
	 * @return
	 */
	public static int sumSubarrayMins(int[] arr) {
		int[] stack = new int[arr.length];

		// 单调栈取所有 left 符合条件的位置
		int[] left = nearLessEqualLeft(arr, stack);

		// 单调栈取所有 right, 符合条件的位置
		int[] right = nearLessRight(arr, stack);

		// 下面的代码是一样，结果 % 1000000007
		long ans = 0;
		// 总而言之：
		// 针对数组的每一个位置 i
		// 左边取 （left[i], i] 数
		// 右边取 [i, right[i]) 数
		// 相乘再乘以 arr[i]
		for (int i = 0; i < arr.length; i++) {
			long start = i - left[i];
			long end = right[i] - i;
			ans += start * end * (long) arr[i];
			ans %= 1000000007;
		}

		// 返回结果值
		return (int) ans;
	}

	/**
	 * 单调栈，取数组中所有位置 cur,  左边符合 <= arr[cur] 的位置
	 * 上面相同方法的单调栈版本
	 * @param arr
	 * @param stack
	 * @return
	 */
	public static int[] nearLessEqualLeft(int[] arr, int[] stack) {

		// 数组长度
		int len = arr.length;
		//  定义结果数组 left
		int[] left = new int[len];

		// 定义 stack 中数组的 size
		// 开始为 0 位置
		int size = 0;

		// 从 arr [len - 1, 0] 开始遍历
		for (int i = len - 1; i >= 0; i--) {

			// 首次不会进入这里
			// 第二次开始判断条件是否满足条件
			while (size != 0 && arr[i] <= arr[stack[size - 1]]) {

				// 栈不为空时， arr 栈顶索引位置大于 arr[i]
				// 也就是左边 i 位置小于等于 arr[stack[size - 1]]
				// 那么将 left  arr[stack[size - 1]] 位置更新为 i
				left[stack[--size]] = i;
			}

			// 首次压栈，将 len - 1 压入栈
			stack[size++] = i;
		}

		// 栈不为空时，处理剩余部分
		while (size != 0) {
			// 对于目前仍在栈中的 left 位置， 全部更新为  -1
			left[stack[--size]] = -1;
		}

		// 返回 left
		return left;
	}


	/**
	 * 单调栈，取数组中所有位置,  右边符合 < arr[cur] 的位置
	 * 上面相同方法的单调栈版本

	 * @param arr
	 * @param stack
	 * @return
	 */
	public static int[] nearLessRight(int[] arr, int[] stack) {
		int len = arr.length;

		// 定义结果 right
		int[] right = new int[len];

		// 初始化单调栈大小为 0
		int size = 0;

		// 从 [0, len - 1] 遍历数组
		for (int i = 0; i < len; i++) {

			// 当前位置大于 i 时, 也就是右边比当前小时， 更新当前位置 right[cur] 为 i
			while (size != 0 && arr[stack[size - 1]] > arr[i]) {
				right[stack[--size]] = i;
			}

			// 首次压栈， i 为 0
			stack[size++] = i;
		}

		// 处理剩余stack , 取右极值 len
		while (size != 0) {
			right[stack[--size]] = len;
		}

		// 返回 right
		return right;
	}

	public static int[] randomArray(int len, int maxValue) {
		int[] ans = new int[len];
		for (int i = 0; i < len; i++) {
			ans[i] = (int) (Math.random() * maxValue) + 1;
		}
		return ans;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int maxLen = 100;
		int maxValue = 50;
		int testTime = 100000;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int len = (int) (Math.random() * maxLen);
			int[] arr = randomArray(len, maxValue);
			int ans1 = subArrayMinSum1(arr);
			int ans2 = subArrayMinSum2(arr);
			int ans3 = sumSubarrayMins(arr);
			if (ans1 != ans2 || ans1 != ans3) {
				printArray(arr);
				System.out.println(ans1);
				System.out.println(ans2);
				System.out.println(ans3);
				System.out.println("出错了！");
				break;
			}
		}
		System.out.println("测试结束");
	}

}
