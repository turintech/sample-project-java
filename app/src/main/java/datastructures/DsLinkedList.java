package datastructures;
import java.util.ArrayList;
import java.util.Collections;

import java.util.LinkedList;

public class DsLinkedList {
  /**
   * Shuffles a linked list into a new list
   *
   * @param l the linked list to be shuffled
   * @return the shuffled linked list
   */
  public static LinkedList<Integer> shuffle(LinkedList<Integer> l) {
    // To shuffle a LinkedList efficiently, it's best to convert it to an ArrayList first.
    // LinkedList provides O(N) access for get(index) operations, which would make
    // Collections.shuffle (which uses random access) an O(N^2) operation if applied directly.
    // By converting to ArrayList (O(N) time, O(N) space), Collections.shuffle becomes O(N) time.
    ArrayList<Integer> tmp = new ArrayList<>(l);
    
    // Shuffles the ArrayList in-place. This is an O(N) operation.
    Collections.shuffle(tmp);
    
    // Creates a new LinkedList from the shuffled ArrayList. This is an O(N) operation
    // as it iterates through the ArrayList to add elements to the new LinkedList.
    // A new list is required per the method's purpose.
    return new LinkedList<>(tmp);
  }

  /**
   * Returns a slice of a linked list
   *
   * @param l     the linked list to be sliced
   * @param start the starting index of the slice
   * @param end   the ending index of the slice (exclusive)
   * @return the sliced linked list
   */
  public static LinkedList<Integer> slice(LinkedList<Integer> l, int start,
      int end) {
    // The subList method of LinkedList returns a List view of the specified portion.
    // This view creation is O(1).
    // The constructor new LinkedList<>(Collection c) then iterates through this view
    // and copies elements into a new LinkedList. For LinkedList.subList(),
    // its iterator is efficient (O(1) for subsequent elements after an initial seek).
    // The total time complexity for this operation is O(start + K), where K is the
    // length of the slice (end - start). In the worst case (start close to N),
    // this is O(N). Memory usage is O(K) for the new list, which is optimal as a new list
    // containing K elements must be returned.
    return new LinkedList<>(l.subList(start, end));
  }
}