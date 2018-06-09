package stacksQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 *Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10. 
 *  _
 * | |
 * | |_
 * |   |
 * |   |_
 * |     |
The answer for this would be 6, 3 * 2, using col1 and col2.
 *
 */
public class LargestRectangleInHistogram {
	
//has a bug
//	public static int largestRectangleArea(ArrayList<Integer> A) {
//		Stack<Integer> hstack = new Stack<Integer>();
//		Stack<Integer> pstack = new Stack<Integer>();
//		int height =0, maxheight=0;
////		int tempp =0;
//		for(int i=0 ; i<A.size(); i++) {
//			if(hstack.isEmpty()||hstack.peek()<A.get(i)) {
//				hstack.push(A.get(i));
//				pstack.push(i);
//			} else if(hstack.peek()>A.get(i)) {
//				
//				while(!hstack.isEmpty() && hstack.peek()>A.get(i)) {
//					height = hstack.pop() *(i-pstack.peek());
////					 tempp = pstack.pop();
//					maxheight = Math.max(maxheight, height);
//					
//					if(!hstack.isEmpty() && hstack.peek()>A.get(i)) {
//						pstack.pop();
//					}else {
//						hstack.push(A.get(i));
//						break;
//					}
//				}
////				if(hstack.isEmpty()) {
////					hstack.push(A.get(i));
////					pstack.push(tempp); 
////				}
//			}
//		}
//		if(!hstack.isEmpty()) {
//			height = hstack.pop() *(A.size()-pstack.pop());
//			maxheight = Math.max(maxheight, height);
//		}
//		return maxheight;
//	}
	
	public static int largestRectangleArea2(ArrayList<Integer> a) {
		Stack<Integer> stack = new Stack<Integer>();
		int area=0;
		int maxarea=0;
		int i=0;
		int top =0;
		while(i < a.size()){
            
            if(stack.isEmpty() || a.get(i) >= a.get(stack.peek())){
                stack.push(i);
                i++;
            }
            else {
                top = stack.peek(); // height
                stack.pop();
                area = a.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if(maxarea < area) 
                    maxarea = area;
            }
        }
		
		 while(!stack.isEmpty()){
	            top = stack.peek();
	            stack.pop();
	            area = a.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
	            if(maxarea < area) 
	                    maxarea = area;
	        }
        
        return maxarea;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
//		int arr[] =  {6, 1, 5, 4, 5, 2, 6}; //12
//		int arr[] =  {2,1,5,6,2,3}; //10
//		int arr[] =  {10, 40, 30, 70, 10, 30, 60}; //90
		int arr[] =  {47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27}; //418
		
		for (int element : arr) {
            a.add(element);
        }
//		a.add(1);
//		a.add(0);
//		a.add(2);
//		a.add(1);
//		a.add(0);
//		a.add(1);
//		a.add(3);
//		a.add(4);
//		a.add(1);
//		a.add(2);
//		a.add(1);
//		for(int i : a) {
//			System.out.println(a.get(i));
//		}
//		System.out.println(largestRectangleArea(a));
		System.out.println(largestRectangleArea2(a));
	}

}
