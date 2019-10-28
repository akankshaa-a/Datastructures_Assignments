package queues;

/*
 * Program to implement the PUSH, POP and PEEK
 * stack operations using queues
 */
public class StackWithQueue {

	Queue queue = new Queue();
	
	/*
	 *  Function to push element
	 *  at the top of stack
	 */
	void push(int x)
	{
		queue.enqueue(x);
	}
	
	/*
	 * Function to remove element
	 * from top of stack
	 */
	int pop()
	{
		if(queue.isEmpty())
		{
			System.out.println("Stack is empty");
			return -99999;
		}
		queue.reverse();
		int x = queue.dequeue();
		queue.reverse();
		return x;
		
	}
	
	/*
	 * Function to return element
	 * at top of stack
	 */
	int peek()
	{
		if(queue.isEmpty())
		{
			System.out.println("Stack is empty");
			return -99999;
		}
		queue.reverse();
		int x = queue.dequeue();
		queue.reverse();
		queue.enqueue(x);
		return x;
		
	}
	
	/*
	 * Function to print stack contents
	 * left--->right = top_element ---> bottom_element
	 */
	void printstack()
	{
		queue.printqueue();
	}
	
	public static void main(String[] args) {
		//creating stack object
		StackWithQueue stack = new StackWithQueue();
		
		//pushing elements to stack
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		//displaying stack contents
		stack.printstack();
		System.out.println("Top element:"+ stack.peek());
		
		//popping element from stack
		stack.pop();
		
		//displaying stack contents
		stack.printstack();
		System.out.println("Top element:"+ stack.peek());
	}

}