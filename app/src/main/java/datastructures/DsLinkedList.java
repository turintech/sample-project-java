package datastructures;
import java.util.ArrayList;
import java.util.Collections;

import java.util.LinkedList;

public class DsLinkedList {
  /**
   * Shuffles a linked list into a new list.
   *
   * <p>This method creates a new shuffled list without modifying the original.
   * The shuffling process involves converting the LinkedList to an ArrayList for
   * efficient shuffling, then converting it back to a new LinkedList.
   *
   * @param <T> the type of elements in the linked list
   * @param l the linked list to be shuffled
   * @return a new linked list with elements from the original list, but in a
   *     shuffled order
   */
  public static <T> LinkedList<T> shuffle(LinkedList<T> l) {
    // Convert to ArrayList for efficient shuffling, as Collections.shuffle
    // performs better on lists that implement RandomAccess (like ArrayList).
    ArrayList<T> tmp = new ArrayList<>(l);
    Collections.shuffle(tmp);
    // Convert back to a new LinkedList.
    return new LinkedList<>(tmp);
  }

  /**
   * Returns a slice of a linked list as a new linked list.
   *
   * <p>This method creates a new list containing elements from the specified
   * {@code start} index (inclusive) up to, but not including, the {@code end}
   * index. The original list remains unchanged.
   *
   * @param <T> the type of elements in the linked list
   * @param l the linked list to be sliced
   * @param start the starting index of the slice (inclusive)
   * @param end the ending index of the slice (exclusive)
   * @return a new linked list representing the specified slice
   * @throws IndexOutOfBoundsException if {@code start} or {@code end} are out
   *     of range ({@code start < 0 || start > end || end > l.size()})
   */
  public static <T> LinkedList<T> slice(LinkedList<T> l, int start,
      int end) {
    // LinkedList.subList returns a List view of the specified range.
    // We then construct a new LinkedList from this view.
    return new LinkedList<>(l.subList(start, end));
  }
}