package syed.example;

public class SimpleQuickSort {

	public static void dumpArray(int array[]) {
		System.out.print(" ##");
		for (int ii = 0; ii < array.length; ii++)
			System.out.print(" " + array[ii]);
		System.out.print("\n");
	}

	public static void dumpArray(int array[], int i, int j) {
		System.out.print(" ^^^");
		if (j > (array.length - 1)) {
			System.out.print("j is +" + j + "\n");
			return;
		}
		for (int ii = i; ii <= j; ii++)
			System.out.print(" " + array[ii]);
		System.out.print("\n");
	}

	public static void swap(int array[], int src, int dest) {
		// System.out.println("\nSwap " + src + " -> " + dest);
		int tmp = array[src];
		array[src] = array[dest];
		array[dest] = tmp;
	}

	public static int partition(int array[], int l, int r) {
		int p = array[r];
		int i = l;
		//System.out.print("\n");
		for (int j = l; j <= r - 1; j++) {
			//System.out.print("(" + array[j] + "," + p + "),");
			if (array[j] <= p) {
				//System.out.print("(" + array[i] + "<-->" + array[j] + "),");
				swap(array, i, j);
				i++;
				// dumpArray(array);
			}

		}
		//System.out.print("\n");
		
		//System.out.print("\npartition() i:" + (i) + ", l:" + l+ ", r:" + r);
		swap(array, i, r);
		//dumpArray(array);
		return i;
	}

	public static void quickSort(int array[], int l, int r) {
		// System.out.print("****");
		//dumpArray(array, l, r);
		//System.out.print("l:" + l + ", r:" + r);
		if (l < r) {

			int pivot = partition(array, l, r);
			//System.out.print(", pivot:" + pivot + "\n");
			dumpArray(array);
			quickSort(array, l, pivot - 1);
			quickSort(array, pivot + 1, r);
		} else {
			//System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		int array[] = { 5, 3, 2, 6, 1, 8, 4, 0 };
		int array2[] = { 7, 2, 1, 6, 8, 5, 3, 4 };
		int array3[] = { 6, 5, 3, 1, 8, 7, 2, 4 };
		dumpArray(array2);
		quickSort(array2, 0, array.length - 1);
		System.out.print("After Sort :: ");
		dumpArray(array2);
		
		dumpArray(array);
		quickSort(array, 0, array.length - 1);
		System.out.print("After Sort :: ");
		dumpArray(array);
		
		dumpArray(array3);
		quickSort(array3, 0, array.length - 1);
		System.out.print("After Sort :: ");
		dumpArray(array3);
	}
}
