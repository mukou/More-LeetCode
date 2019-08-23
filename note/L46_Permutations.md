## [46. 全排列][leetcode_url]

## 描述

给定一个没有**重复数字**的序列，返回其所有可能的全排列。

**示例:**

```
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

**Tags:**  回溯


## 注意点
注意 **题解 1**的方法， 回溯的时候做状态恢复，避免状态拷贝是很不错的常用技巧。


## 题解 0

- 记录还未使用的数组，然后用当前的排列，迭代添加未使用数组的值，依次执行，但是过程中有数组拷贝的消耗，性能不算最优

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
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
```

## 题解 1

- 回溯 : 用同样大小的boolean[]记录，哪些序号的数已经加入排列，递归后做状态恢复，如此迭代，避免状态copy的做法很高效。

```java
class Solution {
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
```


[leetcode_url]: https://leetcode.com/problems/permutations/

