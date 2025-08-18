package datastructures;
import java.util.ArrayList;
import java.util.Collections;

import java.util.LinkedList;

public class DsLinkedList {
  /**
   * Shuffles a linked list into a new list.
   *
   * @param l the linked list to be shuffled
   * @param <T> the type of elements in the list
   * @return the shuffled linked list
   */
  public static <T> LinkedList<T> shuffle(LinkedList<T> l) {
    // Create a temporary ArrayList from the LinkedList to leverage Collections.shuffle
    ArrayList<T> tmp = new ArrayList<>(l);
    // Shuffle the ArrayList in place
    Collections.shuffle(tmp);
    // Create and return a new LinkedList from the shuffled ArrayList
    return new LinkedList<>(tmp);
  }

  /**
   * Returns a slice of a linked list as a new linked list.
   *
   * @param l     the linked list to be sliced
   * @param start the starting index of the slice (inclusive)
   * @param end   the ending index of the slice (exclusive)
   * @param <T> the type of elements in the list
   * @return the sliced linked list
   */
  public static <T> LinkedList<T> slice(LinkedList<T> l, int start,
      int end) {
    // Use the subList method to get a view of the specified range,
    // then construct a new LinkedList from this view.
    return new LinkedList<>(l.subList(start, end));
  }
}