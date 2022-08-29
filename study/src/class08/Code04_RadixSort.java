package class08;

import java.util.Arrays;

public class Solution {

	// only for no-negative value
	public static void radixSort(int[] arr) {

		// 数组为空，或只有 1 长度，直接返回
		if (arr == null || arr.length < 2) {
			return;
		}

		// maxbits 最大位数
		radixSort(arr, 0, arr.length - 1, maxbits(arr));
	}

	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;

		// 求 arr 最大值
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		// 求位数
		int res = 0;
		while (max != 0) {
			res++;
			max /= 10;
		}
		return res;
	}

	// arr[L..R]排序  ,  最大值的十进制位数digit

	/**
	 * 基数排序
	 * @param arr 数组
	 * @param left from
	 * @param right to
	 * @param digit  位数
	 */
	public static void radixSort(int[] arr, int left, int right, int digit) {

		// 十进制
		final int radix = 10;
		int i = 0, j = 0;
		// 有多少个数准备多少个辅助空间
		int[] help = new int[right - left + 1];

		// 循环 digit 次数
		// 有多少位就进出几次
		for (int d = 1; d <= digit; d++) {
			// 10个空间
		    // count[0] 当前位(d位)是0的数字有多少个
			// count[1] 当前位(d位)是(0和1)的数字有多少个
			// count[2] 当前位(d位)是(0、1和2)的数字有多少个
			// count[i] 当前位(d位)是(0~i)的数字有多少个
			int[] count = new int[radix];

			// 循环 right - left + 1次
			// 统计当前位上出现的次数
			for (i = left; i <= right; i++) {
				// 103  1   3
				// 209  1   9
				j = getDigit(arr[i], d);
				count[j]++;
			}

			// 优化成前缀和
			// 含义： 当前位小于等于 i 的数有几个
			for (i = 1; i < radix; i++) {
				count[i] = count[i] + count[i - 1];
			}

			// 从 right -> left 倒序处理
			for (i = right; i >= left; i--) {

				// 查询当前位上的数字 j
				j = getDigit(arr[i], d);

				// 假设arr[i] = 15,  j 为 5, count[j] 出现了 3 次
				// help[3 - 1] = 15
				// 将当前 arr[i] 放入 help[count[j] - 1]
				help[count[j] - 1] = arr[i];

				// 个数减去 1
				count[j]--;
			}
			// help 放入到 arr [left, right] 位
			for (i = left, j = 0; i <= right; i++, j++) {
				arr[i] = help[j];
			}
		}
	}

	public static int getDigit(int x, int d) {
		return ((x / ((int) Math.pow(10, d - 1))) % 10);
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100000;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			radixSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		radixSort(arr);
		printArray(arr);

	}

}
