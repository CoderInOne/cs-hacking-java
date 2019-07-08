package cs.hacking.ds_algo.leetcode.top_interviews;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class KMPTest {

    @Test
    public void matching() {
        Map<String, List<Integer>> testMap = new LinkedHashMap<>();
        testMap.put("ababaca", Collections.singletonList(0));
        testMap.put("1ababaca", Collections.singletonList(1));
        testMap.put("ababaca2", Collections.singletonList(0));
        testMap.put("1ababaca2", Collections.singletonList(1));
        testMap.put("", Collections.emptyList());
        testMap.put("ababac", Collections.emptyList());
        testMap.put("|ababaca,,,|ababaca", Arrays.asList(1, 12));
        testMap.put("|ababaca,,,|ababacaxxx", Arrays.asList(1, 12));

        String pattern = "ababaca";

        for (Map.Entry<String, List<Integer>> e : testMap.entrySet()) {
            assertArrayEquals(String.format("input: %s", e.getKey()),
                    e.getValue().toArray(),
                    new KMP().matching(e.getKey(), pattern).toArray());
        }
    }

    @Test
    public void computeTf() {
        String p = "ababaca";
        KMP kmp = new KMP();
        int[] tf = kmp.computeTf(p);
        System.out.println(Arrays.toString(tf));
    }
}