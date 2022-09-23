package class38;

public class Code03_MSumToN {

	public static boolean isMSum1(int num) {
		for (int start = 1; start <= num; start++) {
			int sum = start;
			for (int j = start + 1; j <= num; j++) {
				if (sum + j > num) {
					break;
				}
				if (sum + j == num) {
					return true;
				}
				sum += j;
			}
		}
		return false;
	}

	public static boolean isMSum2(int num) {
//
		// 说明二进制只有一个 1， ~num + 1 能取出最右边的 1， 与 num & 操作就剩下一个 1
//		return num == (num & (~num + 1));
//
//		return num == (num & (-num));
//
//		// 二进制形式，2 的幂，只有一个 1， 怎么判断只有一个 1 呢？
		// n & (n - 1) = 0 , 就说明它是 2 的幂二进制
		return num & (num - 1) != 0;
	}

	public static void main(String[] args) {

		for (int num = 1; num < 200; num++) {
			System.out.println(num + " : " + isMSum1(num));
		}

		System.out.println("test begin");

		for (int num = 1; num < 5000; num++) {
			if (isMSum1(num) != isMSum2(num)) {
				System.out.println("Oops!");
			}
		}

		System.out.println("test end");

	}
}
