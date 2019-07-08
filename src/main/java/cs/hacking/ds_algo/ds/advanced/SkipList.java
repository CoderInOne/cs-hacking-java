package cs.hacking.ds_algo.ds.advanced;

import java.util.Random;

/**
 * skip like BST
 * <p>
 * express lane:     10 ------------ 20 ----------- 30
 *                   |               |              |
 * normal lane       10 12 14 18 19  20 21 23 24 25 30
 * <p>
 * https://www.geeksforgeeks.org/skip-list-set-2-insertion/
 * visualize: https://people.ok.ubc.ca/ylucet/DS/SkipList.html
 *
 * hard to test and verify
 */
public class SkipList {

    class Node {
        int key;
        Node[] forward;

        Node(int key, int level) {
            this.key = key;
            this.forward = new Node[level + 1];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }
    }

    private int curLevel;
    private Node header;
    private final static int MAX_LEVEL = 3;
    private final static Random RAND = new Random();
    private float p;

    public SkipList(float p) {
        // level=MAX_LEVEL: because header can forward to each level
        this.header = new Node(-1, MAX_LEVEL);
        this.p = p;
    }

    // Visible for testing
    void setCurLevel(int l) {
        this.curLevel = l;
    }

    // shape of skip list determined by random distribution
    int randomLevel() {
        // return RAND.nextInt(MAX_LEVEL);
        int l = 0;
        while (RAND.nextFloat() < p & l < MAX_LEVEL) {
            l++;
        }
        return l;
    }

    public void delete(int key) {
        Node[] update = new Node[MAX_LEVEL+1];
        Node x = header;
        for (int i = curLevel; i >= 0; i--) {
            while (x != null && x.forward[i].key < key) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = x.forward[0];
        if (x.key == key) {
            for (int i = 0; i <= curLevel; i++) {
                if (update[i] != null && update[i].forward[i] != x) {
                    break;
                }
                update[i].forward[i] = x.forward[i];
            }
            x = null; // help GC

            // higher level, element distributed sparser
            // so we reduce level from top to bottom
            while (curLevel > 0 && header.forward[curLevel] == null) {
                curLevel -= 1;
            }
        }
    }

    public boolean search(int key) {
        Node n = searchKey(key);
        return n.key == key;
    }

    private Node searchKey(int key) {
        Node n = header;
        for (int i = curLevel; i >= 0; i--) {
            if (n.forward != null && n.forward[i].key < key) {
                n = n.forward[i];
            }
        }

        n = n.forward[0];
        return n;
    }

    public void add(int key) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node current = header;
        for (int i = curLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];

        if (current == null || current.key != key) {
            int newLevel = randomLevel();

            if (newLevel > curLevel) {
                for (int i = curLevel + 1; i <= newLevel; i++) {
                    update[i] = header;
                }
                curLevel = newLevel;
            }

            Node newNode = new Node(key, newLevel);

            /*
             * update old forward think about this:
             * 6 ------> 4
             * change to:
             * 6 ---> 5 ---> 4
             * update is path to inserted node, so we should update it
             * when node inserted, same as linked list ptr update
             */
            for (int i = 0; i <= newLevel; i++) {
                // we create connection upper until newLevel
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    @Override
    public String toString() {
        /**
         * each level && forward list
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= curLevel; i++) {
            Node n = header.forward[i];
            sb.append("Level ").append(i).append(":");
            while (n != null) {
                sb.append(n.key).append(" ");
                n = n.forward[i];
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
