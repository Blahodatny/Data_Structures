package list;

public class LinkedList {
    private String data;
    public LinkedList next;

    private static boolean isInValid(String e) {
        try {
            if (Integer.parseInt(e) <= 0) return true;
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }

    public LinkedList() {
        data = "1";
        next = null;
    }

    private LinkedList(String e) {
        if (isInValid(e))
            data = "1";
        else
            data = e;
        next = null;
    }

    private boolean isEmpty() {
        return false;
    }

    public String get() {
        return data;
    }

    public String get(int index) {
        if (index >= this.size() || index < 0) return null;
        else if (index == 0) return data;
        LinkedList head = this;
        int var = 0;
        while (var != index) {
            head = head.next;
            var++;
        }
        return head.data;
    }

    public String set(String e) {
        if (isInValid(e))
            return null;
        String temp = data;
        data = e;
        return temp;
    }

    public String set(int index, String e) {
        if (isInValid(e) || index >= this.size() || index < 0) return null;
        if (this.isEmpty()) {
            if (index == 0) return this.set(e);
            else return null;
        }

        if (index == 0) {
            String temp = data;
            data = e;
            return temp;
        }
        LinkedList head = this;
        int var = 0;
        while (var != index) {
            head = head.next;
            var++;
        }
        String temp = head.data;
        head.data = e;
        return temp;
    }

    public int size() {
        LinkedList head = this;
        int var = 0;
        while (head != null) {
            var++;
            head = head.next;
        }
        return var;
    }

    public boolean add(String e) {
        if (isInValid(e)) return false;
        LinkedList head = this;

        if (head.isEmpty()) {
            head = new LinkedList(e);
            return true;
        }

        while (head.next != null)
            head = head.next;
        head.next = new LinkedList(e);
        return true;
    }

    public boolean add(int index, String e) {
        if (isInValid(e) || index >= this.size() || index < 0) return false;
        if (this.isEmpty()) {
            if (index == 0) return this.add(e);
            else return false;
        }

        if (index == 0) {
            LinkedList node = new LinkedList(this.set(e));
            node.next = this.next;
            this.next = node;
            return true;
        }

        LinkedList head = this;
        LinkedList node = new LinkedList(e);
        int number = 0;
        while (number != index - 1) {
            head = head.next;
            number++;
        }
        node.next = head.next;
        head.next = node;
        return true;
    }

    public String remove(int index) {
        if (index >= this.size() || index < 0) return null;
        String temp = "";
        if (index == 0)
            temp = this.set(this.next.get());

        LinkedList head = this;
        int number = 0;
        while (number != index - 1 && index != 0) {
            head = head.next;
            number++;
        }

        if (index != 0) temp = head.next.data;
        LinkedList node = head.next;
        head.next = node.next;
        node.next = null;
        return temp;
    }

    public boolean remove(String e) {
        LinkedList head = this;
        if (this.data.equals(e)) this.set(this.next.get());
        else {
            assert head.next != null;
            while (!head.next.data.equals(e)) {
                head = head.next;
                if (head.next == null && !head.data.equals(e)) return false;
            }
        }
        LinkedList node = head.next;
        assert head.next != null;
        head.next = head.next.next;
        node.next = null;
        return true;
    }
}