package cs.hacking.ds_algo.leetcode.top_interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class WildMatchingTest {
    private WildMatching wildMatching;
    private Map<String[], Boolean> testMap;

    @Before
    public void setUp() throws Exception {
        wildMatching = new WildMatching();
        testMap = new HashMap<>();

        // simple case
        testMap.put(new String[]{"ab", "ab"}, true);

        testMap.put(new String[]{"aa", "a"}, false);
        testMap.put(new String[]{"ad", "?c"}, false);

        testMap.put(new String[]{"aa", "*"}, true);
        testMap.put(new String[]{"ad", "a?"}, true);
        testMap.put(new String[]{"adceb", "*a*b"}, true);
        testMap.put(new String[]{"acdcb", "a*c?b"}, false);
        testMap.put(new String[]{"aaaa", "*a"}, true);
        testMap.put(new String[]{"aaaa", "***a"}, true);
        testMap.put(new String[]{"c", "*?*"}, true);

        testMap.put(new String[]{"mississippi", "m??*ss*?i*pi"}, false);
        testMap.put(new String[]{"mis", "m??"}, true);
        testMap.put(new String[]{"aaaaab", "*a"}, false);
    }

    @Test
    public void isMatch() {
        for (Map.Entry<String[], Boolean> e : testMap.entrySet()) {
            assertEquals("fail for " + Arrays.toString(e.getKey()),
                    e.getValue(),
                    wildMatching.isMatch(e.getKey()[0], e.getKey()[1]));
        }
    }

    @Test
    public void perf() {
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
//        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        String p = "^*aa*ba*a*bb*aa*ab*a*aaaaaa*a*aaaa*bbabb*b*b*aaaaaaaaa*a*ba*bbb*a*ba*bb*bb*a*b*bb$";

        System.out.println(s.matches(p));

        boolean match = wildMatching.isMatch(s, p);
    }
}