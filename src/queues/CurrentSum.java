package queues;

/*
 * Program to find the smallest sub-array
 * of the given array whose sum is greater than
 * the given number
 * Using queue
 */
public class CurrentSum {

	static 	Queue q = new Queue(100);
	
	//Function to return the sum of elements in the Queue
	static int findSum()
	{
		int i,sum=0;
		if(q.isEmpty())
			return 0;
		for(i=q.front;i<q.rear;i++)
			sum+=q.queue[i];
		return sum;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 4, 45, 6, 0, 19}; 		// Given array
		int reqsum = 51;						//Required number
		int currentsum =0;
		int i=0;
		
		//Window and min-window store the window size
		int window,minwindow=arr.length+1;
		while(i<arr.length)
		{
			
			while(i<arr.length && currentsum<=reqsum)
			{
				q.enqueue(arr[i]);
				i++;
				currentsum = findSum();
				
				///Empty the Queue for numbers that make the sum negative
				if(currentsum<0)
				{
					while(!q.isEmpty())
						q.dequeue();
				}
			}
			
			//Updating the window size
			window = q.rear - q.front +1;
			if(window<minwindow)
				minwindow = window;
			
			/*
			 * Shortening the window size from the left
			 * while the sum is still greater than the given sum
			 */
			while(!q.isEmpty() && currentsum>reqsum)
			{
				q.dequeue();
				currentsum = findSum();

				//Updating the window size
				window = q.rear - q.front +1;
				if(window<minwindow)
					minwindow = window;
			}
		}
		
		System.out.println("Window size = " +minwindow);
	}

}
