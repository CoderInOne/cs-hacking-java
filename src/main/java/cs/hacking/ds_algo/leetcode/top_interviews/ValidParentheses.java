package cs.hacking.ds_algo.leetcode.top_interviews;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        char[] stack = new char[s.length() / 2];
        int p = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                if (p == s.length() / 2) {
                    return false;
                }
                stack[p++] = c;
            }
            else if (p == 0
                  || (c == ')' && stack[--p] != '(')
                  || (c == ']' && stack[--p] != '[')
                  || (c == '}' && stack[--p] != '{')) {
                return false;
            }
        }
        return p == 0;
    }
}
