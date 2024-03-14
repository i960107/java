package chapter13;

public interface List {
    void add();

    void update(int index, Object value);

    void remove(int index);

    Object get(int intdex);

    void size();

    Object[] getAll();
}
