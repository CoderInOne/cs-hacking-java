package cs.hacking.ds_algo.ds.advanced;

import java.util.List;
import java.util.Random;

/**
 * skip like BST
 *
 * express lane:     10 ------------ 20 ----------- 30
 *                   |               |              |
 * normal lane       10 12 14 18 19  20 21 23 24 25 30
 *
 * https://www.geeksforgeeks.org/skip-list-set-2-insertion/
 * visualize: https://people.ok.ubc.ca/ylucet/DS/SkipList.html
 */
public class SkipList {

    class Node {
        int key;
        List<List<Node>> forward;
        Node(int key, List<List<Node>> forward) {
            this.key = key;
            this.forward = forward;
        }
    }

    private int curLevel;
    private Node header;
    private final static int MAX_LEVEL = 3;
    private final static Random RAND = new Random();

    int randomLevel() {
        return RAND.nextInt(MAX_LEVEL);
    }
    /**
     * Insert(list, searchKey)
     * 1. update[MaxLevel+1], current level, c = header,
     * 2. for i from curLevel to 0:
     * 3.     while c.forward[i] != NULL &&
     * 4.           c.forward[i].key < key
     * 5.               c = c.forward[0]
     * 6.     update[i] = c
     * 7. node = c.forward[0]
     * 8. if node == NULL or node.key != k:
     * 9.     newLevel = randomLevel()
     * 10.    if newLevel > curLevel:
     * 11.        for i is curLevel + 1 to newLevel:
     * 12.            update[i] = header
     * 13.        curLevel = newLevel
     * 14.    newNode = createNode(k, v, newLevel)
     * 15.    for i from 0 to newLevel:
     * 16.        newNode.forward[i] = update[i].forward[i]
     * 17.        update[i].forward[i] = newNode
     */
    public void add(int key) {

    }

    @Override
    public String toString() {
        /**
         * each level && forward list
         */
        return super.toString();
    }
}
