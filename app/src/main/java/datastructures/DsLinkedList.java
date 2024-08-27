package datastructures;

import java.util.LinkedList;

public class DsLinkedList {
  /**
   * Shuffles a linked list into a new list
   *
   * @param l the linked list to be shuffled
   * @return the shuffled linked list
   */
  public static LinkedList<Integer> shuffle(LinkedList<Integer> l) {
    LinkedList<Integer> tmp = new LinkedList<Integer>(l);
    LinkedList<Integer> ret = new LinkedList<Integer>();
    while (tmp.size() > 0) {
      int index = (int) (Math.random() * tmp.size());
      ret.add(tmp.get(index));
      tmp.remove(index);
    }
    return ret;
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
    LinkedList<Integer> ret = new LinkedList<Integer>();
    for (int i = start; i < end; i++) {
      ret.add(l.get(i));
    }
    return ret;
  }
}
