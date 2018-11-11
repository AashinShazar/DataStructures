/*
    File Name: ArrayStack.java
    Full Name: Aashin Shazar
 */
package arraystack;

import java.util.Arrays;

/**
 *
 * @author abeer
 */
public class ArrayStack<T> implements StackInterface<T> {

    private T[] stack; // array of stack entries
    private int topIndex; // index of top entry
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
    }

    private void ensureCapacity() {
        if (topIndex == stack.length - 1) // if array is full,
        // double size of array
        {
            stack = Arrays.copyOf(stack, 2 * stack.length);
        }
    } // end ensureCapacity

    @Override
    public void push(T entry) {
        ensureCapacity();
        topIndex++;
        stack[topIndex] = entry;
    }

    @Override
    public T pop() {
        T top = null;
        if (!isEmpty()) {
            top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
        } // end if
        return top;
    }

    @Override
    public T peek() {
        T top = null;
        if (!isEmpty()) {
            top = stack[topIndex];
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }
        
    @Override
    public void removeBatch(int numRemove)
    {
        if (!isEmpty()) //checks if stack is empty before any operation
        {
            
          if (numRemove > topIndex) //checks if user entered integer greater than stack length
          {
             topIndex = -1; //if so, we set the top index to -1
          }
          
          else //else we pop each element using a for loop
          {
            for (int x = 1; x<= numRemove; x++)
            {
                pop();
            } 
          }
        }
    }

}
