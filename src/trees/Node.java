package trees;

//Representation of a node in a Binary tree
public class Node {
	int data;
	Node left,right;
	
	//Parameterized constructor for the node
	public Node(int d)
	{
		data = d;
		left = right = null;
	}
}
