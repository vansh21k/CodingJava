package com.vansh.linkedlist;



public class AddLinkedList {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode result = addTwoNumbers(l1, l2);
		
	}
	public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbersHelper(l1, l2, 0);
	}

	private static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
		carry = sum / 10;
		ListNode result = new ListNode(sum % 10);
		result.next = addTwoNumbersHelper(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
		return result;
	}
}
