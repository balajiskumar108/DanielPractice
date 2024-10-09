package eecs2030.lab4;

import java.util.Comparator;
import java.util.List;

public class Lists {
	private Lists() {} // No objects of this class are desired

	public static <T extends Comparable<? super T>> void defaultSort(List<T> list) {
		list.sort(Comparator.naturalOrder()); // will use a built-in variation of mergesort
		// alternative: Collections.sort(list);
	}

	public static <T extends Comparable<? super T>> void insertionSortRecursive(List<T> list) {
		insertionSortRecursiveHelper(list, list.size());
	}

	private static <T extends Comparable<? super T>> void insertionSortRecursiveHelper(List<T> list, int n) {
		// Base case: if the list is of length 1, it is already sorted
		if (n <= 1) {
			return;
		}

		// Recursively sort the first n-1 elements
		insertionSortRecursiveHelper(list, n - 1);

		// Insert the nth element in the correct position
		T last = list.get(n - 1);
		int j = n - 2;

		// Move elements of list[0..n-1], that are greater than last, to one position ahead
		// of their current position
		while (j >= 0 && list.get(j).compareTo(last) > 0) {
			list.set(j + 1, list.get(j));
			j--;
		}
		list.set(j + 1, last);
	}

	public static <T extends Comparable<? super T>> void insertionSortIterative(List<T> list) {
		for (int i = 1; i < list.size(); i++) {
			T key = list.get(i);
			int j = i - 1;

			// Move elements of list[0..i-1], that are greater than key, to one position ahead
			// of their current position
			while (j >= 0 && list.get(j).compareTo(key) > 0) {
				list.set(j + 1, list.get(j));
				j--;
			}
			list.set(j + 1, key);
		}
	}
}
