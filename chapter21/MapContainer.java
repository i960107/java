package chapter21;

public class MapContainer<K, V> {
    private K key;
    private V value;

    public void set(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        MapContainer<String, String> nameJob = new MapContainer<>();
        nameJob.set("홍길동", "도적");
        String name = nameJob.getKey();
        String job = nameJob.getValue();
        MapContainer<String, Integer> nameAge = new MapContainer<>();
        nameAge.set("홍길동", 35);
        String name2 = nameAge.getKey();
        Integer age = nameAge.getValue();

    }
}
