package queues;

/*
 * Program to reverse a Queue using recursion
 */
public class ReverseQRec {
	
	static int front = -1, rear = -1,size=50;
	static int[] queue = new int[size];
	
	//Function to check if the queue is empty
	static boolean isEmpty()
	{
		return front==-1;
	}
	
	//Function to check if the queue is full
	static boolean isFull()
	{
		return rear==size-1;
	}
	
	//Function to add an element to the back of the queue
	static void enqueue(int x)
	{
		if(isFull())
		{
			System.out.println("Queue is full!");
			return;
		}
		else
		{
			if(isEmpty())
				front++;
			queue[++rear] = x;
		}
	}
	
	
	//Function to remove an element from the front of queue
	static int dequeue()
	{
		int x=-1;
		if(isEmpty())
			//throw new Exception
			System.out.println("Queue is Empty!");
		else
		{
			x = queue[front];
			if(front==rear)
			{
				front = -1;
				rear = front;
			}
			else
				front++;
		}
		return x;
		
	}
	
	
	//Function to print contents of queue
	static void printqueue()
	{
		int i;
		if(!isEmpty())
		{
			System.out.println();
			for(i=front;i<=rear;i++)
				System.out.print(queue[i]+" ");
		}
	}
	
	//Recursive function to reverse queue
	static void reverse()
	{
		int a;
		if(isEmpty())
			return;
		else
		{	
			a = dequeue();
			reverse(); 
			enqueue(a);
		}
	}
	
	public static void main(String[] args) {
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		enqueue(5);
		
		System.out.print("Initially:");
		printqueue();
		
		reverse();
		
		System.out.print("\nAfter reversing:");
		printqueue();
		
		
	}

}