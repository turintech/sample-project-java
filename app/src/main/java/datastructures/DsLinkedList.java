package datastructures;
import java.util.Random;

import java.util.LinkedList;

public class DsLinkedList {
  /**
   * Shuffles a linked list into a new list
   *
   * @param l the linked list to be shuffled
   * @return the shuffled linked list
   */
  public static LinkedList<Integer> shuffle(LinkedList<Integer> l) {
    LinkedList<Integer> ret = new LinkedList<Integer>();
    Random rand = new Random();
    while (!l.isEmpty()) {
      int index = rand.nextInt(l.size());
      ret.add(l.remove(index));
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
    return new LinkedList<>(l.subList(start, end));
  }
}