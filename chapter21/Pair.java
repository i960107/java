package chapter21;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean isKeyEqualTo(K key) {
        return this.key.equals(key);
    }

    public V getValue() {
        return value;
    }
}
