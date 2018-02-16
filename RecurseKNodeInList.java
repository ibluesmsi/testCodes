package syed.example;

class Result {
	NodeS reverseList, origList;

	Result() {
		reverseList = origList = null;
	}

	Result(NodeS n1, NodeS n2) {
		reverseList = n1;
		origList = n2;
	}
}

public class RecurseKNodeInList {

	public static NodeS insert(NodeS tmpNode, NodeS head) {
		System.out.println("Inserting " + tmpNode.data);
		NodeS nextNode = head;
		if (tmpNode == null)
			return head;
		System.out.print("Head is " + head.data);
		while (nextNode.next != null)
			nextNode = nextNode.next;
		System.out.print(", tail is " + nextNode.data + " \n");
		nextNode.next = tmpNode;
		return head;
	}

	public static NodeS createTmpList(int size) {
		NodeS headNode = new NodeS(0);

		for (int i = 1; i < size; i++) {
			// NodeS tmpNode = new NodeS((int) (Math.random() * 40 - 1));
			NodeS tmpNode = new NodeS(i);
			headNode = insert(tmpNode, headNode);
		}
		return headNode;

	}

	public static void swapNodes(NodeS n1, NodeS n2) {
		NodeS tmp = n1;
		n1 = n2;
		n2 = tmp;
	}

	public static Result reversekNodes(NodeS node, int k) {
		int origCount = k;
		if (k == 0)
			return new Result(node, node.next);
		NodeS secondNode = node.next;
		node.next = null;

		// System.out.print("secondNode: ");
		// NodeS.printNodes(secondNode);
		System.out.println("### :" + node.data);

		Result tmpResult = reversekNodes(secondNode, --k);

		System.out.println("***** \n");
		/*
		 System.out.print("secondNode(before): ");
		 * NodeS.printNodes(secondNode);
		 */
		
		  System.out.print("origList(before): ");
		  NodeS.printNodes(tmpResult.origList);

		if (k != 0) {
			secondNode = tmpResult.origList;
			NodeS tmpNode = secondNode;
			int count = k;
			while (--count != 0 && tmpNode.next != null) {
				System.out.print(" @@ "+tmpNode.data);
				tmpNode = tmpNode.next;
			}
			// System.out.println("@@ "+tmpNode.data);
			System.out.println("Adding "+node.data+" after "+tmpNode.data);
			tmpNode.next = node;
			node.next = tmpResult.reverseList;
			tmpResult.origList = secondNode;
		} else {
			tmpResult.origList = node;
		}

		System.out.print("node: ");
		NodeS.printNodes(node);
		System.out.print("secondNode: ");
		NodeS.printNodes(secondNode);
		System.out.print("\n");
		System.out.print("origList: ");
		NodeS.printNodes(tmpResult.origList);
		return tmpResult;

	}

	public static void main(String[] args) {
		NodeS head = createTmpList(20);
		NodeS.printNodes(head);

		Result result = reversekNodes(head, 5);
		System.out.print("\n\n*** Reversed list");
		NodeS.printNodes(result.origList);
	}
}
