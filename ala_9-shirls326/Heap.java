import java.util.ArrayList;
/**
    Generic class that implements the data structure Heap
*/
public class Heap<E extends Comparable<E>> {
    // data member: list of the heap nodes
    private ArrayList<E> list;
    public static int iterations;
    /**
        Default constructor to create an empty heap
        Time complexity: O(1)
    */
    public Heap(){
        list = new ArrayList<>();
    }
    /**
        Method to get the size of the heap
        @return the number of nodes in the heap
        Time complexity: O(1)
    */
    public int size(){ 
        return list.size(); 
    }
    /**
        Method to check if the heap is empty
        @return true if the heap is empty, false otherwise
        Time complexity: O(1)
    */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /**
        Method to clear the heap
        Time complexity: O(1)
    */
    public void clear(){
        list.clear(); 
    }
    /**
        Method to get the values stored in the heap as a string
        @return formatted string with the values of all the nodes in the heap
        Time complexity: O(n)
    */
    public String toString(){
        return list.toString();
    }
    /**
        Method to search for a value in the heap
        @param value to be searched in the heap
        @return true if value was found in the heap, false otherwise
        Time complexity: O(n)
    */
    public boolean contains(E value) {
        iterations = 0;
        for(int i=0; i<list.size(); i++) {
            iterations++;
            if(list.get(i).equals(value))
                return true;
        }
        return false;
    }
    /**
        Method to add a new value in the heap
        @param value to be added to the heap
        Time complexity: O(logn)
    */
    public void add(E value) {
        iterations = 0;
        list.add(value);// add value at the end of the list
        int currentIndex = list.size()-1; // index of the added node
        while(currentIndex > 0) {
            iterations++;
            int parentIndex = (currentIndex-1)/2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            if(current.compareTo(parent) > 0) { // need to swap
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            }
            else
                break;
            currentIndex = parentIndex;
        }
    }
    /**
        Method to remove the root node from the heap
        @return the value of the root (the largest value in the heap)
        Time complexity: O(logn)
    */
    public E remove() {
        iterations = 0;
        if(list.size() == 0) 
            return null;
        E removedItem = list.get(0);// value of the root
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            iterations++;
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            if (left >= list.size()) 
                break;
            int maxIndex = left;
            E max = list.get(maxIndex);
            if (right < list.size())
            if(max.compareTo(list.get(right)) < 0)
                maxIndex = right;
            E current = list.get(currentIndex);
            max = list.get(maxIndex);            
            if(current.compareTo(max) < 0){
                list.set(maxIndex, current);
                list.set(currentIndex, max);
                currentIndex = maxIndex;
            }
            else
                break;
        }
        return removedItem;
    }

      /***
     * Method to find height of heap
     * @return height of tree
     * O(n)
     */
    public int height(){
        return height(0);

    }

    //helper recursive method
    /***
     * method to find height of tree
     * helper method of height
     * recursive method
     * @param node
     * @return height of tree
     * Big O: O(n)
     */
    private int height(int nodeIndex){
        // base case
        if(nodeIndex >= list.size()){ // base case
            return 0;
        }
        int LHeight = height(nodeIndex *  2 + 1); // height of the left subtree
        int RHeight = height(nodeIndex * 2 + 2); // height of the right subtree
        int maxHeight = Math.max(LHeight,RHeight);
        return maxHeight + 1;

        
    }


    /***
     * method to tell if tree is balanced
     * @return if tree is balanced
     * O(n^2)
     */
    public boolean isBalanced(){
        return isBalanced(0);
    }

    // recurssive helper method
    /***
     * method to find height of tree
     * helper method
     * recurssive
     * @param node
     * @return if the tree is balanced or not
     * O(n^2)
     */
    private boolean isBalanced(int nodeIndex){

        if(nodeIndex >= list.size()){ // empty tree by definition is balanced
            return true; // base case
        }

        int rHeight = height(nodeIndex * 2 + 2);
        int lHeight = height(nodeIndex * 2 + 1);
        int diff = Math.abs(rHeight - lHeight); // return abs cvalue of dif
        if(diff > 1){
            return false; // tree is NOT balanced base case 2
        }
        return isBalanced(nodeIndex * 2 + 1) && isBalanced(nodeIndex*2 + 2);

    }
}