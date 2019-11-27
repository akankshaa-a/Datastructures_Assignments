package trees;

/*
 * Program to print the level with the max sum
 */
public class LevelMaxSum {

	Node[] queue = new Node[100];
	int front = -1,rear = -1;
	
	//Function to check if the Queue is empty:
	boolean isEmpty()
	{
		return front==-1;
	}
	
	//Function to add element to queue:
	void enqueue(Node node)
	{
		if(isEmpty())
			front = 0;
		queue[++rear] = node;
	}
	
	//Function to remove element from the queue:
	Node dequeue() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue is empty");
		Node del = queue[front];
		if(rear==front)
		{
			rear = front = -1;
		}
		else
			front++;
		return del;
	}
	
	//Function for level order traversal
	int levelMax(Node root) throws Exception
	{	
		int sum,max,maxlevel = 0,level=0;
		max = root.data;
		sum = 0;
		
		//Adding the root to the queue
		enqueue(root);
		//Adding null to denote end of level
		enqueue(null);
		
		while(!isEmpty())
		{
			Node node = dequeue();
			
			if(node!=null)
			{
				sum += node.data;	//Adding the node data to the current level sum
				if(node.left!=null) enqueue(node.left);
				if(node.right!=null) enqueue(node.right);				
			}
			else //node==null:
			{
				//Updating the max level and max sum value
				if(sum>max)
				{
					max = sum;
					maxlevel = level;
				}
				
				//Breaking out of the loop at the last level
				if(isEmpty())
					break;
				
				//Adding back the null and resetting the sum value:
				enqueue(node);
				sum = 0;
				level++;	//Changing the level
			}
		}
		
		return maxlevel;
	}
	
	public static void main(String[] args) throws Exception{

		//Creating tree: Level 0
		Node root = new Node(8);
		
		//Level 1:
		root.left = new Node(3);
		root.right = new Node(4);
				
		//Level 2:
		root.left.left = new Node(5);
		root.left.right = new Node(7);
		root.right.left = new Node(9);
		root.right.right = new Node(11);
		
		//Level 3:
		root.left.left.left = new Node(12);
		root.right.left.right = new Node(6);
		
		//Level 4:
		root.right.left.right.left = new Node(16);
		
		LevelMaxSum ob = new LevelMaxSum();
		System.out.println("Level with max sum: "+ob.levelMax(root));
	}

}
