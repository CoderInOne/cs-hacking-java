package cs.hacking.ds_algo.ds.fundamental.hash_table;

public class Java8HashMapRehash {
    public static void main(String[] args) {
        // e.hash & oldCap
        int ha = hash("a");
        System.out.println(ha);
        System.out.println(ha & 4);

        System.out.println("97:" + Integer.toBinaryString(97));
        System.out.println("4:" + Integer.toBinaryString(4));
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
