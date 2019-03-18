import java.util.Scanner;

// Linked List in Java. Written by Joe James.
public class LinkedList {
	Node root;
	int size;

	public LinkedList() {
		root = new Node();
		size = 0;
	}

	// Test code - main function
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		System.out.println("linked list size:" + ll.getSize());
		System.out.println("add element 8");
		ll.add(8);
		System.out.println("linked list size:" + ll.getSize());
		System.out.println("add elements 17,5,10");
		ll.add(17);
		ll.add(5);
		ll.add(10);
		System.out.println("Find element 17:" + ll.find(17).getData());
		ll.remove(5);
		System.out.println("Removed element 5");
		System.out.println("linked list size:" + ll.getSize());
		System.out.println("Find element 5:" + ll.find(5));
		
		System.out.println("Add: 0 Remove: 1 Exit -1");
		Scanner in = new Scanner(System.in);
		int num = -1;
		int element = 0;
		do
		{
			num = in.nextInt();
			element = in.nextInt();
			if (num == 0)
			{
				ll.add(element);
				System.out.println("Added element " + element);
				
			}else if (num == 1)
			{
				ll.remove(element);
				System.out.println("Removed element " + element);
				
			}
			else 
			{
				System.out.println("linked list size:" + ll.getSize());
				System.out.println("Find element:" + element + " " + ll.find(5).getData());
			}
		}
		while (num != -1);
			
			
	}

	public void setSize(int s) {
		this.size = s;
	}

	public int getSize() {
		return this.size;
	}

	public Node add(int data) {
		Node newNode = new Node(data, root);
		this.root = newNode;
		this.size++;
		return newNode;
	}

	public Node find(int data) {
		Node thisNode = this.root;

		while (thisNode != null) {
			if (thisNode.getData() == data)
				return thisNode;
			thisNode = thisNode.getNextNode();
		}
		return null;
	}

	public boolean remove(int data) {
		Node thisNode = this.root;
		Node prevNode = null;
		System.out.println("Re-ordering list after removal:");
		while (thisNode != null) {
			System.out.println(" " + thisNode.getData());
			if (thisNode.getData() == data) {
				if (prevNode != null)
					prevNode.setNextNode(thisNode.getNextNode());
				else
					this.root = null;
				this.setSize(this.getSize() - 1);
				return true;
			}
			prevNode = thisNode;
			thisNode = thisNode.getNextNode();
		}
		return false;
	}

	// Node class
	private class Node {
		private Node nextNode;
		private int data;

		// 0-arg constructor, 1-arg constructor, 2-arg constructor
		private Node() {
		}

		private Node(int val) {
			data = val;
		}

		private Node(int val, Node next) {
			data = val;
			nextNode = next;
		}

		private void setData(int val) {
			this.data = val;
		}

		private int getData() {
			return this.data;
		}

		private void setNextNode(Node n) {
			this.nextNode = n;
		}

		private Node getNextNode() {
			return this.nextNode;
		}
	}
}