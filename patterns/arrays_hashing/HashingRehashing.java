package patterns.arrays_hashing;

import java.util.ArrayList;

class Map<K, V> {

    static class MapNode<K, V> {
        K key; // key of the node
        V value; // value of the node
        MapNode<K, V> next; // pointer to the next node for separate chaining

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // The bucket array where
    // the nodes containing key-value pairs are stored
    ArrayList<MapNode<K, V>> buckets;

    // No of pairs stored
    int size;

    // Size of the bucket array
    int numBuckets;

    // Default load factor threshold
    final double LOAD_FACTOR_THRESHOLD = 0.75;

    public Map() {

        numBuckets = 5;
        buckets = new ArrayList<>();

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }

        System.out.println("HashMap created");
        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + numBuckets);
        System.out.println("Default Load Factor : " + LOAD_FACTOR_THRESHOLD + "\n");
    }

    private int getBucketInd(K key) {

        int hashCode = key.hashCode();

        // Array index = hashCode % numBuckets
        return (hashCode % numBuckets);
    }

    public void insert(K key, V value) {

        // Getting the index at which to insert the key-value pair
        int bucketInd = getBucketInd(key);

        // The first node of the linked list at that index
        MapNode<K, V> head = buckets.get(bucketInd);

        // First, loop through all the nodes present at that index
        // to check if the key is already present

        while (head != null) {

            // If already present, update the value and return

            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Key is not present, insert a new node at the beginning
        MapNode<K, V> newElementNode = new MapNode<>(key, value);

        // The head node at the index
        head = buckets.get(bucketInd);

        // the new node is inserted
        // by making it the head
        // and its next is the previous head

        newElementNode.next = head;

        buckets.set(bucketInd, newElementNode);

        System.out.println("Pair(" + key + ", " + value + ") inserted successfully.\n");

        // Increment size
        // As the bew K-V pair is added to the map
        size++;

        // Load Factor calculated
        double loadFactor = (1.0 * size) / numBuckets;

        System.out.println("Current Load factor = " + loadFactor);

        // If the load factor is > 0.75, rehashing is done
        if (loadFactor > LOAD_FACTOR_THRESHOLD) {
            System.out.println(loadFactor + " is greater than " + LOAD_FACTOR_THRESHOLD);
            System.out.println("Therefore Rehashing will be done.\n");

            // Rehash
            rehash();

            System.out.println("New Size of Map: " + numBuckets + "\n");
        }

        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + numBuckets + "\n");
    }

    private void rehash() {

        System.out.println("\n*** Rehashing started ***\n");

        // the present bucket list is made temporary
        ArrayList<MapNode<K, V>> temp = buckets;

        // New bucket list if double the old size is created
        buckets = new ArrayList<>(2 * numBuckets);

        for (int i = 0; i< 2 * numBuckets; i++) {
            buckets.add(null);
        }

        // Now size is made zero
        // And we loop through all the nodes on old bucket list
        // and insert them into new bucket list
        size = 0;
        numBuckets *= 2;

        for (MapNode<K, V> head : temp) {

            // head of the chain at that index
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }

        System.out.println("*** Rehashing ended ***\n");
    }

    public void printMap()
    {

        // The present bucket list is made temp
        ArrayList<MapNode<K, V> > temp = buckets;

        System.out.println("Current HashMap:");
        // loop through all the nodes and print them
        for (MapNode<K, V> head : temp) {

            // head of the chain at that index
            while (head != null) {
                System.out.println("key = " + head.key + ", val = " + head.value);

                head = head.next;
            }
        }
        System.out.println();
    }

    // Function to get value for a key
    public V getValue(K key) {
        int bucketInd = getBucketInd(key);
        MapNode<K, V> head = buckets.get(bucketInd);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // Key not found
    }
}




public class HashingRehashing {

    public static void main(String[] args) {


        // Creating the map
        Map<Integer, String> map = new Map<>();

        // Inserting key-value pairs
        map.insert(1, "Geeks");
        map.printMap();

        map.insert(2, "forGeeks");
        map.printMap();

        map.insert(3, "A");
        map.printMap();

        map.insert(4, "Computer");
        map.printMap();

        map.insert(5, "Portal");
        map.printMap();

        //Get element from Map
        int key = 4;
        String value = map.getValue(key);
        System.out.println("Value at key "+ key +" is: "+ value);
    }
}

