package bitoperations;

import java.util.*;

/**
 Program to find the number of bits required to form a number
 */
public class FindBits {

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
		
		System.out.println(count); //Count gives the number of bits
		
		
		/*
		   Another approach that works:
		   	System.out.println(1+Math.floor(Math.log(num)/Math.log(2)));
		 */
		 
		 /**
		 * Explanation: A number is represented in binary as the nth power of 2,
		 * so Log of that number to the base 2 will give:
		 *  the power to which 2 should be raised, to get that number.
		 *  If the number is not a perfect multiple of 2,we get decimal fraction 
		 *  So we use Math.floor. and add 1 (Here Math.ceil wont work for powers of 2)
		 */
	}

}