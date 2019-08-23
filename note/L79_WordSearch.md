## [79. Word Search][leetcode_url]

## Description

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

__Example:__ 

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
```

**Tags:** Array, Backtracking


## 注意点
- NULL

## 题解 

图的遍历题目，遍历中染色避免一个节点使用超过1次。  
尝试在图中寻找认意一个入口，尝试遍历符合String的路径。

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        if(word == null || word.length() == 0){
            return true;
        }
        // boolean[][] visited = new boolean[board.length][board[0].length];
        char[] value = word.toCharArray();
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(value[0] == board[i][j]){
                    if(dfs(0,value,board,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int index,char[] value,char[][] board,int i, int j){
        if(index == value.length){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }

        if(value[index] == board[i][j]){

            board[i][j] = '\0';
            boolean res =  dfs(index+1,value,board,i+1,j)
                    ||dfs(index+1,value,board,i-1,j)
                    ||dfs(index+1,value,board,i,j+1)
                    ||dfs(index+1,value,board,i,j-1);
            board[i][j] = value[index];
            return res;
        }
        return false;
    }

}
```



[leetcode_url]: https://leetcode.com/problems/word-search/

