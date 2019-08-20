package com.njust.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L297 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }

            StringBuilder sb = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int nonEmptySize = 0;
            while (!queue.isEmpty()) {
                int lastNonEmptySize = nonEmptySize;
                int len = queue.size();
                nonEmptySize = 0;
                while (len-- > 0) {
                    TreeNode temp = queue.poll();
                    if (temp == null) {
                        sb.append("null,");
                        continue;
                    }

                    sb.append(temp.val).append(",");
                    lastNonEmptySize--;
                    queue.add(temp.left);
                    queue.add(temp.right);
                    if (temp.left != null) {
                        nonEmptySize++;
                    }
                    if (temp.right != null) {
                        nonEmptySize++;
                    }
                    if (lastNonEmptySize == 0) {
                        break;
                    }
                }
                if (nonEmptySize == 0) {
                    break;
                }
            }

            sb.deleteCharAt(sb.length() - 1);
            return sb.append("]").toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) {
                return null;
            }
            data = data.substring(1, data.length() - 1);
            String[] value = data.split(",");
            TreeNode[] nodes = new TreeNode[value.length];

            int len = value.length;

            for (int i = 0; i < len; i++) {
                if ("null".equals(value[i])) {
                    nodes[i] = null;
                } else {
                    nodes[i] = new TreeNode(Integer.valueOf(value[i]));
                }
            }

            int currIndex = 0, nextTotalNum = 1, currNum = 0;
            int i = 0, nullSize = 0;
            while (currIndex < len) {
                if (i++ == nextTotalNum) {
                    nextTotalNum = currNum * 2;
                    currNum = 0;
                    i = 0;
                    nullSize = 0;
                    continue;
                }
                TreeNode curr = nodes[currIndex];
                if (curr == null) {
                    currIndex++;
                    nullSize++;
                    continue;
                }

//            int r = currNum * 2 + currIndex + nextTotalNum - currNum;
                int r = currIndex + currNum + nextTotalNum - nullSize;

                if (r < len) {
                    curr.left = nodes[r];
                }
                if (r + 1 < len) {
                    curr.right = nodes[r + 1];
                }
                currNum++;
                currIndex++;
            }

            return nodes[0];
        }
    }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

}

