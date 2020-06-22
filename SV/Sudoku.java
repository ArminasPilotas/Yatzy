public class Sudoku {
    private int grid [][];
    Sudoku(){
        grid= new int[][]{{5, 3, 4, 6, 7, 8, 9, 1, 2,},
                {6, 7, 2, 1, 9, 0, 3, 4, 8},
                {1, 0, 0, 3, 4, 2, 5, 6, 0},
                {8, 5, 9, 7, 6, 1, 0, 2, 0},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}};
    }
    public boolean validSolution(){
        //check if valid numbers
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(grid[row][col]<1&&grid[row][col]>9) return false;
            }
        }

        //check rows
        for(int row=0;row<9;row++){
            for(int col=0;col<8;col++){
                for(int coltemp=col+1;coltemp<9;coltemp++){
                    if(grid[row][col]==grid[row][coltemp]) return false;
                }
            }
        }
        //check column
        for(int col=0;col<9;col++){
            for(int row=0;row<8;row++){
                for(int rowtemp=row+1;rowtemp<9;rowtemp++){
                    if(grid[row][col]==grid[rowtemp][col]) return false;
                }
            }
        }
        //checks grid
        //row and col is start of the grid
        for(int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                for(int position=0;position<8;position++){
                    for(int positiontemp=position+1;positiontemp<9;positiontemp++){
                        if(grid[row+position%3][col+position/3]==grid[row+positiontemp%3][col+positiontemp/3])
                            return false;
                    }
                }
            }
        }
        //othervise return true
        return true;

    }
}

