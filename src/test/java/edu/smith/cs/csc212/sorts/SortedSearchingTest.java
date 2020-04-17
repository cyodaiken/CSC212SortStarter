package edu.smith.cs.csc212.sorts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SortedSearchingTest {

	@Test
	public void testLinearSearch() {
		ListADT<Integer> data = new JavaList<>();
		for (int i = 0; i < 100; i++) {
			data.addBack(i);
		}

		for (int i = 0; i < 100; i++) {
			assertEquals("Item " + i + " should be at position " + i, i, SortedSearching.linearSearch(i, data));
		}

		assertEquals(-1, SortedSearching.linearSearch(-100, data));
		assertEquals(-1, SortedSearching.linearSearch(1000, data));
	}

	@Test
	public void testBinarySearchIter() {
		ListADT<Integer> data = new JavaList<>();
		for (int i = 0; i < 100; i++) {
			data.addBack(i);
		}

		for (int i = 0; i < 100; i++) {
			assertEquals("Item " + i + " should be at position " + i, i,
					SortedSearching.binarySearchIterative(i, data));
		}

		assertEquals(-1, SortedSearching.binarySearchIterative(-100, data));
		assertEquals(-1, SortedSearching.binarySearchIterative(1000, data));
	}

	@Test
	public void testBinarySearchRec() {
		ListADT<Integer> data = new JavaList<>();
		for (int i = 0; i < 100; i++) {
			data.addBack(i);
		}

		for (int i = 0; i < 100; i++) {
			assertEquals("Item " + i + " should be at position " + i, i,
					SortedSearching.binarySearchRecursive(i, data));
		}
		
		assertEquals(-1, SortedSearching.binarySearchRecursive(-100, data));
		assertEquals(-1, SortedSearching.binarySearchRecursive(1000, data));
	}
}
