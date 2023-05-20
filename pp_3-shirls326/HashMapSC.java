import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Hashtable;

/**
	Class that implements a hashtable of Hashmap entries with two generic types
	K for key
	V for value
 */
public class HashMapSC <K, V> {
	// data member: number of elements added to the hashmap
	private int size;
	// data member: load factor at which rehashing is required
	private double loadFactor;
	// data member: Array of linked lists
	private LinkedList<HashMapEntry<K,V>>[] hashTable;
	public static int iterations;
	public static int collisions = 0;
	/**
		Default constructor
		Creates a hashmap with capacity 100 and load factor 0.9
		time complexity: O(1)
	 */
	public HashMapSC() {
		this(100, 0.9);
	}
	/**
		Constructor with one parameter
		Creates a hashmap with capacity c and default load factor 0.9
		@param c the capacity of the hashtable
		time complexity: O(logn)
	 */
	public HashMapSC(int c) {
		this(c, 0.9);
	}
	/**
		Constructor with two parameters
		@param c the capacity of the hashtable
		@param lf the load factor for the hashtable
		time complexity: O(logn)
	 */
	public HashMapSC(int c, double lf) {
		hashTable = new LinkedList[trimToPowerOf2(c)];
		loadFactor = lf;
		size = 0;
	}
    /**
		Method trimToPowerOf2 to create a hashtable with a size that is
		the closest power of two to c
		@param c the capacity intended for the hashtable
		@return the closet power of 2 to c 
		time complexity: O(logn)
	 */
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity  = capacity << 1; // * 2
		return capacity;
	}
	/**
		The hash function
		@param the hash code of the key
		@return a valid index in the hashtable
		time complexity: O(1)
	 */
    private int hash(int hashCode) {
		return hashCode & (hashTable.length-1);
	}
    /**
		Method to get the size of the hashtable
		@return the number of elements in the hashtable
		time complexity: O(1)
	 */
	public int size() { 
		return size;
	}
	/**
		Method to clear the hashtable
		time complexity: O(n)
	 */
	public void clear() { 
		size = 0;
		for(int i=0; i<hashTable.length; i++)
			if(hashTable[i] != null)
				hashTable[i].clear();
	}
	/**
		Method to check if the hashtable is empty
		@return true if the hashtable is empty, false otherwise
		time complexity: O(1)
	 */
	public boolean isEmpty() { 
		return (size == 0);
	}

	/**
		Search method
		@param key to be serached
		@return true if key was found, false otherwise
		time complexity: O(1)
	 */
	public boolean containsKey(K key) {
		if(get(key) != null)
			return true;
		return false;
	}
    /**
		Method to get the value of a key
		@param key to be serached
		@return the value of the key if found, null otherwise
		time complexity: O(1)
	 */
	public V get(K key) {
		iterations = 0;
		int HTIndex = hash(key.hashCode());
		if(hashTable[HTIndex] != null) {
			LinkedList<HashMapEntry<K,V>> ll = hashTable[HTIndex];
			for(HashMapEntry<K,V> entry: ll) {
				iterations++;
				if(entry.getKey().equals(key))
					return entry.getValue();
			}
		}
		return null;
	}
    /**
		Method to add a pair (key,value) to the hashtable
		@param key to be added
		@param value of the key to be added
		@return old value if the key was found or the new value if key was not found
		time complexity: O(1) without rehash, O(n) with rehash
	 */
    public V put(K key, V value) {
	    if (get(key) != null) { // The key is in the hash map
		    int HTIndex = hash(key.hashCode());
		    LinkedList<HashMapEntry<K,V>> ll;
            ll = hashTable[HTIndex];
		    for(HashMapEntry<K,V> entry: ll) {
			    if(entry.getKey().equals(key)) {
                    V old = entry.getValue();
                    entry.setValue(value); 
                    return old;
			    }
		    }
        }
        // key not in the hash map - check load factor
        if(size >= hashTable.length * loadFactor)
		        rehash();
        int HTIndex = hash(key.hashCode());
        //create a new LL if empty
        if(hashTable[HTIndex] == null){
		    hashTable[HTIndex] = new LinkedList<>();
        } else {
			collisions++;
		}
        hashTable[HTIndex].add(new HashMapEntry<>(key, value));
        size++; 
        return value;
    }
   	/**
		Method to rehash the hashtable
	
		time complexity: (n)
    */
	private void rehash() {
		ArrayList<HashMapEntry<K,V>> list = toList();
		hashTable = new LinkedList[hashTable.length << 1]; // double the length of hashtable
		size = 0;
		for(HashMapEntry<K,V> entry: list) {
			put(entry.getKey(), entry.getValue());
        }
		
	}
   	/**
		Method to return the pairs (key,value) stored in teh hashtable
		@return an array list with all the pairs (key,value)
		time complexity: O(n)
    */
	public ArrayList<HashMapEntry<K,V>> toList(){
		ArrayList<HashMapEntry<K,V>> list = new ArrayList<>();
		for(int i=0; i< hashTable.length; i++) {
			if(hashTable[i]!= null) {
				LinkedList<HashMapEntry<K,V>> ll = hashTable[i];
				for(HashMapEntry<K,V> entry: ll)
					list.add(entry);
			}
		} 
        return list;
	}
    /**
		toString method
		@return formatted string with all the pairs (key,value) in the hashtable
		time complexity: O(n)
	 */
	public String toString() {
		String out = "[";
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null) {
				for(HashMapEntry<K,V> entry: hashTable[i])
					out += entry.toString();
				out += "\n";
			}
		}
		out += "]"; return out;
	}

	//O(nlogn)
	public ArrayList<HashMapEntry<K,V>> sortedKeys(Comparator<K> c) {
		iterations = 0;
		ArrayList<HashMapEntry<K,V>> list = new ArrayList<>();
		iterations++;
		for (LinkedList<HashMapEntry<K,V>> bucket : hashTable) {
			if (bucket != null) {
				for (HashMapEntry<K,V> entry : bucket) {
					list.add(entry);
				}
			}
		}
		mergeSort(list, 0, list.size() - 1, c);
		return list;
	}
	
	//O(nlogn)
	private void mergeSort(ArrayList<HashMapEntry<K,V>> list, int start, int end, Comparator<K> c) {
		if (start < end) {
			iterations++;
			int mid = (start + end) / 2;
			mergeSort(list, start, mid, c);
			mergeSort(list, mid + 1, end, c);
			merge(list, start, mid, end, c);
		}
	}
	
	//O(nlogn)
	private void merge(ArrayList<HashMapEntry<K,V>> list, int start, int mid, int end, Comparator<K> c) {
		ArrayList<HashMapEntry<K,V>> temp = new ArrayList<>();
		int i = start;
		int j = mid + 1;
		while (i <= mid && j <= end) {
			iterations++;
			if (c.compare(list.get(i).getKey(), list.get(j).getKey()) <= 0) {
				temp.add(list.get(i));
				i++;
			} else {
				temp.add(list.get(j));
				j++;
			}
		}
		while (i <= mid) {
			iterations++;
			temp.add(list.get(i));
			i++;
		}
		while (j <= end) {
			iterations++;
			temp.add(list.get(j));
			j++;
		}
		for (int k = start; k <= end; k++) {
			iterations++;
			list.set(k, temp.get(k - start));
		}
	}




}