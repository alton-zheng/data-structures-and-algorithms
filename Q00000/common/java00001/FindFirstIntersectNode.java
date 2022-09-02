package java00001;

import java00000.ListNode;

public class FindFirstIntersectNode {

	public ListNode getIntersectNode(ListNode headA, ListNode headB) {
		
		// headA ， headB 有一个为空，直接返回 null
		// 边界： 返回 null,不会有相交的点
		if (headA == null || headB == null) {
			return null;
		}

		// 找到 headA headB 环形入口节点
		ListNode loop1 = getLoopNode(headA);
		ListNode loop2 = getLoopNode(headB);

		// 场景 1 ： 两个都是非循环的链表时
		if (loop1 == null && loop2 == null) {
			return noLoop(headA, headB);
		}

		// 场景 2 ： 两个都是环节点时
		if (loop1 != null && loop2 != null) {
			return bothLoop(headA, loop1, headB, loop2);
		}

		// 场景 3： 一个环一个非环，这种场景不可能有相交点，因此直接返回 null
		// 至于为什么？ 这里不再描述，链表基础
		return null;
	}

	/**
	 * 找入环链节点
	 * 为 null -> 无环链表
	 * 不为 null -> 有环链表， 入环点为 slow, fast
	 * @param head
	 * @return
	 */
	public ListNode getLoopNode(ListNode head) {

		// 边界条件， 当 head 为 null 或只有一个节点时，直接返回 null
		// 这种场景不可能有成环
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}


		// 定义 fast, slow 指针
		ListNode slow = head.next;
		ListNode fast = head.next.next;

		// slow fast 不同进行循环，直到他们相等
		while (slow != fast) {

			// 边界条件： fast 下节点或下下节点为空，说明此链表不可能成环，直接返回 null
			// fast 走的块，所以不用 slow 的边界条件
			if (fast.next == null || fast.next.next == null) {
				return null;
			}

			// 下推
			// fast 下推 2 个节点
			// slow 下推 1 个节点
			fast = fast.next.next;
			slow = slow.next;
		}

		// slow fast  相遇时，将 fast 指针指向 head
		// 也就是回到原点
		fast = head;

		// 然后 slow, fast 都一步一步走
		// 再次相遇的点就是入环点
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		// 返回 slow 节点
		return slow;
	}

	// 如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
	// 这里也可以采用上一题两链表拼接的方式来解题，代码会更简洁
	public static ListNode noLoop(ListNode headA, ListNode headB) {

		// 边界条件： headA, headB 一个链表为空时, 不可能相交，直接返回 null
		if (headA == null || headB == null) {
			return null;
		}

		// 定义两个链表的指针变量
		ListNode cur1 = headA;
		ListNode cur2 = headB;

		// 求两链表长度差
		int len = 0;
		while (cur1.next != null) {
			len++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			len--;
			cur2 = cur2.next;
		}

		// 正常场景， 到这里后，两个指针都相等， 走到尾节点了
		if (cur1 != cur2) {
			return null;
		}


		// 指针重置
		// cur1 -> 长链表
		// cur2 -> 短链表
		cur1 = len > 0 ? headA : headB;
		cur2 = cur1 == headA ? headB : headA;

		// 求 len 绝对值
		len = Math.abs(len);

		// cur1 先走 len 步
		while (len != 0) {
			len--;
			cur1 = cur1.next;
		}

		// 然后两个链表一起走，直到两链表相同
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}

		// 直接返回
		return cur1;
	}

	// 两个有环链表，返回第一个相交节点，如果不想交返回null
	public static ListNode bothLoop(ListNode headA, ListNode loop1, ListNode headB, ListNode loop2) {

		// 定义两个指针 cur1 , cur2
		ListNode cur1 = null;
		ListNode cur2 = null;

		// 如果 loop1 == loop2，两个链表肯定相交
		// 要么在非环部分就相交了，要么在 loop1 点
		if (loop1 == loop2) {

			// cur1 -> headA
			// cur2 -> headB
			cur1 = headA;
			cur2 = headB;

			// 因为两个链表同时入环
			// 找到非环部分长度差
			int len = 0;
			while (cur1 != loop1) {
				len++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				len--;
				cur2 = cur2.next;
			}

			// cur1 -> 长链表
			// cur2 -> 短链表
			cur1 = len > 0 ? headA : headB;
			cur2 = cur1 == headA ? headB : headA;
			len = Math.abs(len);

			// cur1 先走长度差部分步
			while (len != 0) {
				len--;
				cur1 = cur1.next;
			}

			// 再同时走
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}

			// 遇到的点就是相交点
			return cur1;

		} else {

			// 入环点不相等时
			// 分场景分析
			// cur1 -> loop1 下个节点
			cur1 = loop1.next;

			// cur1 != loop1 意味着 while 循环刚好一个圈
			while (cur1 != loop1) {

				// cur1 == loop2 时说明他们共环
				// 这时候直接返回 loop1 或 loop2  都是正确的
				if (cur1 == loop2) {
					return loop1;
				}

				// 下推
				cur1 = cur1.next;
			}

			// 如果 cur1 跑了一环圈回到原点了,说明他们两个环没有相交点
			// 返回 null
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);
		headA.next.next.next.next.next = new ListNode(6);
		headA.next.next.next.next.next.next = new ListNode(7);

		// 0->9->8->6->7->null
		ListNode headB = new ListNode(0);
		headB.next = new ListNode(9);
		headB.next.next = new ListNode(8);
		headB.next.next.next = headA.next.next.next.next.next; // 8->6
		System.out.println(new FindFirstIntersectNode().getIntersectNode(headA, headB).val);

		// 1->2->3->4->5->6->7->4...
		headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);
		headA.next.next.next.next.next = new ListNode(6);
		headA.next.next.next.next.next.next = new ListNode(7);
		headA.next.next.next.next.next.next = headA.next.next.next; // 7->4

		// 0->9->8->2...
		headB = new ListNode(0);
		headB.next = new ListNode(9);
		headB.next.next = new ListNode(8);
		headB.next.next.next = headA.next; // 8->2
		System.out.println(new FindFirstIntersectNode().getIntersectNode(headA, headB).val);

		// 0->9->8->6->4->5->6..
		headB = new ListNode(0);
		headB.next = new ListNode(9);
		headB.next.next = new ListNode(8);
		headB.next.next.next = headA.next.next.next.next.next; // 8->6
		System.out.println(new FindFirstIntersectNode().getIntersectNode(headA, headB).val);

	}

}