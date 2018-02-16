package syed.example;

import java.util.Arrays;
/* Done */
public class SimpleMergeSort {
	 static void mergeSort(int[] array) {
		int midIndex;
		if(array == null || array.length <= 1)
			return;
		System.out.println("mergeSort for len: "+array.length);
		for(int ii = 0; ii < array.length; ii++)
			System.out.print(" >> "+array[ii]);
		System.out.print("\n");
		midIndex = (int) array.length / 2;
		int[] leftArray = Arrays.copyOfRange(array, 0, midIndex);
		int[] rightArray = Arrays.copyOfRange(array, midIndex, array.length);
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(array, leftArray, rightArray);
	}
	
	 static void merge(int a[], int ai[], int aj[]) {
		System.out.println("merge L:"+ai.length+", R:"+aj.length);
		int total = ai.length + aj.length;
		int i =0, li=0, ri=0;
		while( i < total) { 
			if(li < ai.length && ri < aj.length) {
				a[i++] = (ai[li] <= aj[ri])?ai[li++]:aj[ri++];
				
			} else {
				a[i++] = (li < ai.length)?ai[li++]:aj[ri++];
				
			}
			System.out.println("Added "+a[i-1]+" @ "+(i-1));
		}
	}
	
	public static void main(String[] args) {
		int array[] = { 5,3,2,6,1,8,4,0};
		mergeSort(array);
		System.out.print("After Sort :: ");
		for(int ii = 0; ii < array.length; ii++)
			System.out.print(" ## "+array[ii]);
		System.out.print("\n");
	}
	
	
}
