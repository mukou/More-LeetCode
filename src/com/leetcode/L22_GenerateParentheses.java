package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        gen(res, "", n, n);
        return res;
    }

    private void gen(List<String> res, String start, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(start);
            return;
        }

        if (left <= right && left > 0) {
            gen(res, start + "(", left - 1, right);
        }
        if (right > 0) {
            gen(res, start + ")", left, right - 1);
        }

    }

}

