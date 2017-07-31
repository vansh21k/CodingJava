package com.vansh.linkedlist;

import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class MergeSortedLists {

	public static void main(String[] args) {
		ListNode t = new ListNode(1);
		t.setNext(new ListNode(2));
		t.next.setNext(new ListNode(7));
		ListNode[] arrList = new ListNode[] {t};
		System.out.println(mergeKLists(arrList));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = null;
		if (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				result = l1;
				result.next = mergeTwoLists(l1.next, l2);
			} else {
				result = l2;
				result.next = mergeTwoLists(l1, l2.next);
			}
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		return result;
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode current = head;
		ListNode previous = null;
		// first find the nth node from the end
		ListNode temp = head;
		int index = 0;
		while (temp != null && index < n) {
			temp = temp.next;
			index++;
		}
		// not enough nodes
		if (temp == null) {
			return head.next;
		}
		// discover nth node from end
		while (temp != null) {
			previous = current;
			current = current.next;
			temp = temp.next;
		}
		if (current == head) {
			return head.next;
		}
		previous.next = current.next;
		current = null;
		return head;
	}

	public static  ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		ListNode dummyNode = new ListNode(0);
		// dummy next points to the start of the lists
		ListNode[] startPointers = new ListNode[lists.length];
		for (int i = 0; i < k; ++i) {
			startPointers[i] = lists[i];
		}
		ListNode current = dummyNode;
		while (current != null) {
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i = 0; i < k; ++i) {
				if (startPointers[i] != null && startPointers[i].val < min) {
					min = startPointers[i].val;
					minIndex = i;
				}
			}
			if (minIndex != -1) {
				current.next = startPointers[minIndex];
				startPointers[minIndex] = startPointers[minIndex].next;
				current = current.next;
				current.next = null;
				
			} else {
				current.next = null;
				current = current.next;
			}
		}
		return dummyNode.next;
	}

}
