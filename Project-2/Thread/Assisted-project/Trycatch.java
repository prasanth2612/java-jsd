public class Trycatch {

	public static void main(String[] args) {
		int a[] = new int[2]; 
		
		try {
			int b = a[7];
			System.out.println(b);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index used is wrong");
		}finally {
			System.out.println("End of try catch block");
		}
	}

}
