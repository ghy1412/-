public class Sorts {
	public static void mergeSort(int[] array) {
		mergeSortInternal(array, 0, array.length);
	}

	// [low, high)
	private static void mergeSortInternal(int[] array, int low, int high) {
		if (low + 1 >= high) {
			return;
		}
		
		int mid = (low + high) / 2;
		// [low, mid)
		// [mid, high)
		mergeSortInternal(array, low, mid);
		mergeSortInternal(array, mid, high);
		
		merge(array, low, mid, high);
	}
	
	private static void merge(int[] array, int low, int mid, int high) {
		int length = high - low;
		int[] extra = new int[length];
		
		int iLeft = low;
		int iRight = mid;
		int iExtra = 0;
		
		while (iLeft < mid && iRight < high) {
			if (array[iLeft] <= array[iRight]) {
				extra[iExtra++] = array[iLeft++];
			} else {
				extra[iExtra++] = array[iRight++];
			}
		}
		
		while (iLeft < mid) {
			extra[iExtra++] = array[iLeft++];
		}
		
		while (iRight < high) {
			extra[iExtra++] = array[iRight++];
		}
		
		for (int i = 0; i < length; i++) {
			array[low + i] = extra[i];
		}
	}
	
	
	
	public static void mergeSortNoR(int[] array) {
		for (int i = 1; i < array.length; i *= 2) {
			for (int j = 0; j < array.length; j = j + 2 * i) {
				int low = j;
				int mid = low + i;
				int high = mid + i;
				
				if (mid >= array.length) {
					continue;
				}
				
				if (high > array.length) {
					high = array.length;
				}
				
				merge(array, low, mid, high);
			}
		}
	}
}







