package syed.example;


class LinkedListS {
	NodeS headNode;
	
	public LinkedListS() {
		//headNode = new NodeS(0);
		headNode = null;
	}
	
	public void addNode(int val) {
		NodeS node, currNode = headNode;
		if(currNode != null) {
			//System.out.print("init : "+currNode.data);
			while(currNode.getNext() != null) {
				currNode = currNode.getNext();
				//System.out.print(" >> "+currNode.data);
			}
			//System.out.print("\n");
			 node = new NodeS(val);
			 currNode.setNext(node);
		} else {
			System.out.print("Adding root node as "+val+"\n");
			headNode = new NodeS(val);
		}
		//System.out.print("Added "+val+" \n");
		
	}

	public void printNodes() {
		// TODO Auto-generated method stub
		NodeS currNode = headNode;
		if(headNode != null) {
			while(currNode.getNext() != null) {
				System.out.print(" : "+currNode.data+ " -->");
				currNode = currNode.getNext();
			}
			System.out.print(" "+currNode.data+" : NULL \n");
		}
	}

	public void remove(int i) {
		// TODO Auto-generated method stub
		NodeS currNode = headNode;
		if(currNode == null) {
			System.out.print("Error. Head node is null\n");
			return;
		}
		if(currNode.data == i) {
			// Data found in first node itself
			if(currNode == headNode) {
				// Only one node totally
				headNode = null;
				System.out.print("Deleted the only node \n");
			}
			else {
				// Reset head node to 2nd element
				headNode = currNode.getNext();
				System.out.print("Deleted First node \n");
			}
			return;
		} 
		while(currNode.getNext() != null) {
			if(currNode.getNext().data == i) {
				currNode.setNext(currNode.getNext().getNext());
			}
			currNode = currNode.getNext();
			if(currNode == null) {
				return;
			}
		}
	}
	
	public NodeS getHead() {
		if(this.headNode != null)
			return headNode;
		return null;
	}
	
	public void setHead(NodeS tmp) {
		this.headNode = tmp;
	}
}

public class SimpleLinkedList {
	
	public static void main(String[] args) {
		LinkedListS list = new LinkedListS();
		
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		for(int i=0; i<10; i++)
			list.addNode(i);
		
		list.printNodes();

		//list = reverseKthNode(list.getHead(), 4/*, list.getHead()*/);
		/*if(list != null)
			list.printNodes();*/
	}



	private static LinkedListS reverseKthNode(NodeS head, int i/*, NodeS head*/) {
		// TODO Auto-generated method stub
		if(i==0) {
			return null;
		}
		reverseKthNode(head.next, --i);
		return null;
	}
	
	
}
