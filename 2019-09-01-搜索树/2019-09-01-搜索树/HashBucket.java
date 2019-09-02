public class HashBucket {
	private static class Entry {
		int key;
		int value;
		Entry next;
	}
	
	private Entry[] array;
	private int size = 0;
	
	HashBucket() {
		array = new Entry[16];
	}
	
	// O(1)
	public int get(int key) {
		int index = key % array.length;
		// 在 array[index] 对应的链表中查找 key 对应的结点
		Entry node = array[index];
		while (node != null) {
			// if (node.key.equals(key)) {
			if (node.key == key) {
				return node.value;
			}
			node = node.next;
		}
		
		return -1;
	}
	
	public int put(int key, int value) {
		int index = key % array.length;
		// 在 array[index] 对应的链表中查找 key 对应的结点
		Entry node = array[index];
		while (node != null) {
			// if (node.key.equals(key)) {
			if (node.key == key) {
				int oldValue = node.value;
				node.value = value;
				return oldValue;
			}
			node = node.next;
		}
		
		size++;
		if (1.0 * size / array.length > 0.75) {
			resize();
		}
		node = new Entry();
		node.key = key;
		node.value = value;
		node.next = array[index];
		array[index] = node;
	}
	
	private void resize() {
		Entry[] newArray = new Entry[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			Entry node = array[i];
			while (node != null) {
				int index = node.key % newArray.length;
				Entry newNode = new Entry();
				newNode.key = node.key;
				newNode.value = node.value;
				newNode.next = newArray[index];
				newArray[index] = newNode;
				node = node.next;
			}
		}
		array = newArray;
	}
}