/**
 *
 * @author abeer
 * @param <T>
 */

package listelevator;

import java.util.Arrays;

public class ArrayList<T> implements ListInterface<T> {

    private T[] list; // array of list entries
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY); // call next constructor
    } // end default constructor

    public ArrayList(int initialCapacity) {
        numberOfEntries = 0;
// the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity];
        list = tempList;
    } // end constructor

    private void removeGap(int givenPosition) {
        assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;
        for (int index = removedIndex; index < lastIndex; index++) {
            list[index] = list[index + 1];
        }
    } // end removeGap

    @Override
    public void add(T newEntry) {
        ensureCapacity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
    } // end add

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;
        for (int index = lastIndex; index >= newIndex; index--) {
            list[index + 1] = list[index];
        }
    } // end makeRoom

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            ensureCapacity();
            makeRoom(newPosition);
            list[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    } // end add

    @Override
    public T remove(int givenPosition) {
        T result = null; // return value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            result = list[givenPosition - 1]; // get entry to be removed
// move subsequent entries toward entry to be removed,
// unless it is last in list
            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }
            numberOfEntries--;
        } // end if
        return result; // return reference to removed entry, or
// null if either list is empty or givenPosition
// is invalid
    } // end remove

    public T remove() {
        T result = null;
        assert !isEmpty();
        result = list[0];
        for (int i = 1; i < numberOfEntries; i++) {
            list[i - 1] = list[i];
        }
        numberOfEntries--;
        return result;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
// the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        list = tempList;
    } // end clear

    private void ensureCapacity() {
        if (numberOfEntries == list.length) {
            list = Arrays.copyOf(list, 2 * list.length);
        }
    } // end ensureCapacity

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            list[givenPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    } // end replace

    @Override
    public T getEntry(int givenPosition) {
        T result = null; // result to return
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            result = list[givenPosition - 1];
        } // end if
        return result;
    } // end getEntry

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(list[index])) {
                found = true;
            }
        } // end for
        return found;
    } // end contains

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public T[] toArray() {
        // the cast is safe because the new array contains null entries
        //@SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index];
        } // end for
        return result;
    }


}
