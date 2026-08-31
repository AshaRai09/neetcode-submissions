class LRUCache {

   
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }
    public void put(int key, int value) {

        map.put(key, value);
        if (map.size() > capacity) {
            int firstKey = map.keySet().iterator().next();

            map.remove(firstKey);
        }   
    }
}
