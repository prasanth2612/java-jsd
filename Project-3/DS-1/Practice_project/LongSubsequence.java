public class LongSubsequence{
   static int long_seq(int a[], int a_len){
	   
	   
	   
      int b[] = new int[a_len];
      int i, j, max = 0;
      for (i = 0; i < a_len; i++)
         b[i] = 1;
      for (i = 1; i < a_len; i++)
      for (j = 0; j < i; j++)
      if (a[i] > a[j] && b[i] < b[j] + 1)
      b[i] = b[j] + 1;
      for (i = 0; i < a_len; i++)
      if (max < b[i])
      max = b[i];
      return max;
   }
   public static void main(String args[]){
	   
      int a[] = { 1,2,7,88,33,9,22,5,6};
      int a_len = a.length;
      System.out.println("The length of the longest increasing subsequence is " + long_seq(a, a_len));
   }
}