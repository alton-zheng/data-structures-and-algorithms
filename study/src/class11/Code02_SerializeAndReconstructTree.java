package class11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code02_SerializeAndReconstructTree {
    /*
     * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化，
     * 以下代码全部实现了。
     * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
     * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
     * 比如如下两棵树
     *         __2
     *        /
     *       1
     *       和
     *       1__
     *          \
     *           2
     * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
     *
     * */
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Queue<String> preSerial(Node head) {
		Queue<String> ans = new LinkedList<>();
		pres(head, ans);
		return ans;
	}

	public static void pres(Node head, Queue<String> ans) {
		if (head == null) {
			ans.add(null);
		} else {
			ans.add(String.valueOf(head.value));
			pres(head.left, ans);
			pres(head.right, ans);
		}
	}

	public static Queue<String> inSerial(Node head) {
		Queue<String> ans = new LinkedList<>();
		ins(head, ans);
		return ans;
	}

	public static void ins(Node head, Queue<String> ans) {
		if (head == null) {
			ans.add(null);
		} else {
			ins(head.left, ans);
			ans.add(String.valueOf(head.value));
			ins(head.right, ans);
		}
	}

	public static Queue<String> posSerial(Node head) {
		Queue<String> ans = new LinkedList<>();
		poss(head, ans);
		return ans;
	}

	public static void poss(Node head, Queue<String> ans) {
		if (head == null) {
			ans.add(null);
		} else {
			poss(head.left, ans);
			poss(head.right, ans);
			ans.add(String.valueOf(head.value));
		}
	}

	public static Node buildByPreQueue(Queue<String> prelist) {
		if (prelist == null || prelist.size() == 0) {
			return null;
		}
		return preb(prelist);
	}

	public static Node preb(Queue<String> prelist) {
		String value = prelist.poll();
		if (value == null) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = preb(prelist);
		head.right = preb(prelist);
		return head;
	}

	public static Node buildByPosQueue(Queue<String> poslist) {
		if (poslist == null || poslist.size() == 0) {
			return null;
		}
		// 左右中  ->  stack(中右左)
		Stack<String> stack = new Stack<>();
		while (!poslist.isEmpty()) {
			stack.push(poslist.poll());
		}
		return posb(stack);
	}

	public static Node posb(Stack<String> posstack) {
		String value = posstack.pop();
		if (value == null) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.right = posb(posstack);
		head.left = posb(posstack);
		return head;
	}

	public static Queue<String> levelSerial(Node head) {
		Queue<String> ans = new LinkedList<>();
		if (head == null) {
			ans.add(null);
		} else {
			ans.add(String.valueOf(head.value));
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(head);
			while (!queue.isEmpty()) {
				head = queue.poll(); // head 父   子
				if (head.left != null) {

					// 子树不为空时，既要序列化也要放队列放
					ans.add(String.valueOf(head.left.value));
					queue.add(head.left);
				} else {

					// 为空时，只序列化
					ans.add(null);
				}
				if (head.right != null) {
					// 子树不为空时， 既要序列化也要放队列放
					ans.add(String.valueOf(head.right.value));
					queue.add(head.right);
				} else {

					// 不为空时，只序列化
					ans.add(null);
				}
			}
		}
		return ans;
	}

	public static Node buildByLevelQueue(Queue<String> levelList) {

		// 队列为空时， 或者 size 为 0， 直接返回 null
		if (levelList == null || levelList.size() == 0) {
			return null;
		}

		// 首先创建 head 头结点
		// 后面的流程会在 head 左右子树不断的处理
		Node head = generateNode(levelList.poll());

		// 创建 queue
		Queue<Node> queue = new LinkedList<Node>();

		//  如果头不为空
		if (head != null) {

			// 放队列
			queue.add(head);
		}

		Node node = null;
		while (!queue.isEmpty()) {

			// 队列不为空时
			// 从队列中取 node
			node = queue.poll();

			// 利用 levelList 取出 poll() 放入 node.left
			// 利用 levelList 取出， 放入  node.right
			node.left = generateNode(levelList.poll());
			node.right = generateNode(levelList.poll());


			// 如果 node.left 不为空时，将它也放入 queue 中备用
			if (node.left != null) {
				queue.add(node.left);
			}

			// 如果 node.right 不为空时，将它也放入 queue 中备用
			if (node.right != null) {
				queue.add(node.right);
			}
		}

		// 返回 head
		return head;
	}

	/**
	 * 辅助方法， 生成树节点
	 * @param val
	 * @return
	 */
	public static Node generateNode(String val) {
		if (val == null) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}

	// for test
	public static Node generateRandomBST(int maxLevel, int maxValue) {
		return generate(1, maxLevel, maxValue);
	}

	// for test
	public static Node generate(int level, int maxLevel, int maxValue) {
		if (level > maxLevel || Math.random() < 0.5) {
			return null;
		}
		Node head = new Node((int) (Math.random() * maxValue));
		head.left = generate(level + 1, maxLevel, maxValue);
		head.right = generate(level + 1, maxLevel, maxValue);
		return head;
	}

	// for test
	public static boolean isSameValueStructure(Node head1, Node head2) {
		if (head1 == null && head2 != null) {
			return false;
		}
		if (head1 != null && head2 == null) {
			return false;
		}
		if (head1 == null && head2 == null) {
			return true;
		}
		if (head1.value != head2.value) {
			return false;
		}
		return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
	}

	// for test
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		int maxLevel = 5;
		int maxValue = 100;
		int testTimes = 1000000;
		System.out.println("test begin");
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			Queue<String> pre = preSerial(head);
			Queue<String> pos = posSerial(head);
			Queue<String> level = levelSerial(head);
			Node preBuild = buildByPreQueue(pre);
			Node posBuild = buildByPosQueue(pos);
			Node levelBuild = buildByLevelQueue(level);
			if (!isSameValueStructure(preBuild, posBuild) || !isSameValueStructure(posBuild, levelBuild)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("test finish!");

	}
}
