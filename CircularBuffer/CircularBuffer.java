/**
 * @author Aashin Shazar
 * File name: CircularBuffer.java
 */
package linkednodesqueue;

/**
 *
 * @author abeer
 */
public class CircularBuffer<T>{

    private Node firstNode; // references node at front of queue
    private Node lastNode; // references node at back of queue
    int bufferCapacity = 10;
    static int currentCapacity = 0;
    
    public CircularBuffer() {
        firstNode = null;
        lastNode = null;
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
        currentCapacity++;   
    }

    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getItem();
            firstNode = firstNode.getNext();
            if (firstNode == null) {
                lastNode = null;
                currentCapacity--;
            }
        } // end if
        
        return front;
    }

    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getItem();
        }
        return front;
    }

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }
    
    public boolean isFull() {
       return currentCapacity == bufferCapacity;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
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
