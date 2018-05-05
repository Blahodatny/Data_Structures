package list;

class SLNode {
    int data;
    SLNode next;

    SLNode(int data) {
        this.data = data;
        next = null;
    }

    SLNode(int data, SLNode next) {
        this.data = data;
        this.next = next;
    }
}