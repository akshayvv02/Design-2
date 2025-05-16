/*
 * Implements a basic HashMap using separate chaining with linked lists.
 * 1. buckets: array of linked lists to handle collisions.
 * 2. hash(key): computes index using a custom hash function and PRIME bucket size.

 * - put(key, value): hashes the key, searches the corresponding bucket; if key exists, updates the value; otherwise, adds a new node.
 * - get(key): searches the hashed bucket for the key and returns its value; returns -1 if not found.
 * - remove(key): searches the hashed bucket and removes the node if the key matches.
 */
// Time Complexity : O(1) average, O(n) worst-case (if all keys hash to the same bucket) for all functions
// Space Complexity : O(n), where n is the number of keys stored.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No (Explored multiple ways)

class MyHashMap {
    
    int PRIME = 997;
    List<Node>[] buckets;
    int hash(int key) {
        return (31 * key + 17) % PRIME;
    }
    public MyHashMap() {
        buckets = new List[PRIME];
    }
    
    public void put(int key, int value) {
        int hsh = hash(key);
        Node node = new Node(key, value);
        if(buckets[hsh] == null)
            buckets[hsh] = new LinkedList<Node>();
        for(int i = 0;i<buckets[hsh].size();i++){
            if(key == buckets[hsh].get(i).key){
                buckets[hsh].set(i, node);
                return;
                }
        }
        buckets[hsh].add(node);
        //System.out.println("ArrayList: " + buckets[hsh]);
    }
    
    public int get(int key) {
        int hsh = hash(key);
        if(buckets[hsh] == null)
            return -1;
        for(int i = 0;i<buckets[hsh].size();i++){
            if(key == buckets[hsh].get(i).key)
                return buckets[hsh].get(i).value;
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int hsh = hash(key);
        if(buckets[hsh] == null)
            return;
        for(int i = 0;i<buckets[hsh].size();i++){
            if(key == buckets[hsh].get(i).key){
                buckets[hsh].remove(i);
                break;
                }
        }
    }
}

class Node{
    int key;
    int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
