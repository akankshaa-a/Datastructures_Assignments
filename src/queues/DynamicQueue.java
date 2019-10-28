package queues;

/*
 * Program to implement a queue
 * that increases in size dynamically
 */
public class DynamicQueue {
	static int front=-1, rear = -1, size=5;
	static int[] queue = new int[size];
	
	/*
	 * Function to add element at
	 * the rear end of the queue
	 */
	static void enqueue(int x)
	{
		if(isEmpty())
			front++;
		else if(rear+2==size-1) //Size is doubled when queue is almost full
			increaseSize();
		queue[++rear] = x;
	}
	
	/*
	 * Function to remove element 
	 * from the front end of the queue
	 */
	static int dequeue()
	{
		int val =0;
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -999999;
		}
		else
		{
			val = queue[front];
			if(front==rear)
			{
				front =-1;
				rear = front;
			}
			else
			{
				front++;
			}
		}
		return val;
	}
	
	
	/*
	 * Function to check if queue is empty
	 */
	static boolean isEmpty()
	{
		return front==-1;
	}
	
	
	/*
	 * Function to check if queue is full
	 */
	static boolean isFull()
	{
		return rear==size-1;
	}
	
	/*
	 * Function to double queue capacity
	 */
	static void increaseSize()
	{
		size*=2;
		int[] newqueue = new int[size];
		int i,count=-1;
		for(i=front;i<=rear;i++)
			newqueue[++count]= queue[i];
		queue = newqueue;
		front = 0;
		rear=count;
	}
	
	/*
	 * Function to Display queue contents
	 */
	static void displayQueue()
	{
		int i;
		if(rear==-1)
		{
			System.out.println("<Empty>\n");
			return;
		}
		for(i=front;i<=rear;i++)
			System.out.print(queue[i]+" ");
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		
		System.out.println("Rear = "+rear+ " Size = "+size+"\nQueue:"); //Initially size is 5
		displayQueue();
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		
		//Size is doubled as queue is almost full
		System.out.println("Rear = "+rear+ " Size = "+size+"\nQueue:"); 		
		displayQueue();
		
		
		enqueue(5);
		enqueue(6);
		enqueue(7);
		enqueue(8);
		enqueue(9);
		
		//Size is doubled again as queue is almost full
		System.out.println("Rear = "+rear+ " Size = "+size+"\nQueue:"); 
		displayQueue();
		
		enqueue(10);
		enqueue(11);
		enqueue(12);
		enqueue(13);
		enqueue(14);
		enqueue(15);
		enqueue(16);
		enqueue(17);
		enqueue(18);
		enqueue(19);
		
		//Size is doubled again as queue is almost full	
		System.out.println("Rear = "+rear+ " Size = "+size+"\nQueue:"); 	
		displayQueue();
		

		


	}

}