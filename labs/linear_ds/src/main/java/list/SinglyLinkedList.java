package list;

public class SinglyLinkedList {

    private final int EMPTY_ITEM = Integer.MAX_VALUE;
    private SLNode head;
    private int size;

    public boolean add(int element) {
        var newNode = new SLNode(element);
        if (isEmpty())
            head = newNode;
        else {
            var node = getNode(size() - 1);
            assert node != null;
            node.next = newNode;
        }
        size++;
        return true;
    }

    public boolean add(int index, int element) {
        if (inValidIndex(index))
            return false;
        if (index == 0) {
            head = new SLNode(element, head);
            size++;
            return true;
        }
        var newNode = new SLNode(element);
        var node = getNode(index - 1);
        assert node != null;
        newNode.next = node.next;
        node.next = newNode;
        size++;
        return true;
    }

    public int removeByIndex(int index) {
        if (inValidIndex(index))
            return EMPTY_ITEM;
        if (index == 0) {
            var toRemove = head.data;
            head = head.next;
            size--;
            return toRemove;
        }
        var node = getNode(index - 1);
        assert node != null;
        var delNode = node.next;
        node.next = delNode.next;
        size--;
        return delNode.data;
    }

    public boolean remove(int element) {
        if (size() == 0) return false;
        if (head.data == element)
            head = head.next;
        else {
            var cur = head;
            while (cur.next != null && cur.next.data != element)
                cur = cur.next;
            if (cur.next == null) return false;
            var node = cur.next;
            cur.next = node.next;
        }
        size--;
        return true;
    }

    public int get(int index) {
        if (inValidIndex(index))
            return EMPTY_ITEM;
        var node = getNode(index);
        assert node != null;
        return node.data;
    }

    public int set(int index, int element) {
        if (inValidIndex(index))
            return EMPTY_ITEM;
        var node = getNode(index);
        assert node != null;
        var toReturn = node.data;
        node.data = element;
        return toReturn;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private SLNode getNode(int index) {
        if (inValidIndex(index))
            return null;
        var cur = head;
        for (var i = 0; i < index; i++)
            cur = cur.next;
        return cur;
    }

    private boolean inValidIndex(int index) {
        return index < 0 || index > size() - 1;
    }
}