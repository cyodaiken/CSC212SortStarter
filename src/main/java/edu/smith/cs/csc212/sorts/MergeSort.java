package edu.smith.cs.csc212.sorts;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.errors.TODOErr;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {

	/**
	 * This method walks through two sorted input lists and creates an output list that contains all elements from the two inputs.
	 * @param lhs - a sorted list.
	 * @param rhs  - a sorted list.
	 * @return a sorted list containing all of the items from lhs and rhs.
	 */
	public static ListADT<Integer> combineTwoSortedLists(ListADT<Integer> lhs, ListADT<Integer> rhs) {
		ListADT<Integer> output = new JavaList<>();
		int i = 0;
		int j = 0;
		int originalLHSSize = lhs.size();
		int originalRHSSize = rhs.size();

		while((i < originalLHSSize) && (j < originalRHSSize)) {

			if(lhs.getFront()< rhs.getFront()) {
				output.addBack(lhs.removeFront());
				i++;
			} else {
				output.addBack(rhs.removeFront());
				j++;
			}
		}
		if(lhs.size() == 0) { 

			for (int k = 0; k < rhs.size(); k++) {
				output.addBack(rhs.getIndex(k));
			}
		}

		if(rhs.size() == 0) { 
			for (int m = 0; m < lhs.size(); m++) {
				output.addBack(lhs.getIndex(m));
			}
		}
		return output;
	}

	/**
	 * Recursively sort this list by breaking it in half and piecing it back together.
	 * You will need to call {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
	 *
	 * @param input - the input list.
	 * @return a new list containing the sorted output.
	 */
	public static ListADT<Integer> doMergeSortRecursively(ListADT<Integer> input) {

		ListADT<Integer> lhs = new JavaList<>();
		ListADT<Integer> rhs = new JavaList<>();
		ListADT<Integer> output = new JavaList<>();

		int start = 0;
		int end = input.size();

		if (input.size() == 1) {
			return input;
		} else {
			int middle = (start + end)/2;
			lhs = input.slice(start, middle);
			rhs = input.slice(middle, end);
			output = combineTwoSortedLists(doMergeSortRecursively(lhs), doMergeSortRecursively(rhs));
		}
		return output;
	}

	/**
	 * Iteratively sort this list by breaking it in half and piecing it back together.
	 * You will need to call {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
	 * 
	 * @param input - the input list.
	 * @return a new list containing the sorted output.
	 */
	public static ListADT<Integer> doMergeSortIteratively(ListADT<Integer> input) {
		ListADT<ListADT<Integer>> work = new JavaList<>();	

		for (int i = 0; i < input.size(); i++) {
			ListADT<Integer> a = new JavaList<>();
			a.addBack(input.getIndex(i));	
			work.addBack(a);
		}

		while(work.size() > 1) {	
			work.addBack(combineTwoSortedLists(work.removeFront(), work.removeFront()));	
		}

		return work.getFront();
	}
}
