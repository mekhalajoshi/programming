package linkedLists;

import linkedLists.LinkedList.ListNode;

public class ReverseList {
	public static ListNode reverseList(ListNode A) {
		if(A==null) {
			return  A;
		}
		ListNode prev = null;
		ListNode current = A;
		ListNode temp=null;
		while(current!=null) {
			temp=current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return current;
	}

	public static void main(String[] args) {				
		LinkedList a = new LinkedList();
		int[] arr1 = { 1,2,3,4,5 };
		for (int i : arr1) {
			a.add(i);
		}
		System.out.print("Original List ");
		a.printList();
		a.head=reverseList(a.head);
		System.out.print("Reversed List ");
		a.printList();
		
	}
}
