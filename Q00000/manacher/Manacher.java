public class Manacher {

	public static int manacher(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// "12132" -> "#1#2#1#3#2#"
		// 编程处理串
		char[] str = manacherString(s);

		// 存储回文半径的大小
		int[] pArr = new int[str.length];

		// 中心点位置
		int c = -1;

		// 讲述中：R代表最右的扩成功的位置
		// 但 coding：最右的扩成功位置的，再下一个位置
		int r = -1;

		// 初始化最大值 max -> Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;

		// 遍历 str
		for (int i = 0; i < str.length; i++) { // 0 1 2
			// R第一个违规的位置，i>= r
			// i位置扩出来的答案，i位置扩的区域，至少是多大。
			// Math.min(pArr[2 * c - i], r - i) 代表不用验证的半径区域
			// pArr[2 * c - i] 代表 i^1
			pArr[i] = r > i ? Math.min(pArr[2 * c - i], r - i) : 1;

			// 满足边界条件的情况下， 处理
			while (i + pArr[i] < str.length && i - pArr[i] > -1) {

				// 更新回文范围，满足一次，半径 + 1
				// 一旦不满足，直接 break;
				if (str[i + pArr[i]] == str[i - pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}

			// i 回文半径在 r 外了，更新 r, c
			if (i + pArr[i] > r) {

				// 更新 r -> i + pArr[i]
				r = i + pArr[i];

				// 更新 c
				c = i;
			}

			// max -> 大的回文半径
			max = Math.max(max, pArr[i]);
		}

		// 半径大小 - 1 等于原串回文长度
		return max - 1;

	}

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	// for test
	public static int right(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = manacherString(s);
		int max = 0;
		for (int i = 0; i < str.length; i++) {
			int L = i - 1;
			int R = i + 1;
			while (L >= 0 && R < str.length && str[L] == str[R]) {
				L--;
				R++;
			}
			max = Math.max(max, R - L - 1);
		}
		return max / 2;
	}

	// for test
	public static String getRandomString(int possibilities, int size) {
		char[] ans = new char[(int) (Math.random() * size) + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
		}
		return String.valueOf(ans);
	}

	public static void main(String[] args) {
		int possibilities = 5;
		int strSize = 20;
		int testTimes = 5000000;
		System.out.println("test begin");
		for (int i = 0; i < testTimes; i++) {
			String str = getRandomString(possibilities, strSize);
			if (manacher(str) != right(str)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("test finish");
	}

}