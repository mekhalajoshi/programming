package matrix;

public class RotateMatrix {

	public static void rotateMatrix(int N, int mat[][]){
		transpose(mat);
		reverseColumn(mat);
		
	}
	
	private static void reverseColumn(int[][] mat) {
		// TODO Auto-generated method stub
		int N = mat.length;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N/2 ;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][N-j-1];
				 mat[i][N-j-1] = temp;
			}
		}
		
	}

	private static void transpose(int[][] mat) {
		int N = mat.length;
		for (int i = 0; i < N; i++)
        {
            for (int j = i; j < N; j++) {
            	int temp = mat[i][j];
            	mat[i][j] = mat[j][i];
            	mat[j][i] = temp;
            	
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
        
        // Test Case 1
        int mat[][] =
        {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        displayMatrix(N,mat);
        
        rotateMatrix(N,mat);
        
        displayMatrix(N,mat);
	}

	private static void displayMatrix(int N, int[][] mat) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
      
            System.out.print("\n");
        }
        System.out.print("\n");
	}

}
