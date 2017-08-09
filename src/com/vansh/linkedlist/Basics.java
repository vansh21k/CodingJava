package com.vansh.linkedlist;

public class Basics {
	void deleteDups(ListNode head) {
		
		if (head == null || head.next == null) {
			return;
		}
		ListNode current = head;
		while (current != null) {
			ListNode runner = current;
			while (runner.next != null) {
				if (runner.next.val == current.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode before = null;
		ListNode after = null;
		ListNode current = head;
		while (current!=null) {
			ListNode next = current.next;
			if (current.val <=x) {
				current.next = before; 
				before = current;
			} else {
				current.next = after;
				after = current;
			}
			current = next;
		}
		if (before == null) {
			return after;
		}
		return before;
	}
}
