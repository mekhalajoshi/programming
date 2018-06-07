
package linkedlists;

import linkedlists.LinkedList.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example,
 * 
 * Given 1->1->2, return 1->2.
 * 
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 *
 */
public class RemoveDuplicateFromLinkedList {

	public static  ListNode deleteDuplicates(ListNode a) {
		if (a == null) 
			return null;
		if (a.next == null)
			return a;
		ListNode prev = a;
		ListNode current = a.next;
		while (current != null) {
			if (current.val != prev.val) {
				prev.next = current; // delete duplicate nodes
				prev = current; // move to the next node
			}
			current = current.next;
			if (current == null && prev.next != current) {
				prev.next = null;
			}
		}
		return a;
	}
	
	//InterviewBit solution
	public static ListNode deleteDuplicates2(ListNode a) {
	    ListNode current = a;
	    if (a == null) 
			return null;
	    while (current.next != null) {
	        if (current.val == current.next.val) {
	            current.next = current.next.next;
	        }
	        else {
	            current = current.next;
	        }
	    }
	    return a;
	}

	public static void main(String[] args) {
		
		
		
		System.out.println("Remove duplicates ");
		System.out.println("");
		
		LinkedList a = new LinkedList();
		int[] arr1 = { 1, 1,2,3 };
		for (int i : arr1) {
			a.add(i);
		}
		System.out.println("Original List");
		a.printList();

		
		LinkedList result = new LinkedList();
		result.head = deleteDuplicates(a.head);
		System.out.println("Remove duplicates List");
		result.printList();
		
		
		System.out.println("Original List");
		a.printList();
		System.out.println();

		result.head = deleteDuplicates2(a.head);
		System.out.println("Remove duplicates List");
		result.printList();

		System.out.println();

		LinkedList b = new LinkedList();
		int[] arr2 = { };
		for (int i : arr2) {
			b.add(i);
		}
		System.out.println("Original List");
		b.printList();
		b.head = deleteDuplicates(b.head);
		System.out.println("Remove duplicates List");
		b.printList();
		
	
		System.out.println("Original List");
		b.printList();
		b.head = deleteDuplicates2(b.head);
		System.out.println("Remove duplicates List");
		b.printList();

	}

}
