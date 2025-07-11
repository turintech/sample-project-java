package datastructures;
import java.util.ArrayList;
import java.util.Collections;
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
    // To reduce memory usage and runtime, shuffle in-place using Fisher-Yates shuffle
    // and re-use l if possible.
    if (l == null || l.size() <= 1) return new LinkedList<>(l);

    // Copy original list to an array for fast random access
    int size = l.size();
    Integer[] arr = l.toArray(new Integer[size]);
    Random rnd = new Random();
    for (int i = size - 1; i > 0; i--) {
      int j = rnd.nextInt(i + 1);
      // Swap arr[i] and arr[j]
      Integer temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    // Build the result list directly from the shuffled array
    LinkedList<Integer> shuffled = new LinkedList<>();
    for (Integer num : arr) {
      shuffled.add(num);
    }
    return shuffled;
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
    // To improve efficiency, avoid l.subList() as its addAll may iterate one-by-one on LinkedList
    LinkedList<Integer> res = new LinkedList<>();
    // Use a single pass O(n) approach starting from start until end-1
    int idx = 0;
    for (Integer val : l) {
      if (idx >= start && idx < end) {
        res.add(val);
      }
      if (idx >= end) break;
      idx++;
    }
    return res;
  }
}