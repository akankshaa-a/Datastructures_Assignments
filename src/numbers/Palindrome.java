package numbers;

import java.util.*;

/*
 * Class to find whether the given number is a palindrome
 */
public class Palindrome {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//Reading the number:
		System.out.println("Enter the number:");
		int num = s.nextInt();
		
		int n = num,x=0,rem;
		
		while(n>0)
		{
			rem = n%10; 	//rem stores the remainder (last digit of n)
			x= x*10+rem;	//reversing the number and storing it in x
			n=n/10;
		}
		
		//Using ternary operator to compare original number(num) and reversed number(x)
		
		System.out.println(x==num?"The number is a palindrome":"Not a palindrome");
		
	}

}