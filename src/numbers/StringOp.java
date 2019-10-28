package numbers;

import java.util.*;

/*
 * Program to convert a String into a number
 */
public class StringOp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String arr = sc.next();
		int digit,number=0,i=0;
		
		//to denote sign of number
		boolean negative=false;
		
		
		//To check if the number starts with + or - (here, i=0)
		if(arr.charAt(i)=='-')
		{
			negative = true;
			i++;
		}
		else if(arr.charAt(i)=='+')
		{
			negative = false;
			i++;
		}
		
		while(i<arr.length())
		{
				digit = arr.charAt(i)-48;
				if(digit>=0 && digit<=9)
					number = number*10+digit;
				else
					break;
			i++;
		}
		if(negative)
			number*=-1;
		
		System.out.println("Number: "+number);
	}

}