import node.DLNode;
import node.SLNode;

class Main {
    private static final String fileName = "input.dat";
    private static final String currentDir = System.getProperty("user.dir") + "/linked_list/src/main/resources/";
    private static DLNode firstList = null;

    public static void main(String[] args) {
        FileAssistant fa = new FileAssistant();
        fa.setFileName(currentDir, fileName);

        if (fa.readFile()) {
            System.out.println("Start reading a file: ");
            int number = fa.readNextInt();

            while (number != FileAssistant.ERROR_CODE) {
                System.out.printf("%5d", number);
                DLNode node = createDLNode(number);
                firstList = addNode(firstList, node);
                number = fa.readNextInt();
            }
            System.out.println("\nStop reading a file: \n");

        } else
            System.out.println("Error: file empty, or does't not found, or there are IO errors: \n");

        System.out.println(System.lineSeparator());

        System.out.println("THE FIRST LIST:");
        System.out.printf("Size = %d\n", size(firstList));
        printList(firstList);

        SLNode secondList = createSecondList(firstList);
        System.out.println("\nTHE SECOND LIST:");
        System.out.printf("Size = %d\n", size(secondList));
        printList(secondList);

        System.out.println("\nTHE FIRST LIST:");
        System.out.printf("Size = %d\n", size(firstList));
        printList(firstList);
    }

    private static SLNode createSLNode(int data) {
        SLNode newNode = new SLNode();
        newNode.data = data;
        newNode.next = null;
        return newNode;
    }

    private static DLNode createDLNode(int data) {
        DLNode newNode = new DLNode();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;
        return newNode;
    }

    private static DLNode addNode(DLNode head, DLNode node) {
        if (head == null)
            head = addFirst(head, node);
        else {
            DLNode tail = head;
            if (tail.next != null)
                while (tail.next != null)
                    tail = tail.next;
            addAfter(tail, node);
        }
        return head;
    }

    private static void addAfter(DLNode y, DLNode x) {
        x.next = y.next;
        x.prev = y;
        if (y.next != null)
            y.next.prev = x;
        y.next = x;
    }

    private static DLNode addFirst(DLNode head, DLNode node) {
        if (head != null) {
            head.prev = node;
            node.next = head;
        }
        return node;
    }

    private static SLNode addNode(SLNode head, SLNode node) {
        if (head == null)
            head = node;
        else {
            if (node.data % 2 == 1) {
                SLNode cur = head;
                while (cur.next != null)
                    cur = cur.next;
                cur.next = node;
            } else {
                node.next = head;
                head = node;
            }
        }
        return head;
    }

    private static void printList(SLNode list) {
        System.out.println("My list: ");

        if (list == null)
            System.out.println("The list is empty!");
        else
            while (list != null) {
                System.out.printf("%d ", list.data);
                list = list.next;
            }
    }

    private static void printList(DLNode list) {
        System.out.println("My list: ");

        if (list == null)
            System.out.println("The list is empty!");
        else
            while (list != null) {
                System.out.printf("%d ", list.data);
                list = list.next;
            }
    }

    private static int size(SLNode list) {
        int count = 0;
        while (list != null) {
            count++;
            list = list.next;
        }
        return count;
    }

    private static int size(DLNode list) {
        int count = 0;
        while (list != null) {
            count++;
            list = list.next;
        }
        return count;
    }

    private static SLNode createSecondList(DLNode dlHead) {
        SLNode firstList = null;
        if (dlHead == null)
            System.out.println("The list is empty!");
        else {
            DLNode cur = dlHead;
            while (cur != null) {
                if (cur.data >= -5 && cur.data <= 5) {
                    SLNode node = createSLNode(cur.data);
                    firstList = addNode(firstList, node);
                    dlHead = deleteNode(dlHead, cur);
                }
                cur = cur.next;
            }
        }
        Main.firstList = dlHead;
        return firstList;
    }

    private static DLNode deleteNode(DLNode dlHead, DLNode cur) {
        if (cur.prev != null)
            cur.prev.next = cur.next;
        else
            dlHead = dlHead.next;
        if (cur.next != null)
            cur.next.prev = cur.prev;
        return dlHead;
    }
}