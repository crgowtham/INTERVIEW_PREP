package com.gowtham;

class LRUCache {
	// The most imp thing to understand in this problem is that "get","put" both
	// need to be counted as events & we need to
	// use a data structure that maintains an order for these events. Easiest
	// choice is a "LinkedHashMap" as it maintains the
	// order of addition to the map.
	int capacity;
	Map<Integer, Integer> record;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		record = new LinkedHashMap<>();
	}

	// TC: O(1)
	public int get(int key) {
		if (!record.containsKey(key))
			return -1;
		// Since we treat "get()" as an event (as it helps us understand how
		// recently a 'key' was accessed), we need a // 'remove-add' operation
		// on "record" to record the key's order of access.
		Integer val = record.get(key);
		record.remove(key);
		record.put(key, val);
		return val;
	}

	// TC: O(1)
	public void put(int key, int value) {
		// ***The below 'if' is required for the cases of repeating keys.
		// Everytime a key is repeated, the previous value for the
		// key needs to be discarded as it gets outdated. The new "key,value" is
		// required to be added a new entry in "record".
		if (record.containsKey(key))
			record.remove(key);
		if (record.size() == capacity) {
			Iterator itr = record.keySet().iterator();
			if (itr.hasNext()) {
				// Removing the top element of the map (As technically, it
				// appeared before rest of the members of the map.)
				Integer key_toRm = (Integer) itr.next();
				record.remove(key_toRm);
			}
		}
		record.put(key, value); // Added at the record's tail.
	}
}