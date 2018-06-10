package linkedLists;

/**
 * Write code to remove duplicates from an unsorted linked list 
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed? n^2 Solution
 * 
 */
import java.util.HashSet;

import linkedLists.LinkedList.ListNode;

public class RemoveDuplicatesUnsortedList {

	public ListNode removeDuplicatesUnsorted(ListNode n) {
		if (n == null) {
			return n;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode current = n;
		ListNode previous = null;
		while (current != null) {
			if (set.contains(current.val)) {
				previous.next = current.next;
			} else {
				set.add(current.val);
				previous = current;
			}
			current = current.next;

		}
		return n;
	}

	public static void main(String[] args) {
		LinkedList b = new LinkedList();
		int[] arr2 = { 1, 2, 1 };
		for (int i : arr2) {
			b.add(i);
		}

		System.out.println("Original List");
		b.printList();
		b.head = new RemoveDuplicatesUnsortedList().removeDuplicatesUnsorted(b.head);
		System.out.println("Remove duplicates List");
		b.printList();

	}

}
