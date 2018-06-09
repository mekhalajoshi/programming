package stacksQueues;

public class Stack {

	Node top;

	class Node {
		int data;
		Node next;

		Node() {

		}

		Node(int data) {
			this.data = data;
		}
	}

	/*-----------------------------------------*/

	public Node pop() {
		if (top == null) {
			return null;
		}
		Node temp = top;
		top = top.next;
		return temp;

	}

	public void push(int a) {
		Node temp = new Node(a);
		if (top == null) {
			top = temp;
		} else {
			temp.next = top;
			top = temp;
		}

	}

	public void printStack() {
		Node temp = top;
		if (top == null) {
			System.out.println("null");
		} else {
			while (temp != null) {
				System.out.println("" + temp.data);
				temp = temp.next;
			}
		}
	}

	/*-----------------------------------------*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack a = new Stack();
		int[] arr1 = { 1, 2, 3, 4, 5 };
		for (int i : arr1) {
			a.push(i);
		}
		a.printStack();
		System.out.println("");
		a.pop();
		a.printStack();
		System.out.println("");
		a.push(6);
		a.printStack();
		System.out.println("");
		System.out.println("");
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.pop();
		a.printStack();

	}

}
