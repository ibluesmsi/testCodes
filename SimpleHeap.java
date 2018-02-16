package syed.example;

public class SimpleHeap {

	class Heap {

		int data[];
		int capacity, count;
		int idx_root;

		private int HEAP_RESIZE_FACTOR = 15;
		private Object mLock = new Object();

		public Heap(int size) {
			this.capacity = size;
			data = new int[size];
		}

		public void resize() {
			synchronized (mLock) {
				int new_data[] = new int[this.capacity + HEAP_RESIZE_FACTOR];
				for (int i = 0; i < this.count; i++)
					new_data[i] = this.data[i];
				data = new_data;
				this.capacity += HEAP_RESIZE_FACTOR;
			}
		}

		public void setData(int a[]) {
			if (a.length > this.capacity) {
				resize();
			}
			for (int i = 0; i < a.length; i++) {
				this.data[i] = a[i];
			}
			this.count = a.length;

		}

		int powerOf(int x, int k) {
			int result = 1;
			for (int i = 0; i < k; i++)
				result *= x;
			// System.out.println("\n "+x+" ^ "+k+" = "+result);
			return result;
		}

		public void dumpHeap() {
			System.out.println("## Heap ## Capacity: " + this.capacity
					+ " , Size: " + (this.count) + " ####");
			int level = 0;
			StringBuffer log = new StringBuffer();
			log.append("\nLevel is 0\n");
			for (int i = 0; i < this.count; i++) {
				// ToDo
				log.append("i:" + i + ", level:" + level + ", check:"
						+ (powerOf(2, level)) + "\n");
				if ((powerOf(2, level)) <= (i + 1)) {
					level++;
					log.append("Level increased to " + level + "\n");
					System.out.print("\n ::");
				}
				System.out.print(" " + this.data[i]);
			}
			System.out.print("\n");
			// System.out.println(log.toString());
		}

		public void heapify(int inx) {
			int parent = (int) (inx - 1) / 2;
			if (parent <= 0)
				return;
			if (this.data[parent] < this.data[inx]) {
				int tmp = this.data[parent];
				this.data[parent] = this.data[inx];
				this.data[inx] = tmp;
				heapify(parent);
			}
		}

		public void insert(int tmp) {
			if (this.capacity == this.count) {
				resize();
			}
			this.data[this.count] = tmp;
			if (this.count > 1)
				heapify(this.count);
			this.count++;
		}

	}

	public void testHeap() {
		Heap newHeap = new Heap(30);
		int test[] = { 15, 12, 7, 9, 5, 6, 4, 8, 2, 3, 1 };
		newHeap.setData(test);
		//newHeap.resize();

		newHeap.dumpHeap();
		newHeap.insert(10);
		System.out.println("Inserted 10");
		newHeap.dumpHeap();
		
		newHeap.insert(11);
		System.out.println("Inserted 11");
		newHeap.dumpHeap();
	}

	public static void main(String[] args) {
		SimpleHeap simple = new SimpleHeap();
		simple.testHeap();

	}
}
