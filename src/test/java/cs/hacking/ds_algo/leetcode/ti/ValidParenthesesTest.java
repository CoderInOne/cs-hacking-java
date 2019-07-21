package cs.hacking.ds_algo.leetcode.ti;

import cs.hacking.ds_algo.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidParenthesesTest {

    @Test
    public void isValid() {
        List<Pair<String, Boolean>> list = new ArrayList<>();
        list.add(Pair.from("((()))", true));
        list.add(Pair.from("(()())", true));
        list.add(Pair.from("()()()", true));
        list.add(Pair.from("()()(", false));
        list.add(Pair.from(")()", false));
        list.add(Pair.from("((", false));

        ValidParentheses validParentheses = new ValidParentheses();

        for (Pair<String, Boolean> p : list) {
            assertEquals("fail for " + p.getOne(),
                    p.getTwo(), validParentheses.isValid(p.getOne()));
        }
    }
}