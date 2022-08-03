


public class Fourth{  
public static int getSmallest(int[] a, int total){  
int temp;  
for (int i = 0; i < total; i++)   
        {  
            for (int j = i + 1; j < total; j++)   
            {  
                if (a[i] > a[j])   
                {  
                    temp = a[i];  
                    a[i] = a[j];  
                    a[j] = temp;  
                }  
            }  
        }  
       return a[3];  
}  
public static void main(String args[]){  
int a[]={1,2,3,4,5,6,7,8};  

System.out.println("Smallest: "+getSmallest(a,6));  }}