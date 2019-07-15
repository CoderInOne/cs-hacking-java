package cs.hacking.ds_algo.leetcode.ti;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.Assert.*;

public class WildMatchingTest {
    private WildMatching wildMatching;
    private Map<String[], Boolean> testMap;

    @Before
    public void setUp() throws Exception {
        wildMatching = new WildMatching();
        testMap = new LinkedHashMap<>();

        // simple case
        testMap.put(new String[]{"ab", "ab"}, true);

        testMap.put(new String[]{"aa", "a"}, false);
        testMap.put(new String[]{"ad", "?c"}, false);

        testMap.put(new String[]{"aa", "*"}, true);
        testMap.put(new String[]{"ad", "a?"}, true);
        testMap.put(new String[]{"adceb", "*a****b"}, true);
        testMap.put(new String[]{"acdcb", "a*c?b"}, false);
        testMap.put(new String[]{"aaaa", "*a"}, true);
        testMap.put(new String[]{"aaaa", "***a"}, true);
        testMap.put(new String[]{"c", "*?*"}, true);
        testMap.put(new String[]{"ababc", "*bc"}, true);

        testMap.put(new String[]{"mississippi", "m??*ss*?i*pi"}, false);
        testMap.put(new String[]{"mis", "m??"}, true);
        testMap.put(new String[]{"aaaaab", "*a"}, false);
    }

    @Test
    public void isMatch() {
        isMatch(e -> wildMatching.isMatch(e.getKey()[0], e.getKey()[1]));
    }

    @Test
    public void isMatchDPTopDown() {
        isMatch(e -> wildMatching.isMatchDPTopDown(e.getKey()[0], e.getKey()[1]));
    }

    @Test
    public void isMatchDPBottomUp() {
        isMatch(e -> wildMatching.isMatchDPBottomUp(e.getKey()[0], e.getKey()[1]));
    }

    private void isMatch(Function<Map.Entry<String[], Boolean>, Boolean> c) {
        for (Map.Entry<String[], Boolean> e : testMap.entrySet()) {
            assertEquals("fail for " + Arrays.toString(e.getKey()),
                    e.getValue(),
                    c.apply(e));
        }
    }

    @Test
    public void perf() {
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        //String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        String p = "*aa*ba*a*bb*aa*ab*a*aaaaaa*a*aaaa*bbabb*b*b*aaaaaaaaa*a*ba*bbb*a*ba*bb*bb*a*b*bb";

        System.out.println("s len:" + s.length() + ", p len:" + p.length());

        boolean matched = wildMatching.isMatchDPBottomUp(s, p);
    }
}