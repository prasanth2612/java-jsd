import java.util.Arrays;

public class Rotation {

	public static void main(String[] args) {
		
            int []a= {9,8,7,6,5};
            int n = a.length;
            int m =5 ;  
            int i;
            
            for( i =0; i<m;i++) {
            	int last = a[n-1];
            	for(int j = n-1; j>0;j--) {
            		 a[j] = a[j-1];
            	}
            	a[0] =last;
            }
            
			System.out.println(" After rotation " + Arrays.toString(a));
	}

}