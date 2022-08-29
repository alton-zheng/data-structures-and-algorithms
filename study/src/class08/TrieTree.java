package class08;

import java.util.HashMap;

public class TrieTree {

	class Trie1 {

		class Node {
			public int pass;
			public int end;
			public Node1[] nexts;

			// char tmp = 'b'  (tmp - 'a')
			public Node() {
				pass = 0;
				end = 0;

				// 0    a
				// 1    b
				// 2    c
				// ..   ..
				// 25   z
				// 小写字母， 26 长度就够了。
				// 分场景使用不同数据结构即可
				nexts = new Node1[26];
			}
		}

		// 节点
		private Node root;

		// 构造方法
		public Trie1() {
			root = new Node();
		}

		/**
		 * 插入 word
		 * @param word
		 */
		public void insert(String word) {

			// word 为空时，直接返回，不做任何处理
			if (word == null) {
				return;
			}

			// 将 word char[] 化
			char[] str = word.toCharArray();

			// 定义根节点, 初始化为当前 trie root 节点
			Node node = root;

			node.pass++;

			// 定义路径索引
			int path = 0;

			// 从左往右遍历字符
			for (int i = 0; i < str.length; i++) {

				// 由字符，对应成走向哪条路
				path = str[i] - 'a';
				if (node.nexts[path] == null) {
					// 空的情况，新建 Node
					node.nexts[path] = new Node();
				}

				// node 下沉
				node = node.nexts[path];

				// pass++
				node.pass++;
			}

			// 最后一个 char 为 end char, end++
			node.end++;
		}

		/**
		 * 删除 word
		 * @param word
		 */
		public void delete(String word) {

			// 当 word  在 trie 中出现不等于 0 才有意义
			// 等于 0 ，说明没出现过
			int times = search(word);

			if (times == 0) {
				return;
			}

			// 将 word char[] 化
			char[] chs = word.toCharArray();

			// node -> root
			Node node = root;

			//  word 减去
			// pass--
			node.pass--;

			//  path 初始化为 0
			int path = 0;

			// 开始遍历 chs
			for (int i = 0; i < chs.length; i++) {

				// 找到首字符 path 值
				path = chs[i] - 'a';

				// 下一个节点 pass 减去 1 后，如果等于 0
				if (--node.nexts[path].pass == 0) {

					// 将节点置为 null, 因为它没用了
					// 一直留着，不然容易内存泄漏
					node.nexts[path] = null;

					// 为null了，node 就不会有 nexts, 直接返回即可
					return;
				}

				// 下沉
				node = node.nexts[path];
			}

			// 最后一个 char 对应 node end 减去 1
			node.end--;

		}

		/**
		 * word这个单词之前加入过几次
		 * @param word
		 * @return
		 */
		public int search(String word) {

			// word 为空，直接返回 0， 没出现过
			if (word == null) {
				return 0;
			}

			// word char[] 化
			char[] chs = word.toCharArray();

			// 定义 node  ，初始化 root
			Node node = root;

			// 首先 path 为 0
			int path = 0;

			// 开始遍历 word char[]
			for (int i = 0; i < chs.length; i++) {
				path = chs[i] - 'a';
				if (node.nexts[path] == null) {

					// 边界场景： next 节点为null
					return 0;
				}

				// 正常场景， 下沉 node
				node = node.nexts[path];
			}

			// 返回最后一个 char node end 值
			return node.end;
		}

		// 所有加入的字符串中，有几个是以 pre 这个字符串作为前缀的
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			Node1 node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}

			// 上面的源码不再重复解释，和 search 的唯一区别
			// 返回的属性值不同而已，这里返回 pass, search 返回 end
			return node.pass;
		}
	}

	public static class Node2 {
		public int pass;
		public int end;
		public HashMap<Integer, Node2> nexts;

		public Node2() {
			pass = 0;
			end = 0;
			nexts = new HashMap<>();
		}
	}

	public static class Trie2 {
		private Node2 root;

		public Trie2() {
			root = new Node2();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			Node2 node = root;
			node.pass++;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = (int) chs[i];
				if (!node.nexts.containsKey(index)) {
					node.nexts.put(index, new Node2());
				}
				node = node.nexts.get(index);
				node.pass++;
			}
			node.end++;
		}

		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				Node2 node = root;
				node.pass--;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = (int) chs[i];
					if (--node.nexts.get(index).pass == 0) {
						node.nexts.remove(index);
						return;
					}
					node = node.nexts.get(index);
				}
				node.end--;
			}
		}

		// word这个单词之前加入过几次
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			Node2 node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = (int) chs[i];
				if (!node.nexts.containsKey(index)) {
					return 0;
				}
				node = node.nexts.get(index);
			}
			return node.end;
		}

		// 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			Node2 node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = (int) chs[i];
				if (!node.nexts.containsKey(index)) {
					return 0;
				}
				node = node.nexts.get(index);
			}
			return node.pass;
		}
	}

	public static class Right {

		private HashMap<String, Integer> box;

		public Right() {
			box = new HashMap<>();
		}

		public void insert(String word) {
			if (!box.containsKey(word)) {
				box.put(word, 1);
			} else {
				box.put(word, box.get(word) + 1);
			}
		}

		public void delete(String word) {
			if (box.containsKey(word)) {
				if (box.get(word) == 1) {
					box.remove(word);
				} else {
					box.put(word, box.get(word) - 1);
				}
			}
		}

		public int search(String word) {
			if (!box.containsKey(word)) {
				return 0;
			} else {
				return box.get(word);
			}
		}

		public int prefixNumber(String pre) {
			int count = 0;
			for (String cur : box.keySet()) {
				if (cur.startsWith(pre)) {
					count += box.get(cur);
				}
			}
			return count;
		}
	}

	// for test
	public static String generateRandomString(int strLen) {
		char[] ans = new char[(int) (Math.random() * strLen) + 1];
		for (int i = 0; i < ans.length; i++) {
			int value = (int) (Math.random() * 6);
			ans[i] = (char) (97 + value);
		}
		return String.valueOf(ans);
	}

	// for test
	public static String[] generateRandomStringArray(int arrLen, int strLen) {
		String[] ans = new String[(int) (Math.random() * arrLen) + 1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = generateRandomString(strLen);
		}
		return ans;
	}

	public static void main(String[] args) {
		int arrLen = 100;
		int strLen = 20;
		int testTimes = 100000;
		for (int i = 0; i < testTimes; i++) {
			String[] arr = generateRandomStringArray(arrLen, strLen);
			Trie1 trie1 = new Trie1();
			Trie2 trie2 = new Trie2();
			Right right = new Right();
			for (int j = 0; j < arr.length; j++) {
				double decide = Math.random();
				if (decide < 0.25) {
					trie1.insert(arr[j]);
					trie2.insert(arr[j]);
					right.insert(arr[j]);
				} else if (decide < 0.5) {
					trie1.delete(arr[j]);
					trie2.delete(arr[j]);
					right.delete(arr[j]);
				} else if (decide < 0.75) {
					int ans1 = trie1.search(arr[j]);
					int ans2 = trie2.search(arr[j]);
					int ans3 = right.search(arr[j]);
					if (ans1 != ans2 || ans2 != ans3) {
						System.out.println("Oops!");
					}
				} else {
					int ans1 = trie1.prefixNumber(arr[j]);
					int ans2 = trie2.prefixNumber(arr[j]);
					int ans3 = right.prefixNumber(arr[j]);
					if (ans1 != ans2 || ans2 != ans3) {
						System.out.println("Oops!");
					}
				}
			}
		}
		System.out.println("finish!");

	}

}
