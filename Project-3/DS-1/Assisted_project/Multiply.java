

public class Multiply {

	public static void main(String[] args) {
		

		
		int a[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int b[][] = {{1,2,3},{5,5,6},{7,8,9}};
		int i,j = 0;
		int c[][]=new int[3][3];
	
		

		
		
		
		for(i =0; i<3; i++) {
			for( j =0; j< 3;j++) {
				c[i][j] =0;
				   for(int k =0; k<3;k++) {
					   
				c[i] [j]+=  a[i][k]*b[j][k];     
				   }
				   
				   
				   System.out.print(c[i][j]+" ");   
			}
			System.out.println();
		
	}
	}
}
