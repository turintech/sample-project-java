package datastructures;

import java.util.LinkedList;
import java.util.Random;

public class DsLinkedList {
  /**
   * Shuffles a linked list into a new list
   *
   * @param l the linked list to be shuffled
   * @return the shuffled linked list
   */
  public static LinkedList<Integer> shuffle(LinkedList<Integer> l) {
    LinkedList<Integer> ret = new LinkedList<Integer>(l);
    Random rand = new Random();
    for (int i = ret.size() - 1; i > 0; i--) {
      int j = rand.nextInt(i + 1);
      int temp = ret.get(i);
      ret.set(i, ret.get(j));
      ret.set(j, temp);
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