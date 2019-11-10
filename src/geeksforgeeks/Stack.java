package geeksforgeeks;

public class Stack {

	int size,top=-1;
	int[] stack;
	
	public Stack()
	{
		size = 50;
		stack = new int[size];
	}
	
	public Stack(int s)
	{
		size = s;
		stack = new int[size];
	}
	
	void push(int x)
	{
		if(size<=2 || top==size-2)
			increaseSize();
		stack[++top] = x;
	}
	
	void increaseSize()
	{
		size*=2;
		int newstack[] = new int[size];
		for(int i=0;i<=top;i++)
			newstack[i] = stack[i];
		stack = newstack;
	}
	
	int pop() throws Exception
	{
		if(top==-1)
			throw new Exception("Error! Stack empty");
		else
			return stack[top--];
	}
	
	int peek() throws Exception
	{
		if(top==-1)
			throw new Exception("Error! Stack empty");
		else
			return stack[top];
	}
	
	void printStack()
	{
		if(top==-1)
			return;
		for(int i=0;i<top;i++)
			System.out.print(stack[i]+" ");
		System.out.println();
	}
	
	boolean isEmpty()
	{
		return top==-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
