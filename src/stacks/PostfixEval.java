package stacks;

import java.util.*;

/**
 * Program to evaluate post-fix expression
 * using a stack
 */
public class PostfixEval {

	
	static int len=50,top=-1;
	static double[] stack = new double[len];
	
	/* Stack function: PUSH 
	 * Insert element at top of stack
	 */
	static void push(double x)
	{
		if(!isFull())
			stack[++top]=x;
		else
		{
			System.out.println("Stack is full");
			return;
		}
	}
	

	/* Stack function: POP 
	* Remove and return element at top of stack
	*/
	static double pop()
	{
		if(!isEmpty())
			return stack[top--];
		else
		{
			System.out.println("Stack is empty");
			return 0;
		}
	}
	
	/* Stack function: PEEK 
	 * Return element at top of stack
	 */
	static double peek()
	{
		if(!isEmpty())
			return stack[top];
		else
		{
			System.out.println("Stack is empty");
			return 0;
		}
	}
	
	/*
	 * Function to check if stack is full
	 */
	static boolean isFull()
	{
		return top==len-1;
	}
	
	/*
	 * Function to check if the stack is empty
	 */
	static boolean isEmpty()
	{
		return top==-1;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//Reading the post-fix expression:
		System.out.println("Enter the postfix expression");
		String ip= s.nextLine();
		
		int i=0,n=ip.length();
		double x,y;
		char c;
		int digit,number;
		
		for(i=0;i<n;i++)
		{
			c=ip.charAt(i);
			
			switch(c)
			{

				/*
				   If c is an operator: (+,-,*,/,^)
				 	-> POP the top 2 elements
				 	-> perform the respective operation
				 	-> PUSH the result back into stack
				 */
				case '+':
					y=pop();
					x=pop();
					push(x+y);
					break;
				
				case '-':
					y=pop();
					x=pop();
					push(x>=y?x-y:y-x);
					break;
					
				case '*':
					y=pop();
					x=pop();
					push(x*y);
					break;
					
				case '/':
					y=pop();
					x=pop();
					push(x/y);
					break;
					
				case '^':
					y=pop();
					x=pop();
					push(Math.pow(x,y));
					break;
				
				/*
				 * If c is a space: Ignore it
				 */
				case ' ':
					break;
					
				/*
				 * If c is a number: PUSH the number
				 */
				default:
					number = c-48;
					while(i<ip.length()-1 && ip.charAt(i+1)!=' ')
					{
							i++;
							digit = ip.charAt(i)-48;
							if(digit>=0 && digit<=9)
								number = number*10+digit;
							else
								break;
						
					}
					push(number);
					break;
			}
		}
		
		//Final result is stored in the last element of stack
		System.out.println(pop());
	}

}