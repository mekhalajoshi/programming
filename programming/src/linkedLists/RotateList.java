package linkedLists;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 *
 */

public class RotateList {

	public static ListNode rotateRight(ListNode A, int B) {
		ListNode i, j;
		i = A;
		j = A;
		int size = 0;
		if (A.next == null)
			return A;
		ListNode A1 = A;
		while (A1 != null) {
			size++;
			A1 = A1.next;
		}
		if (B % size == 0)
			return A;
		for (int k = 0; k < B % size; k++) {

			if (i.next != null)
				i = i.next;
			else
				return A;
		}

		while (i.next != null) {
			i = i.next;
			j = j.next;
		}
		ListNode temp = j.next;
		j.next = null;
		j = temp;
		i.next = A;
		return j;
	}
	
	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		int[] arr1 = { 1, 2,3,4,5 };
		for (int i : arr1) {
			a.add(i);
		}
		System.out.println("Rotate List");
		System.out.println("");
		
		
		System.out.println("Original List");
		a.printList();
		
		a.head = rotateRight(a.head, 2);
		
		System.out.println("Right Rotated List 2");
		a.printList();

	}

}
