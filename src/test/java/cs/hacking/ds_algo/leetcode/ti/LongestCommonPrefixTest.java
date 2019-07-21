package cs.hacking.ds_algo.leetcode.ti;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    @Test
    public void solution() {
        //String[] strings = {"flower", "flow", "flight"};
        String[] strings = {"flower", "flow", "flight"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String r = lcp.solution(strings);
        System.out.println(r);
        System.out.println(r.length());
    }
}