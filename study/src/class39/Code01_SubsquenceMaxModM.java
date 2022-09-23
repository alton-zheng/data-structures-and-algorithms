package class39;

import java.util.HashSet;
import java.util.TreeSet;

// 给定一个非负数组arr，和一个正数m。 返回arr的所有子序列中累加和%m之后的最大值。
public class Code01_SubsquenceMaxModM {

	public static int max1(int[] arr, int m) {
		HashSet<Integer> set = new HashSet<>();
		process(arr, 0, 0, set);
		int max = 0;
		for (Integer sum : set) {
			max = Math.max(max, sum % m);
		}
		return max;
	}

	public static void process(int[] arr, int index, int sum, HashSet<Integer> set) {
		if (index == arr.length) {
			set.add(sum);
		} else {
			process(arr, index + 1, sum, set);
			process(arr, index + 1, sum + arr[index], set);
		}
	}


	/**
	 * 下面解法，适用于所有数组的元素和不大的场景
	 * 太大，容易超过 10^8 的操作数
	 * @param arr
	 * @param m
	 * @return
	 */
	public static int max2(int[] arr, int m) {
		int sum = 0;
		int N = arr.length;

		// 求出所有总和
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}

		// 定义 dp
		// dp[i][j] 含义: 1 -> i 位置自由选择相加（一个位置只能选择），能否得到等于 j 的和
		boolean[][] dp = new boolean[N][sum + 1];
		for (int i = 0; i < N; i++) {

			// 和为 0， 只要所有位置都不选择，都能成立，因此 dp[i][0] 都为 true
			dp[i][0] = true;
		}

		// 数组的首位置，得到 j = arr[0] 的和，是一定的。也将它置为 true
		dp[0][arr[0]] = true;

		// 开始正式的动态规划逻辑
		// i [1, N - 1]
		for (int i = 1; i < N; i++) {
			// j [1, sum]
			for (int j = 1; j <= sum; j++) {

				// dp[i][j] 默认等于 dp[i - 1][j]
				// 因为 dp[i - 1][j] 能满足 j 和， dp[i][j] 一定可以满足 j 和（不选择 i 位置的元素即可
				// 先根据 dp[i - 1][j] 的值走
				dp[i][j] = dp[i - 1][j];

				// 当要求 j 和大于当前位元素值时
				if (j - arr[i] >= 0) {
					// 这时候也可以选择将当前位置元素加起来
					// 也就是只要 i - 1 位置，能满足 j - arr[i] 和，那么 dp[i][j] 就能满足
					dp[i][j] |= dp[i - 1][j - arr[i]];
				}
			}
		}

		// 定义结果值变量 ans
		int ans = 0;

		// 从最后一行（最后一位）找到最大的 %m
		for (int j = 0; j <= sum; j++) {
			if (dp[N - 1][j]) {

				// 找出最大的 ans 值
				ans = Math.max(ans, j % m);
			}
		}

		// 返回结果值 ans
		return ans;

	}


	/**
	 * 这种解法适合 m 小的场景
	 * @param arr
	 * @param m
	 * @return
	 */
	public static int max3(int[] arr, int m) {

		// 数组长度 N
		int N = arr.length;
		// 0...m-1

		// 定义 dp
		// 含义： dp[i][j] 自由选择数组元素相加，%m 后是否能得到 j 值
		boolean[][] dp = new boolean[N][m];
		for (int i = 0; i < N; i++) {

			// 到 i 位置， %m 后得到 0 的可能性都为 true (只需要所有元素都不选择即可)
			dp[i][0] = true;
		}

		// 第一个元素位置， 得到 arr[0] % m  -> true
		dp[0][arr[0] % m] = true;

		// 开始动态规划逻辑处理
		// i [1, N - 1]
		for (int i = 1; i < N; i++) {
			// j [1, m - 1] %数的范围
			for (int j = 1; j < m; j++) {
				// dp[i][j] T or F
				// 默认为 dp[i - 1][j]
				dp[i][j] = dp[i - 1][j];

				// 当前位置的模数等于 arr[i] % m
				int cur = arr[i] % m;

				// 如果 cur <= j 意味着，可以根据  dp[i - 1][j - cur] 能否得到模数 j - cur 来推导
				if (cur <= j) {

					// 或操作，只要有个能得到模数就可以了
					dp[i][j] |= dp[i - 1][j - cur];
				} else {

					// 如果 cur >  j 意味着什么呢？意味着在模数范围 [0, m - 1] 范围， cur 在 j 的后边
					// 得到当前位置能得到的模数， 只需要加上 m 即可
					dp[i][j] |= dp[i - 1][m + j - cur];
				}
			}
		}

		// 定义结果变量 ans
		int ans = 0;

		// 从最后一行，也就是最后一位，找到最大的模数 ans
		for (int i = 0; i < m; i++) {
			if (dp[N - 1][i]) {
				ans = i;
			}
		}

		// 返回即可
		return ans;
	}

	// 如果arr的累加和很大，m也很大
	// 但是arr的长度相对不大
	public static int max4(int[] arr, int m) {

		// 边界条件，当数组长度只有 1 时，直接取模数
		if (arr.length == 1) {
			return arr[0] % m;
		}

		// 取出 mid 位置
		int mid = (arr.length - 1) / 2;

		// 这时候的解决方法也很粗暴，直接分 2 次递归（以中间位置为分割线）
		TreeSet<Integer> sortSet1 = new TreeSet<>();
		process4(arr, 0, 0, mid, m, sortSet1);
		TreeSet<Integer> sortSet2 = new TreeSet<>();
		process4(arr, mid + 1, 0, arr.length - 1, m, sortSet2);

		//  定义结果值 ans
		int ans = 0;

		// 取出最大的模数
		// 前段和后端
		for (Integer leftMod : sortSet1) {
			// treeset 的 floor 方法返回值等于或小于参数值的最大正数
			// leftMod 数加上与之对应的右边最大的模数（m - 1 - leftMod）
			ans = Math.max(ans, leftMod + sortSet2.floor(m - 1 - leftMod));
		}

		// 然后返回即可
		return ans;
	}

	// 从index出发，最后有边界是end+1，arr[index...end]
	public static void process4(int[] arr, int index, int sum, int end, int m, TreeSet<Integer> sortSet) {
		if (index == end + 1) {
			sortSet.add(sum % m);
		} else {
			process4(arr, index + 1, sum, end, m, sortSet);
			process4(arr, index + 1, sum + arr[index], end, m, sortSet);
		}
	}

	public static int[] generateRandomArray(int len, int value) {
		int[] ans = new int[(int) (Math.random() * len) + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = (int) (Math.random() * value);
		}
		return ans;
	}

	public static void main(String[] args) {
		int len = 10;
		int value = 100;
		int m = 76;
		int testTime = 500000;
		System.out.println("test begin");
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(len, value);
			int ans1 = max1(arr, m);
			int ans2 = max2(arr, m);
			int ans3 = max3(arr, m);
			int ans4 = max4(arr, m);
			if (ans1 != ans2 || ans2 != ans3 || ans3 != ans4) {
				System.out.println("Oops!");
			}
		}
		System.out.println("test finish!");

	}

}
