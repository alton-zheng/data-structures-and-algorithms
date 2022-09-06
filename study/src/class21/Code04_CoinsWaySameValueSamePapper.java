package class21;

import java.util.HashMap;
import java.util.Map.Entry;

public class Code04_CoinsWaySameValueSamePapper {

	public static class Info {
		public int[] coins;
		public int[] zhangs;

		public Info(int[] c, int[] z) {
			coins = c;
			zhangs = z;
		}
	}

	public static Info getInfo(int[] arr) {

		// 统计 coins 数量
		HashMap<Integer, Integer> counts = new HashMap<>();

		// 遍历 arr, 统计币种和数量
		for (int value : arr) {
			if (!counts.containsKey(value)) {
				counts.put(value, 1);
			} else {
				counts.put(value, counts.get(value) + 1);
			}
		}

		// 币种数量
		int coinsNum = counts.size();
		int[] coins = new int[coinsNum];
		int[] coinNum = new int[coinsNum];

		int index = 0;

		// 遍历 hashMap将币种和数量取出分别放入 coins 和 coinNum 数组中
		for (Entry<Integer, Integer> entry : counts.entrySet()) {
			coins[index] = entry.getKey();
			coinNum[index++] = entry.getValue();
		}

		// 返回 coins coinNum 信息
		return new Info(coins, coinNum);
	}

	public static int coinsWay(int[] arr, int aim) {

		// arr 为空或长度为 0 或 aim 小于 0， 输入无意义，直接返回 0 即可
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}

		// 获取 coins 和 coinNum 信息，并将他们代入到递归方法 getNum 方法中
		Info info = getInfo(arr);
		return getNum(info.coins, info.zhangs, 0, aim);
	}

	// coins 面值数组，正数且去重
	// zhangs 每种面值对应的张数
	public static int getNum(int[] coins, int[] zhangs, int coinsIndex, int rest) {

		// 当前递归，越位时（也就是超过币种种类时）
		if (coinsIndex == coins.length) {

			// 剩余 rest 如果为 0， 意味着当前选择是有效的，否则无效
			return rest == 0 ? 1 : 0;

		}

		// 定义当前位置 index 往后能获得的方法数
		int ways = 0;

		// zhng * coins[coinIndex] <= index 是什么含义呢？
		// 当前可以选择的 zhang 数和币种数值相乘，它能获得的币值不能超过剩余要得到的 rest
		// 超出了无意义，且方法不可用，因此超出的张数的方法没必要再试
		for (int zhang = 0; zhang * coins[coinsIndex] <= rest && zhang <= zhangs[coinsIndex]; zhang++) {
			ways += getNum(coins, zhangs, coinsIndex + 1, rest - (zhang * coins[coinsIndex]));
		}

		// 范湖方法数
		return ways;
	}


	// 上面递归的动态规划版本，逻辑一模一样
	public static int dp1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		Info info = getInfo(arr);
		int[] coins = info.coins;
		int[] zhangs = info.zhangs;
		int N = coins.length;

		// 定义 dp 二维数组， row -> N + 1  col 为 aim + 1
		int[][] dp = new int[N + 1][aim + 1];

		// 根据递归规则，当 rest 为0，且到最后位时， 为 1， 其它场景均为 0
		// 其余二维方格值，不需要处理，int 默认值为 0
		dp[N][0] = 1;

		// 开始处理， index [N-1, 0]
		for (int index = N - 1; index >= 0; index--) {

			// rest [0, aim] 区间
			for (int rest = 0; rest <= aim; rest++) {

				// 定义当前 index, rest 后能得到的 ways
				int ways = 0;

				// 这里不再赘述， 和递归逻辑一致
				for (int zhang = 0; zhang * coins[index] <= rest && zhang <= zhangs[index]; zhang++) {

					ways += dp[index + 1][rest - (zhang * coins[index])];
				}

				// 赋值 -》 dp[index][rest] 方格
				dp[index][rest] = ways;
			}
		}

		// 返回结果值
		return dp[0][aim];
	}

	// 上面的 dp1 方法针对每个方法还需要 for 循环遍历所有满足条件的 coins 数量 （zhang）
	// 有优化空间
	public static int dp2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		Info info = getInfo(arr);
		int[] coins = info.coins;
		int[] zhangs = info.zhangs;
		int N = coins.length;
		int[][] dp = new int[N + 1][aim + 1];
		dp[N][0] = 1;
		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 0; rest <= aim; rest++) {

				// 定义当前位 index, rest
				// 刚开始都为 0， 当前不选择任何 coin 时， 等于下一层 [index + 1][rest] 的值
				dp[index][rest] = dp[index + 1][rest];

				// 如果 rest - coins[index] >= 0 意味着 coins[index] 可以选择
				if (rest - coins[index] >= 0) {

					// 加上 dp[index][rest - coins[index]
					// 同一币种， rest - coins[index] 位
					dp[index][rest] += dp[index][rest - coins[index]];
				}

				if (rest - coins[index] * (zhangs[index] + 1) >= 0) {

					// 减去的是刚加的同一层分解开的最后一个符合条件的 coins  数位置
					dp[index][rest] -= dp[index + 1][rest - coins[index] * (zhangs[index] + 1)];
				}
			}
		}

		// 返回dp [0, aim] 位置
		return dp[0][aim];
	}

	// 为了测试
	public static int[] randomArray(int maxLen, int maxValue) {
		int N = (int) (Math.random() * maxLen);
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = (int) (Math.random() * maxValue) + 1;
		}
		return arr;
	}

	// 为了测试
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// 为了测试
	public static void main(String[] args) {
		int maxLen = 10;
		int maxValue = 20;
		int testTime = 1000000;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr = randomArray(maxLen, maxValue);
			int aim = (int) (Math.random() * maxValue);
			int ans1 = coinsWay(arr, aim);
			int ans2 = dp1(arr, aim);
			int ans3 = dp2(arr, aim);
			if (ans1 != ans2 || ans1 != ans3) {
				System.out.println("Oops!");
				printArray(arr);
				System.out.println(aim);
				System.out.println(ans1);
				System.out.println(ans2);
				System.out.println(ans3);
				break;
			}
		}
		System.out.println("测试结束");
	}

}
