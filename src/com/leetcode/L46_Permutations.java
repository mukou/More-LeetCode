package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//todo 这道题用回溯应该梗方便，而且空间复杂度也可控
public class L46_Permutations {

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
