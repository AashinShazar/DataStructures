/*
    File Name: NodeStack.java
    Full Name: Aashin Shazar
 */
package nodestack;

/**
 *
 * @author abeer
 */
public class NodeStack<T> implements StackInterface<T> {

    private Node topNode;

    public NodeStack() {
        topNode = null;
    }

    @Override
    public void push(T entry) {
        Node newNode = new Node(entry, topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        T top = peek();
        if (topNode != null) {
            topNode = topNode.getNext();
        }
        return top;
    }

    @Override
    public T peek() {
        T top = null;
        if (topNode != null) {
            top = topNode.getItem();
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }
    
    public int countOccurrence(T entry)
    {
        int frequency = 0; //frequency of entry
        Node currentNode = topNode; //set currentNode to topNode
        while ((currentNode != null)) { //run while currentNode is not null
            if (entry.equals(currentNode.item)) { //if entry matches item
                frequency++; //increment
            }
            currentNode = currentNode.next;
        } // end while
        return frequency;
    }

    class Node {

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        T item;
        Node next;

        Node(T item) {
            this(item, null);
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return item.toString();
        }

    }
}
