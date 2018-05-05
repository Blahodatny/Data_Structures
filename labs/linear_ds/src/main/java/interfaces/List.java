package interfaces;

public interface List {
    boolean add(String e);

    boolean add(int index, String e);

    String remove(int index);

    boolean remove(String e);

    String get(int index);

    String set(int index, String e);

    int size();

    boolean isEmpty();
}