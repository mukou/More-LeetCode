package com.leetcode;

public class L200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0 ){
            return 0;
        }
        int col = grid[0].length;
        int res = 0;

        for(int i = 0 ; i< row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }

        }
        return res;

    }

    private void dfs(char[][] grid,int i ,int j ){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = '2';
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }

    }
}
