
/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March  28  2023
 * Last Date modified: March 28  2023
 * Purpose of class is to model eneity ArrayList
 */

import java.util.Comparator;
import java.util.Iterator;

public class ArrayList<E> {
  // data members
  private E[] elements;
  private int size;
  public static int containsIter, sortIter, comparatorSortIter;

  // Constructors
  public ArrayList() {
    elements = (E[]) new Object[10];
    size = 0;
  }

  public ArrayList(int capacity) {
    elements = (E[]) new Object[capacity];
    size = 0;
  }

  // Adding an item to the list (2 methods)
  public boolean add(E item) {
    return add(size, item); // adding at the first free index
  }

  // Adding an item to the list at index
  public boolean add(int index, E item) {
    if (index > size || index < 0)
      throw new ArrayIndexOutOfBoundsException();
    ensureCapacity();
    for (int i = size - 1; i >= index; i--) {
      elements[i + 1] = elements[i];
    }
    elements[index] = item;
    size++;
    return true;
  }

  // Getter and Setter
  public E get(int index) {
    checkIndex(index);
    return elements[index];
  }

  public E set(int index, E item) {
    checkIndex(index);
    E oldItem = elements[index];
    elements[index] = item;
    return oldItem;
  }

  // Size of the list
  public int size() {
    return size;
  }

  // Clear the list
  public void clear() {
    size = 0;
  }

  // Check if the list is empty
  public boolean isEmpty() {
    return (size == 0);
  }

  // Removing an object from the list
  public boolean remove(Object o) {
    E item = (E) o; // casting down o to type E
    for (int i = 0; i < size; i++)
      if (elements[i].equals(item)) {
        remove(i);
        return true;
      }
    return false;
  }

  // Removing the item at index from the list
  public E remove(int index) {
    checkIndex(index);
    E item = elements[index];
    for (int i = index; i < size - 1; i++)
      elements[i] = elements[i + 1];
    size--;
    return item;
  }

  // Shrink the list to size
  public void trimToSize() {
    if (size != elements.length) {
      E[] newElements = (E[]) new Object[size];// capacity = size
      for (int i = 0; i < size; i++)
        newElements[i] = elements[i];
      elements = newElements;
    }
  }

  // Grow the list if needed
  private int ensureCapacity() {
    int iterations = 0;
    if (size >= elements.length) {
      int newCap = (int) (elements.length * 1.5);
      E[] newElements = (E[]) new Object[newCap];
      for (int i = 0; i < size; i++) {
        iterations++;
        newElements[i] = elements[i];
      }
      elements = newElements;
    }
    return iterations;
  }

  // Check if the index is valid
  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new ArrayIndexOutOfBoundsException(
          "Index out of bounds. Must be between 0 and " + (size - 1));
  }

  // toString() method
  public String toString() {
    String output = "[";
    for (int i = 0; i < size - 1; i++)
      output += elements[i] + ", ";
    output += elements[size - 1] + "]";
    return output;
  }

  // Iterator for the list
  public Iterator<E> iterator() {
    return new ArrayIterator();
  }

  // Inner class that implements Iterator<E>
  private class ArrayIterator implements Iterator<E> {
    private int current = -1;

    public boolean hasNext() {
      return current < size - 1;
    }

    public E next() {
      return elements[++current];
    }
  }

  // contains method - O(n) // linear seach
  public boolean contains(Object o) { // iterator instead of forloop

    Iterator<E> iter = iterator();
    containsIter = 0;
    while (iter.hasNext()) { // checks if not at the end of list
      containsIter++;
      E object = iter.next();
      if (object.equals(o)) {
        return true;
      }
    }
    return false;
  }

  // sort method
  //O(n^2)
  public void sort() {
    sortIter = 0;
    for (int i = 0; i < size; i++) {
      sortIter++;
      int minIndex = i;
      for (int j = i; j < size; j++) {
        sortIter++;
        Comparable<E> item = (Comparable<E>) elements[j];
        if (item.compareTo(elements[minIndex]) < 0) {
          minIndex = j;
        }
      }
      E temp = elements[i];
      elements[i] = elements[minIndex];
      elements[minIndex] = temp;
    }
  }

  // sort method
  //O(n^2)
  public void sort(Comparator<E> c) {
    comparatorSortIter = 0;
    for (int i = 0; i < size; i++) {
      comparatorSortIter++;
      int minIndex = i;
      for (int j = i; j < size; j++) {
        comparatorSortIter++;
        if (c.compare(elements[j],elements[minIndex]) < 0) {
          minIndex = j;
        }
      }
      E temp = elements[i];
      elements[i] = elements[minIndex];
      elements[minIndex] = temp;
    }
  }

}
