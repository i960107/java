package chapter21;

public class Container<T> {
    private T[] data;
    private static String name;
    private static String age;

    public Container() {
        data = (T[]) (new Object[1]);
    }

    public void add(T data) {
        this.data[0] = data;
    }

    public T get() {
        return this.data[0];
    }

    public static <D> Container<D> emptyContainer() {
        return new Container<D>();
    }
    // 이렇게 사용 불가
//    public <D> D genericGet(){
//        return data;
//    }

}
