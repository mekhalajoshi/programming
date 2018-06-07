package array;

/**
 * Monk loves to travel. Since his summer vacation was nearing, he decided to
 * plan a journey to Coderland. Now as Monk is just a competitive programmer, he
 * is always short of money. In order to make this journey happen, he wants to
 * minimize the total travel expenditure.
 *  
 * Journey to Coderland will be through N checkpoints. Checkpoints are numbered
 * from 0 to . At the start of the journey Monk is present at the checkpoint 0.
 * Also checkpoint will lead to Coderland. Each checkpoint has a petrol pump
 * which can be used to fill petrol in the car. Now cost of petrol per litre at
 * different checkpoints is given by array C which has 0-based indexing where is
 * the cost per litre of petrol at the checkpoint. Note that there is an
 * infinite amount of supply at each checkpoint and car tank is also of infinite
 * capacity. Now another array L is given which has 0-based indexing where
 * denotes the amount of petrol in litres required to reach the checkpoint from
 * the checkpoint. Note that the extra petrol remaining in the tank does not
 * vanishes after reaching a checkpoint. Also, Monk should have atleast litres
 * of petrol at each checkpoint in order to reach the next checkpoint.
 * 
 * Can you help Monk estimate the minimum cost required in order complete the
 * journey?
 * 
 * Input:
 * 
 * First line of the input contains test cases denoted by T.
 * 
 * For each of the test cases, first line contains a single integers N denoting
 * the number of checkpoints.
 * 
 * The next line contains N space separated integers representing the array C
 * which has 0-based indexing where the integer denotes the cost per litre of
 * petrol at checkpoint.
 * 
 * Last line contains array L ,which has 0-based indexing, consisting of N space
 * separated integers where the integer denotes the required amount of petrol
 * needed to reach the checkpoint from the checkpoint.
 * 
 * -Output:
 * 
 * For each of the test cases, output the required answer in a separate line.
 * 
 *
 * SAMPLE INPUT 
 * 1
 * 2 
 * 5 1 
 * 1 2 
 * 
 * 
 * SAMPLE OUTPUT 7 
 * Explanation We can buy petrol at
 * rate 5 per litre from checkpoint 0 and then at rate 1 per litre from
 * checkpoint 1. Thus, total cost incurred will be (5*1) + (1*2)  = 7. Had we bought all the
 * petrol at checkpoint 0, cost incurred would have been 5*(1+2) = 15 which is not the best
 * answer.
 * 
 */
 
public class MonkvisitsCoderand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int[] C = { 5, 1 };
		int[] L = { 1, 2 };
		System.out.println(solve(C, L, n));
	}

	public static long solve(int[] C, int[] L, int n) {
		long result =0; 
				// C[0] * L[0];
		long current = C[0];

		for (int i = 0; i < n; i++) {
			if (current > C[i])
			{
				current = C[i];
			}
				result += (current * L[i]);
		}

		return result;
	}

}
