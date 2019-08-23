package com.leetcode;

public class L79_WordSearch {

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
