package stacks;

/*
 * User defined Stack class:
 	* With normal functions - push(), pop(), peek()
 	* and Additional functions - isFull(), isEmpty(), size() and displayStack()  
 */
public class MyStack {

	int len,top=-1;
	int[] stack;
	String name; //Additional variable to give a name to the stack
	
	/*
	 *  Parameterized constructor for myStack
	 *  n: name of the stack
	 *  l: length of the stack
	 */
	public MyStack(String n, int l)
	{
		name = n;
		len = l;
		stack = new int[len];
	}
	
	/*
	 * Non parameterized constructor for MyStack
	 */
	public MyStack()
	{
		name = " ";
		len = 50;
		stack = new int[len];
	}
	
	/*
	 * Function to return the number of elements in stack
	 */
	int size()
	{
		if(top==-1)
			return 0;
		else 
			return top+1;
	}
	
	/*
	 * Function to display contents of the stack
	 */
	String displayStack()
	{
		String result = "[";
		if(!isEmpty())
		{
			for(int i=0;i<=top;i++)
			{
				result= result+stack[i]+" ";
			}
		}
		return result+"]";
	}
	
	/* Stack function: PUSH 
	 * Insert element at top of stack
	 */
	void push(int x)
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
	int pop()
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
	int peek()
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
	boolean isFull()
	{
		return top==len-1;
	}
	
	/*
	 * Function to check if the stack is empty
	 */
	boolean isEmpty()
	{
		return top==-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}