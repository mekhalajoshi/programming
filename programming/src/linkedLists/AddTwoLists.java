package linkedLists;

public class AddTwoLists {

	public static void printList(ListNode head) {
		if (head == null) {
			System.out.println("null");
		} else {
			ListNode temp = head;
			while (temp != null) {
				System.out.print(temp.val + "->");
				temp = temp.next;
			}
			System.out.print("null");
			System.out.println();
		}
	}

	public static ListNode addTwoLists(ListNode A, ListNode B) {
		ListNode Ahead = reverseList(A);
		ListNode Bhead = reverseList(B);
		ListNode currentA = Ahead;
		ListNode currentB = Bhead;
		ListNode prev = null;
		ListNode newHead = null;
		int sum = 0;
		int rem = 0;
		int carry = 0;
		while (currentA != null || currentB != null) {
			if (currentA == null) {
				while (currentB != null) {
					sum = currentB.val + carry;
					rem = sum % 10;
					carry = sum / 10;
					if (prev == null) {
						prev = new ListNode(rem);
						newHead = prev;
					} else {
						prev.next = new ListNode(rem);
						prev = prev.next;
					}
					currentB = currentB.next;
				}

			} else if (currentB == null) {

				while (currentA != null) {
					sum = currentA.val + carry;
					rem = sum % 10;
					carry = sum / 10;
					if (prev == null) {
						prev = new ListNode(rem);
						newHead = prev;
					} else {
						prev.next = new ListNode(rem);
						prev = prev.next;
					}
					currentA = currentA.next;
				}

			} else {

				sum = currentA.val + currentB.val + carry;
				rem = sum % 10;
				carry = sum / 10;

				if (prev == null) {
					prev = new ListNode(rem);
					newHead = prev;
				} else {
					prev.next = new ListNode(rem);
					prev = prev.next;
				}
				currentA = currentA.next;
				currentB = currentB.next;
			}
		}
		if (carry == 1) {
			prev.next = new ListNode(carry);
		} else {
			prev.next = null;
		}

		return reverseList(newHead);

	}

	private static ListNode reverseList(ListNode a) {
		ListNode prev = null;
		ListNode current = a;
		ListNode temp = null;

		while (current != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}

		return prev;
	}

	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		int[] arr1 = { 1, 2, 3 };
		for (int i : arr1) {
			a.add(i);
		}
		System.out.print("List A ");
		a.printList();

		LinkedList b = new LinkedList();
		int[] arr2 = { 1, 2, 3, 4, 5 };
		for (int i : arr2) {
			b.add(i);
		}
		System.out.print("List B ");
		b.printList();

		LinkedList result = new LinkedList();
		result.head = addTwoLists(a.head, b.head);

		System.out.print("Result ");
		result.printList();
	}

}
