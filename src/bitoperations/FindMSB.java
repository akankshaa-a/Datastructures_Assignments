package bitoperations;

import java.util.*;

/**
 Program to find the MSB of a number
 */
public class FindMSB {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//Reading the number
		System.out.println("Enter the number");
		int n = s.nextInt();
		int num = n;
		int count=0;
		
		//Right shift by 1 position till the number becomes zero
		while(n>0)
		{
			n= n>>1;
			count++;
		}
		
		//left shift 1 by count-1 positions to get MSB
		System.out.println(1<<(count-1));
				
		/*
		   Another approach that works:
		 	 System.out.println(Math.pow(2,Math.floor(Math.log(num)/Math.log(2))));
		 */
		 
		 /**
		 * Explanation: A number is represented in binary as the nth power of 2,
		 * so Log of that number to the base 2 will give:
		 *  the power to which 2 should be raised, to get that number.
		 *  If the number is not a perfect multiple of 2,we get decimal fraction 
		 *  So we use Math.floor
		 * Finally, we use Math.pow(2, ) to get the MSB
		 */
	}

}