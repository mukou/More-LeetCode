## [17. 电话号码的字母组合][leetcode_url]

## 描述

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。  

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

__示例:__ 

```
输入:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

**Tags:** String, 回溯


## 注意点
NULL

## 题解

一个暴力遍历就可求得结果的题目，估计难度写错了

```java
class Solution {
    private static String[][] alphas = new String[10][];
    {
        // alphas[0] = new String[]{"a","b","c"};
        // alphas[1] = new String[]{"a","b","c"};
        alphas[2] = new String[]{"a","b","c"};
        alphas[3] = new String[]{"d","e","f"};
        alphas[4] = new String[]{"g","h","i"};
        alphas[5] = new String[]{"j","k","l"};
        alphas[6] = new String[]{"m","n","o"};
        alphas[7] = new String[]{"p","q","r","s"};
        alphas[8] = new String[]{"t","u","v"};
        alphas[9] = new String[]{"w","x","y","z"};
    }

    public List<String> letterCombinations(String digits) {
        char[] charArray = digits.toCharArray();
        int[] value = new int[charArray.length];
        for(int i = 0 ; i < charArray.length ; i++){
            value[i] = (int)(charArray[i]-48);
        }
        List<String> temp = new ArrayList<>();
        if(value.length == 0){
            return temp;
        }
        temp.add("");
        for(int item : value){
            temp = gen(temp,alphas[item]);
        }
        return temp;
    }

    private List<String> gen(List<String> oriList,String[] array){
        List<String> res = new ArrayList<>();
        for(String ori : oriList){
            for(String item : array){
                res.add(ori+item);
            }
        }
        return res;
    }

}
```



[leetcode_url]: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

