package com.vansh.linkedlist;

public class SwapPairs {
	public static void main(String[] args) {
		ListNode t = new ListNode(1);
		t.next = new ListNode(2);
		t.next.next= new ListNode(3);
		t.next.next.next = new ListNode(4);
		System.out.println(swapPairs(t));
	}
	public static  ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = head, even = head.next;
		// dummy node
		ListNode prev = new ListNode(0);
		
		while (odd!=null) {
			
			ListNode next = (even == null)? null: even.next;
			odd.next = next;
			if (even!=null) {
				even.next = odd;
			}
			if (next == null || next.next == null) {
				return head.next;
			}
			odd = next;
			even = next.next;
			prev.next = even;
			prev = prev.next;
		}
		
		return head.next;
		
	}
	
	
}
