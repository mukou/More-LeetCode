package com.leetcode;

import java.lang.String;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L78_Subsets {

    public static void main(String[] args) {

        new L78_Subsets().new Solution3();

    }


    class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            if (nums != null) {
                help(list, 0, nums);
            }
            return list;
        }

        // 简单的 循环依次遍历做法，效率不错，类似动态规划的思想
        // 规定A 的真子集 集合 ~ZeroEvenOdd ，则{{ZeroEvenOdd},b} 的子集 等于 {~ZeroEvenOdd,~Ab}
        public void help(List<List<Integer>> subset, int index, int[] nums) {
            if (index >= nums.length) {
                return;
            }
            for (int i = 0, len = subset.size(); i < len; i++) {
                List<Integer> ori = new ArrayList<>(subset.get(i));
                ori.add(nums[index]);
                subset.add(ori);
            }
            help(subset, index + 1, nums);
        }
    }

    /**
     * 来自 rangerway.com
     * <p>
     * 遍历路径如图2:
     * <img src="doc_file/subset-tree_1.png">
     * <p>
     * @see <a href="http://rangerway.com/way/algorithm-permutation-combination-subset">algorithm-permutation-combination-subset</a>
     */
    class Solution2 {
        public List<List<Integer>> subsets(int[] S) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            subsets(S, 0, new ArrayList<Integer>(), result);
            return result;
        }

        private void subsets(int[] S, int depth, List<Integer> r, List<List<Integer>> result) {
            if (S.length == depth) {
                result.add(new ArrayList<Integer>(r));
                return;
            }
            r.add(S[depth]);
            subsets(S, depth + 1, r, result);
            r.remove(r.size() - 1);             //!!! MUST have; otherwise
            subsets(S, depth + 1, r, result);
        }
    }

    /**
     * 来自 rangerway.com
     * <p>
     * 遍历路径如图2:
     * <p>
     * <img src="doc_file/subset-tree_2.png">
     *
     * @see <a href="http://rangerway.com/way/algorithm-permutation-combination-subset">algorithm-permutation-combination-subset</a>
     */
    class Solution3 {
        public List<List<Integer>> subsets(int[] S) {
            List<List<Integer>> result = new ArrayList<>();
            subSets(S, 0, new ArrayDeque<Integer>(), result);
            return result;
        }

        private void subSets(int[] set, int depth, Deque<Integer> curr, List<List<Integer>> result) {
            result.add(new ArrayList<>(curr));
            for (int i = depth; i < set.length; i++) {
                curr.addLast(set[depth]);
                subSets(set, depth + 1, curr, result);
                curr.pollLast();
            }
        }
    }


}
