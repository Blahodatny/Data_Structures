package list;

class DLNode {
    private int data;
    private DLNode next;
    private DLNode prev;

    DLNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    int getData() {
        return data;
    }

    void setData(int data) {
        this.data = data;
    }

    DLNode getNext() {
        return next;
    }

    void setNext(DLNode next) {
        this.next = next;
    }

    DLNode getPrev() {
        return prev;
    }

    void setPrev(DLNode prev) {
        this.prev = prev;
    }
}