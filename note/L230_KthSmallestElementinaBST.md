## 230.二叉搜索树中第K小的元素

给定一个二叉搜索树，编写一个函数 `kthSmallest` 来查找其中第 k 个最小的元素。

## 题目地址
https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/  
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

------------------


## 题解
最开始准备递归算出每个节点的序号，写了一会儿后发现，序号和中序遍历的次序是一致的，以后写代码还是要多想想，避免犯这种难堪的错误。  

## 注意点
- 注意，可以使用成员变量来辅助实现递归。

> 非递归实现 ，时间会慢一些 

```java
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        return 0;
    }

```


> 递归实现 

```java 

    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, new int[]{k});
        return res;
    }

    private void dfs(TreeNode root, int[] step) {
        if (root == null) return;
        dfs(root.left, step);
        step[0]--;
        if (step[0] == 0) {
            res = root.val;
            return;
        }
        dfs(root.right, step);
    }

```

