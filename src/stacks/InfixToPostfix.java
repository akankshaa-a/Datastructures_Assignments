package stacks;

import java.util.*;

/**
 * Program to convert an infix expression to post-fix expression
 * using a stack
 */
public class InfixToPostfix {
	
	static int len=50,top=-1;
	static char[] stack = new char[len];
	
	/* Stack function: PUSH 
	 * Insert element at top of stack
	 */
	static void push(char x)
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
	static char pop()
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
	static char peek()
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
	
	
	/*
	 * Function to check if c is an operator or operand
	 */
	static int operator(char c)
	{
		//Arithmetic operators - return 1
		if( c=='+'|| c=='-' || c=='*' || c=='/' || c=='^' )
			return 1;
		
		//Opening braces - return 2
		else if( c=='(' || c=='{' || c=='[' )
			return 2;
		
		//Closing Braces - return 3
		else if( c==')' || c==']' || c=='}' )
			return 3;
		
		//If it is an operand, return 0
		else
			return 0;
	}
	
	
	/*
	 * Function to denote the precedence of arithmetic operator
	 * according to BODMAS 
	 */
	static int precedence(char c)
	{
		if( c=='+' || c=='-') 
			return 1;	//lowest precedence
		else if( c=='*' || c=='/')
			return 2;   //higher precedence
		else
			return 3;	//highest precedence
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//Reading the infix expression:
		System.out.println("Enter the infix expression:");
		String ip = s.next();

		int i=0,n=ip.length();
		char c;
		
		// HashMap to denote Matching Braces
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		map.put('}','{');
		map.put(')','(');
		map.put(']','[');
		
		for(i=0;i<n;i++)
		{
			c = ip.charAt(i);
			switch(operator(c))
			{
				case 1: //Operator (+,-,*,/,^)
			
					if(isEmpty())
						push(c);
					else
					{
						if(operator(peek())==2) //If there's an opening brace at the top of stack
							push(c);
						
						else   //There's another arithmetic operator on top of stack
						{	
							while(!isEmpty() && precedence(c)<=precedence(peek()))
								System.out.print(pop());
							push(c);
						}
					}
					break;
					
				case 2: //Opening braces 
					push(c);
					break;
					
				case 3: //Closing braces
					do
					{
						System.out.print(pop());  //pop till you get matching brace
					}while(!isEmpty() && peek()!=map.get(c));
					
					if(peek()==map.get(c)) //We need not print the bracket itself
						pop();
					break;
			
				case 0:  //If its an operand , directly print it 
					System.out.print(c);
					break;
	
			}
		}
			while(!isEmpty())
				System.out.print(pop());

	}

}