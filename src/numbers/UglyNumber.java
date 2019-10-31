package numbers;
import java.util.*;

/*
 * Program to find the nth Ugly number
 * an Ugly number is a number 
 * whose only prime factors are 2,3 and 5
 */
public class UglyNumber {
	//Function to find the minimum of 3 numbers:
	static int min(int a, int b, int c)
	{
		if(a<b)
		{
			if(a<c)
				return a;
			else
				return c;
		}
		else
		{
			if(b<c)
				return b;
			else
				return c;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//Reading the value of n
		System.out.println("Enter the value of n:");
		int n = s.nextInt();
		
		int ugly[] = new int[n];
		
		int i=0,i2=0,i3=0,i5=0;
		
		//1 is the first ugly number by convention
		ugly[0]=1;
		
		for(i=1;i<n;i++)
		{
			/*
			 * The ith ugly number is found using the indices i2,i3 and 15
			 * i2 points to the last ugly multiple of 2
			 * i3 points to the last ugly multiple of 3
			 * i5 points to the last ugly multiple of 5
			 * 
			 * the next multiple of 2, 3 and 5 are calculated and
			 * the minimum of these becomes the next ugly number.
			 * and the corresponding index(12,13 and/or 15)
			 * will be incremented
			 */
			ugly[i] = min(2*ugly[i2],3*ugly[i3],5*ugly[i5]);
			
			if(ugly[i] == 2*ugly[i2])
				i2++;
			if(ugly[i] == 3*ugly[i3])
				i3++;
			if(ugly[i] == 5*ugly[i5])
				i5++;
		}
		
		System.out.println("nth ugly number: "+ugly[n-1]);
		 
	}

}
