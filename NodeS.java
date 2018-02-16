package syed.example;

public class NodeS {
	int data;
	NodeS next;

	public NodeS() {
		// TODO Auto-generated constructor stub
		data = 0;
		next = null;
	}

	public NodeS(int value) {
		data = value;
		next = null;
	}

	public NodeS getNext() {
		return next;
	}

	public void setNext(NodeS nextNode) {
		// System.out.print(data +" --> "+nextNode.data+"\n");
		next = nextNode;
	}

	public NodeS cloneNode(NodeS data) {
		NodeS result = new NodeS(data.data);
		NodeS tmpIdx = data.next;
		NodeS resultIdx = result;
		System.out.print("Copying >>>> ");
		while (tmpIdx.next != null) {
			
			System.out.print(tmpIdx.data +" , ");
			resultIdx.next = new NodeS(tmpIdx.data);
			resultIdx = resultIdx.next;
			tmpIdx = tmpIdx.next;
		}
		resultIdx.next = new NodeS(tmpIdx.data);
		return result;

	}

	public NodeS insert(NodeS tmpNode) {
		NodeS nextNode = this;
		if (tmpNode == null)
			return this;
		while (nextNode.next != null)
			nextNode = nextNode.next;
		nextNode.next = tmpNode;
		return nextNode;
	}

	public void printNodes() {
		printNodes(this);
	}

	public static void printNodes(NodeS tmpNode) {
		// TODO Auto-generated method stub
		NodeS currNode = tmpNode;
		if (tmpNode != null) {
			System.out.print("*** " + currNode.data + " -->");
			while (currNode.getNext() != null) {
				currNode = currNode.getNext();
				System.out.print(" : " + currNode.data + " -->");
			}
			System.out.print(" : NULL \n");
		}
	}

}
