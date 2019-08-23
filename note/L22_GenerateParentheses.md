## [22. 括号生成][leetcode_url]

## 描述

给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且**有效**的括号组合。  

例如，给出 n = 3，生成结果为：


```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

**Tags:** String, 回溯


## 注意点
NULL


## 题解 

- 暴力得到所有的可能结果，即2^n个，然后判断每个结果是否有效：从左向右遍历时，总是有'(' 的数量**大于等于**')'的数量。
- DFS，深度为n+1的二叉树，记录'('和')'的数量，左节点用'('，剪纸掉不合条件的分支，得到最后结果即可，简单来讲是回溯的思路。

```java
class Solution {
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
```



[leetcode_url]: https://leetcode.com/problems/generate-parentheses/

