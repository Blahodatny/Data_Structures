package list;

public class DoublyLinkedList {
    private DLNode first;
    private DLNode last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void add(int data) {
        DLNode node = new DLNode(data);
        if (first == null)
            first = node;
        else {
            node.setPrev(last);
            last.setNext(node);
        }
        last = node;
    }

    public boolean add(int index, int data) {
        if (index >= this.size() || index < 0)
            return false;

        DLNode node = new DLNode(data);
        int i = 0;
        DLNode cur = first;
        while (i < index) {
            cur = cur.getNext();
            i++;
        }

        node.setNext(cur);
        node.setPrev(cur.getPrev());

        if (i == 0)
            first = node;
        else
            cur.getPrev().setNext(node);
        cur.setPrev(node);

        return true;
    }

    public int removeAt(int index) {
        if (index >= this.size() || index < 0) return 0;

        int retVal;
        if (index == 0) {
            retVal = first.getData();
            first.getNext().setPrev(null);
            first = first.getNext();

        } else if (index == this.size() - 1) {
            retVal = last.getData();
            last.getPrev().setNext(null);
            last = last.getPrev();

        } else {
            int i = 0;
            DLNode cur = first;
            while (i < index) {
                cur = cur.getNext();
                i++;
            }
            retVal = cur.getData();
            cur.getNext().setPrev(cur.getPrev());
            cur.getPrev().setNext(cur.getNext());
        }
        return retVal;
    }

    public boolean remove(int data) {
        DLNode cur = first;
        while (cur != null && cur.getData() != data)
            cur = cur.getNext();

        if (cur == null) return false;
        else {
            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
            return true;
        }
    }

    public int get(int index) {
        if (index >= size() || index < 0) return 0;

        int i = 0;
        DLNode cur = first;
        while (i < index) {
            cur = cur.getNext();
            i++;
        }
        return cur.getData();
    }

    public int set(int index, int data) {
        if (index >= size() || index < 0) return 0;
        int i = 0;
        DLNode cur = first;
        while (i < index) {
            cur = cur.getNext();
            i++;
        }
        cur.setData(data);
        return data;
    }


    public int size() {
        int size = 0;
        DLNode cur = first;
        while (cur != null) {
            cur = cur.getNext();
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        DLNode cur = first;
        while (cur != null) {
            res.append(cur.getData()).append(" ");
            cur = cur.getNext();
        }
        return res.toString();
    }

    public int[] toArray() {
        int[] arr = new int[size()];
        int i = 0;
        DLNode cur = first;
        while (cur != null) {
            arr[i] = cur.getData();
            cur = cur.getNext();
            i++;
        }
        return arr;
    }
}