package queues;

/*
 * Program to implement a Queue class
 * with standard operations Enqueue, Dequeue
 * and additional functions to print and to reverse the queue
 */
public class Queue {
	
	int front = -1, rear = -1,size;
	int[] queue;
	
	//Parameterized constructor to specify size
	public Queue(int s)
	{
		size = s;
		queue =  new int[s];
	}
	
	//non parameterized constructor
	public Queue()
	{
		size = 50;
		queue = new int[size];
	}
	
	//Function to check if the queue is empty
	boolean isEmpty()
	{
		return front==-1;
	}
	
	//Function to check if the queue is full
	boolean isFull()
	{
		return rear==size-1;
	}
	
	//Function to add an element to the back of the queue
	void enqueue(int x)
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
	int dequeue()
	{
		int x=-999999;
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
	void printqueue()
	{
		int i;
		if(!isEmpty())
		{
			for(i=front;i<=rear;i++)
				System.out.print(queue[i]+" ");
			System.out.println();

		}
	}
	
	//Recursive function to reverse queue
	void reverse()
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
	
	}

}