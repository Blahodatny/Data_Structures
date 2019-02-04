import java.util.NoSuchElementException;

public class LinkedList<E> {
    transient int size;

    transient Node<E> first;

    transient Node<E> last;

    public LinkedList() {
    }

    public E removeFirst() {
        final var f = first;
        if (f == null)
            throw new NoSuchElementException();
        final var element = f.item;
        final var next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }
}