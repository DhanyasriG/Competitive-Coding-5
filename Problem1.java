// Time Complexity : O(9*9) = O(1) (since board size is fixed)
// Space Complexity : O(1) (since at most 27 sets of size 9, constant space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Needed careful handling of 3x3 boxes indexing


// Use HashSets to track seen numbers in each row, column, and 3x3 sub-box for better time complexity
// For each cell (i,j):
//  - Check if number already exists in the row set then invalid
//  - Check if number already exists in the column set then invalid
//  - Check if number already exists in the corresponding 3x3 box set then invalid
// If no conflicts are found then valid Sudoku.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;

        // 9 hashsets for boxes
        HashSet<Character>[] boxSet = new HashSet[9];
        for (int k = 0; k < 9; k++) {
            boxSet[k] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                // Row check
                if (board[i][j] != '.') {
                    if(!rowSet.contains(board[i][j]))
                        rowSet.add(board[i][j]); 
                    else 
                        return false;
                }

                // Column check
                if (board[j][i] != '.') {
                    if (!colSet.contains(board[j][i])) 
                        colSet.add(board[j][i]);
                    else 
                        return false;
                }

                // Box index calculation
                int boxIdx = (i / 3) * 3 + j / 3;       // i/3 - > groups row, j/3 -> groups column *3 shifts the column horizontally
                if (board[i][j] != '.') {
                    if (!boxSet[boxIdx].contains(board[i][j])) 
                        boxSet[boxIdx].add(board[i][j]);
                    else 
                        return false;
                }
            }
        }
        return true;
    }
}
