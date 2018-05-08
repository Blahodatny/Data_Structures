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
        var head = this;
        var var = 0;
        while (var != index) {
            head = head.next;
            var++;
        }
        return head.data;
    }

    public String set(String e) {
        if (isInValid(e))
            return null;
        var temp = data;
        data = e;
        return temp;
    }

    public String set(int index, String e) {
        if (isInValid(e) || index >= this.size() || index < 0) return null;
        if (this.isEmpty())
            return index == 0 ? this.set(e) : null;

        if (index == 0) {
            var temp = data;
            data = e;
            return temp;
        }
        var head = this;
        var var = 0;
        while (var != index) {
            head = head.next;
            var++;
        }
        var temp = head.data;
        head.data = e;
        return temp;
    }

    public int size() {
        var head = this;
        var var = 0;
        while (head != null) {
            var++;
            head = head.next;
        }
        return var;
    }

    public boolean add(String e) {
        if (isInValid(e)) return false;
        var head = this;

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
        if (this.isEmpty())
            return index == 0 && this.add(e);

        if (index == 0) {
            var node = new LinkedList(this.set(e));
            node.next = this.next;
            this.next = node;
            return true;
        }

        var head = this;
        var node = new LinkedList(e);
        var number = 0;
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
        var temp = "";
        if (index == 0)
            temp = this.set(this.next.get());

        var head = this;
        var number = 0;
        while (number != index - 1 && index != 0) {
            head = head.next;
            number++;
        }

        if (index != 0) temp = head.next.data;
        var node = head.next;
        head.next = node.next;
        node.next = null;
        return temp;
    }

    public boolean remove(String e) {
        var head = this;
        if (this.data.equals(e)) this.set(this.next.get());
        else {
            assert head.next != null;
            while (!head.next.data.equals(e)) {
                head = head.next;
                if (head.next == null && !head.data.equals(e)) return false;
            }
        }
        var node = head.next;
        assert head.next != null;
        head.next = head.next.next;
        node.next = null;
        return true;
    }
}