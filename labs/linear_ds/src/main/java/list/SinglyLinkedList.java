package list;

public class SinglyLinkedList {

    private final int EMPTY_ITEM = Integer.MAX_VALUE;
    private SLNode head;
    private int size;

    public boolean add(int element) {
        SLNode newNode = new SLNode(element);
        if (isEmpty())
            head = newNode;
        else {
            SLNode node = getNode(size() - 1);
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
        SLNode newNode = new SLNode(element);
        SLNode node = getNode(index - 1);
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
            int toRemove = head.data;
            head = head.next;
            size--;
            return toRemove;
        }
        SLNode node = getNode(index - 1);
        SLNode delNode = node.next;
        node.next = delNode.next;
        size--;
        return delNode.data;
    }

    public boolean remove(int element) {
        if (size() == 0) return false;
        if (head.data == element)
            head = head.next;
        else {
            SLNode cur = head;
            while (cur.next != null && cur.next.data != element)
                cur = cur.next;
            if (cur.next == null) return false;
            SLNode node = cur.next;
            cur.next = node.next;
        }
        size--;
        return true;
    }

    public int get(int index) {
        if (inValidIndex(index))
            return EMPTY_ITEM;
        SLNode node = getNode(index);
        assert node != null;
        return node.data;
    }

    public int set(int index, int element) {
        if (inValidIndex(index))
            return EMPTY_ITEM;
        SLNode node = getNode(index);
        assert node != null;
        int toReturn = node.data;
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
        SLNode cur = head;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur;
    }

    private boolean inValidIndex(int index) {
        return index < 0 || index > size() - 1;
    }
}