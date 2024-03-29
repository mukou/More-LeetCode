package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//todo 这道题用回溯应该梗方便，而且空间复杂度也可控
public class L46_Permutations {

class Solution0 {
    public List<List<Integer>> permute(int[] nums) {
        //Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        search(res, 0, new int[0], nums, nums);

        return res;
    }

    private void search(List<List<Integer>> res, int index, int[] temp, int[] nums, int[] noArrive) {
        if (index == nums.length) {
            List<Integer> level = new ArrayList<>();
            for (int i : temp) {
                level.add(i);
            }
            res.add(level);
            return;
        }


        for (int i = 0; i < noArrive.length; i++) {
            int[] iCopy = Arrays.copyOf(temp, index + 1);
            iCopy[index] = noArrive[i];
            int[] noCopy = Arrays.copyOf(noArrive, noArrive.length - 1);
            if (i < noArrive.length - 1) {
                noCopy[i] = noArrive[noArrive.length - 1];
            }
            search(res, index + 1, iCopy, nums, noCopy);
        }

    }
}

class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, new ArrayList<Integer>(), results, new boolean[nums.length]);
        return results;
    }
    
    private void dfs(int[] nums, 
                     List<Integer> permutation,
                     List<List<Integer>> results,
                     boolean[] visited) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, permutation, results, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}


}
