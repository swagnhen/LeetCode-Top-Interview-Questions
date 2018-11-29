package pers.swegnhan.leetcode.medium.treesandgraphs;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        if(grid[0].length == 0)
            return 0;
        boolean[][] map = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1' && map[i][j] == false){
                    count++;
                    fire(map, grid, i, j);
                }
            }
        }
        return count;
    }

    public static void fire(boolean[][] map, char[][] grid, int i, int j){
        if(i < 0 || i >= map.length || j < 0 || j >= map[0].length)
            return;
        if(map[i][j] || grid[i][j] == '0')
            return;
        map[i][j] = true;
        fire(map, grid, i + 1, j);
        fire(map, grid, i, j + 1);
        fire(map, grid, i - 1, j);
        fire(map, grid, i, j - 1);
    }

    public static void main(String[] args){
        char[][] test = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(test));
    }

}
