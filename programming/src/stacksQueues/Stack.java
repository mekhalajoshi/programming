package stacksQueues;

public class Stack {
	Stack() {
		minStack = new java.util.Stack<Integer>();
	}

	java.util.Stack<Integer> minStack;

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

	public Integer pop() {

		Node temp = minPop();
		if (min() == temp.data) {
			minStack.pop();
		}
		return temp.data;
	}

	public Node minPop() {
		if (top == null) {
			return null;
		}
		Node temp = top;
		top = top.next;
		return temp;
	}

	public void push(int a) {
		if (a <= min()) {
			minStack.push(a);
		}
		minPush(a);

	}

	public void minPush(int a) {
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

	public int min() {
		if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
	}

	/*-----------------------------------------*/

	public static void main(String[] args) {
		Stack a = new Stack();
		int[] arr1 = { 1, 2, 3, 4, 5 };
		for (int i : arr1) {
			a.push(i);
		}
		System.out.println("Original");
		a.printStack();
		System.out.println("");

		System.out.println("Min Stack");
		a.printStack();
		System.out.println("Min:" + a.min());
		System.out.println("");
	}

}
