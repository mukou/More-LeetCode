package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L17_LetterCombinationsOfAPhoneNumber {
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
