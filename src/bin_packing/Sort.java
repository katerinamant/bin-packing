package bin_packing;

public class Sort {
	public static MyLinkedList<Integer> sort(MyLinkedList<Integer> ll) {
		// Implementation of MergeSort
		if (ll.headNode() == null | ll.headNode().next() == null) {
			return new MyLinkedList<Integer>(ll.head());
		}

		System.out.println(ll);

		// Split list in half
		LinkedListNode<Integer> curr = ll.headNode();
		for(int i=0; i<ll.size()/2; i++) {
			System.out.println(curr.data() + " data");
			curr = curr.next();
		}
		System.out.println("out");

		MyLinkedList<Integer> ll2 = new MyLinkedList<Integer>(curr.next());
		System.out.println("Curr: " + curr.data() + "|| HeadB: " + curr.next());
		curr.setNext(null);
		ll.overrideSize(ll.size()/2 + 1);
		System.out.println("Curr.next now set to: " + curr.next());

		// Sort Both
		System.out.println("Sorting ll: " + ll);
		System.out.println("And ll2: " + ll2);
		ll = sort(ll);
		ll2 = sort(ll2);

		// Merge Them
		System.out.println("Merging the sorted lists");
		return merge(ll, ll2);
	}

	public static MyLinkedList<Integer> merge(MyLinkedList<Integer> a, MyLinkedList<Integer> b) {
		MyLinkedList<Integer> c = new MyLinkedList<Integer>();

		while (!a.isEmpty() && !b.isEmpty()) {
			if (a.head() > b.head()) {
				c.pushBack(b.popFront());
			} else {
				c.pushBack(a.popFront());
			}
		}

		// Here either A or B is empty
		while (!a.isEmpty()) {
			c.pushBack(a.head());
			a.popFront();
		}

		while (!b.isEmpty()) {
			c.pushBack(b.head());
			b.popFront();
		}

		return c;
	}
}
