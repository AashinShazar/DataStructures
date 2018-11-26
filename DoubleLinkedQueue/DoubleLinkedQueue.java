/**
 * Modifed by: Aashin Shazar
 * File name: DoubleLinkedQueue.java
 */
package linkednodesqueue;

/**
 *
 * @author abeer
 */
public class DoubleLinkedQueue<T> implements QueueInterface<T> {

    private Node firstNode; // references node at front of queue
    private Node lastNode; // references node at back of queue

    public DoubleLinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null, null);
        
        if (lastNode != null){
            newNode.previous = lastNode;
            lastNode.next = newNode;
        }
        
        lastNode = newNode;
        
        if (firstNode == null){
            firstNode = lastNode;
        }
    }

    
    @Override
    public T dequeue() {
        Node originalFirst = firstNode;
        
        if (!isEmpty()){
            firstNode = firstNode.next;
            
            if (firstNode == null){
                lastNode = null;
            }
            else {
                firstNode.previous = null;
            }
        }
        return originalFirst.item;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getItem();
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
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
        
        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        T item;
        Node next;
        Node previous;

        Node(T item) {
            this(item, null);
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
              
        Node(T item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

        @Override
        public String toString() {
            return item.toString();
        }

    }
}
