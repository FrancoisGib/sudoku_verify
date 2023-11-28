public class Sudoku {
    private int grid[][];

    public boolean verify(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < 9; i++) {
            if (!(checkLine(i) && checkColumn(i) && checkBlock(i)))
                return false;
        }
        return true;
    }

    private boolean checkLine(int index) {
        int somme = 0;
        for (int i = 0; i < 9; i++)
            somme += grid[index][i];
        return somme == 45;
    }

    private boolean checkColumn(int index) {
        int somme = 0;
        for (int i = 0; i < 9; i++)
            somme += grid[i][index];
        return somme == 45;
    }

    private boolean checkBlock(int index) {
        int i = (index % 3) * 3;
        int j = (index / 3) * 3;
        System.out.println("Index : "+ index + "  Line : " +  i + "  Column : " + j);
        int somme = 0;
        for (int k = i; k < i + 3; k++) {
            for (int z = j; z < j + 3; z++) {
                //System.out.println(grid[k][z] + "  i : " + k + "  j : " + z);
                somme += grid[k][z];
            }
        }
        //System.out.println("Bloc : " + somme);
        return somme == 45;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int [][] wrongGrid = {{1,2,3,4,5,6,7,8,9},
                              {4,5,6,7,8,9,1,2,3},
                              {7,8,9,1,2,3,4,5,6},
                              {2,3,1,5,6,4,8,9,7},
                              {5,6,4,8,9,7,2,3,1},
                              {8,9,7,2,3,1,5,6,4},
                              {3,5,2,6,4,5,9,7,6},
                              {6,4,5,9,7,8,3,1,2},
                              {9,7,8,3,1,2,6,4,5}};
        System.out.println(sudoku.verify(wrongGrid));
        int [][] rightGrid = {{1,6,7,9,4,2,3,5,8},
                              {5,3,4,8,6,1,2,9,7},
                              {8,2,9,7,5,3,6,1,4},
                              {3,7,8,2,9,5,4,6,1},
                              {9,1,2,6,8,4,7,3,5},
                              {4,5,6,3,1,7,8,2,9},
                              {6,9,5,4,2,8,1,7,3},
                              {7,8,1,5,3,6,9,4,2},
                              {2,4,3,1,7,9,5,8,6}};
        System.out.println(sudoku.verify(rightGrid));
    }
}
