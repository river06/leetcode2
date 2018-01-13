import java.util.ArrayList;

class HashNode<K, V> {
	K key;
	V value;

	// Reference to the next node
	HashNode<K, V> next;

	// constructor
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class Map<K, V> {
	// array of chains
	private ArrayList<HashNode<K, V>> bucketArray;

	// current capacity of array list
	private int numBuckets;

	// current size of array list
	private int size;

	public Map() {
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		for (int i=0; i < numBuckets; i++) {
			bucketArray.add(null);
		}
	}

	public int size() { return size; }
	public boolean isEmpty() { return size() == 0; }

	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;
		return index;
	}

	public V remove(K key) {
		// apply hash function to find index for given key
		int bucketIndex = getBucketIndex(key);

		// Get head of chain
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// search for key in its chain
		HashNode<K, V> prev = null;
		while (head != null) {
			if (head.key.equals(key)) {
				break;
			} 

			prev = head;
			head = head.next;
		}

		// if key was not found
		if (head == null) { return null; }

		// reduce size
		size--;

		// remove key
		if (prev != null) {
			prev.next = head.next;
		} else {
			bucketArray.set(bucketIndex, head.next);
		}

		return head.value;
	}

	// returns value for a key
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// search key in chain
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}

		return null;
	}

	public void add(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// insert key in chain
		size++;
		head = bucketArray.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);
		
		// if load factor goes beyond threshold, double hash table size
		if ((1.0*size)/numBuckets >= 0.7) {
			ArrayList<HashNode<K, V>> temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = 2 * numBuckets;
			size = 0;
			for (int i=0; i < numBuckets; i++) {
				bucketArray.add(null);
			}

			for (HashNode<K, V> headNode: temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

	// Driver method to test Map class
    public static void main(String[] args)
    {
        Map<String, Integer>map = new Map<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
