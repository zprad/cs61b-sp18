public class LinkedListDeque<Horse> {

    private IntNode sentNode;
    private int size;

    private class IntNode {
        private IntNode prev;
        private Horse item;
        private IntNode next;

        public IntNode(Horse i, IntNode p, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentNode = new IntNode(null, null, null);
        sentNode.prev = sentNode;
        sentNode.next = sentNode;
    }

    public LinkedListDeque(Horse x) {
        size = 1;
        sentNode = new IntNode(null, null, null);
        IntNode node = new IntNode(x, sentNode, sentNode);
        sentNode.prev = node;
        sentNode.next = node;
    }

    public void addFirst(Horse x) {
        IntNode node = new IntNode(x, sentNode, sentNode.next);
        sentNode.next = node;
        node.next.prev = node;
        size += 1;
    }

    public void addLast(Horse x) {
        IntNode node = new IntNode(x, sentNode.prev, sentNode);
        sentNode.prev = node;
        node.prev.next = node;
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        IntNode p = sentNode.next;
        while (p.item != null) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    public Horse removeFirst() {
        if (isEmpty()) {
            return null;
        }
        IntNode first = sentNode.next;
        sentNode.next = first.next;
        first.next.prev = sentNode;
        size = size - 1;
        return first.item;
    }

    public Horse removeLast() {
        if (isEmpty()) {
            return null;
        }
        IntNode last = sentNode.prev;
        sentNode.prev = last.prev;
        last.prev.next = sentNode;
        size = size - 1;
        return last.item;
    }

    public Horse get(int i) {
        if (i >= size) {
            return null;
        }
        int index = 0;
        IntNode p = sentNode.next;
        while (i != index) {
            index = index + 1;
            p = p.next;
        }
        return p.item;
    }

    private Horse getRecursiveHelper(int index, IntNode node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

    public Horse getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        getRecursiveHelper(index, sentNode.next);
    }


}
