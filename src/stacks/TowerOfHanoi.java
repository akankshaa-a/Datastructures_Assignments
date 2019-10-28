package stacks;

import java.util.*;

/*
 * Program to solve Tower of Hanoi Problem
 * Using stacks
 */
public class TowerOfHanoi {
	
	/*
	 * Recursive function to solve tower of Hanoi problem
	 */
	static void toh(int n,MyStack src, MyStack destn, MyStack temp )
	{
		int val;
		if(n==1)
		{
			val = src.pop();
			destn.push(val);
			System.out.println("Move disc "+val+" from rod "+src.name+" to rod "+destn.name);
			return;
		}
		else
		{
			toh(n-1,src,temp,destn);	//Head Recursion
			val = src.pop();
			destn.push(val);
			System.out.println("Move disc "+val+" from rod "+src.name+" to rod "+destn.name);
			toh(n-1,temp,destn,src);	//Tail Recursion
			return;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of discs(n):");
		int n = s.nextInt(); 	//Size of each stack will be n
		
		MyStack s1= new MyStack("A",n);	// MyStack s1 is the Source stack, with the name A
		MyStack s2= new MyStack("B",n);	// MyStack s2 is the Temporary stack, with the name B
		MyStack s3= new MyStack("C",n);	// MyStack s3 is the Destination stack, with the name C
		
		for(int i=n;i>=1;i--)
			s1.push(i);		//Populating the source stack
		
		System.out.println("\nBefore:\n"+s1.name+":"+s1.displayStack());
		System.out.println(s2.name+":"+s2.displayStack());
		System.out.println(s3.name+":"+s3.displayStack());
		
		System.out.println();
		toh(n,s1,s3,s2);
		
		System.out.println("\nAfter:\n"+s1.name+":"+s1.displayStack());
		System.out.println(s2.name+":"+s2.displayStack());
		System.out.println(s3.name+":"+s3.displayStack());
		
	}

}