package queues;

/*
 * Program to implement Circular queue
 *  With an additional variable Count
 *  to count the no. of elements
 */
public class CircularQueue {
	int[] arr;
	int front=-1,rear=-1,count=0,size;
	
	/*
	 * Constructor with size
	 */
	public CircularQueue(int n)
	{
		arr = new int[n];
		size=n;
	}
	
	/*
	 * Default constructor
	 */
	public CircularQueue()
	{
		size=50;
		arr = new int[size];
	}
	
	//Function to add element to queue
	void enqueue(int x)
	{
		if(isFull())
		{
			System.out.println("Queue is Full");
			return;
		}
		else
		{
			rear = (rear+1)%size;
			arr[rear]=x;
			count++;
			if(front==-1)
				front = rear;
		}
	}
	
	//Function to remove element from queue
	int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -99999;
		}
		else
		{
			int val = arr[front];
			count--;
			if(front==rear)
			{
				front = rear= -1;
			}
			else
				front = (front+1)%size;
			return val;
		}
	}
	
	//Function to check is queue is full
	boolean isFull()
	{
		return (rear+1)%size==front;
	}
	
	//Function to check if queue is empty
	boolean isEmpty()
	{
		return front==-1;
	}
	
	//Function to display queue elements
	void printqueue()
	{
		if(isEmpty())
		{
			System.out.println("<Empty>\n");
			return;
		}
		int i;
		for(i=front;i!=rear;i = (i+1)%size)
			System.out.print(arr[i]+" ");
		System.out.println(arr[rear]);
	}
	
	public static void main(String[] args) {
		/*
		CircularQueue cq = new CircularQueue(5);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		cq.enqueue(4);
		cq.enqueue(5);
		cq.printqueue();
		
		cq.dequeue();
		cq.dequeue();
		cq.printqueue();
		
		cq.enqueue(6);
		cq.printqueue();
		*/
		
	}

}