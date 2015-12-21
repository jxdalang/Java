/**
* @package valid_sudoku
* @author ZS@ZJU
* @version V1.0
*/
package valid_sudoku;

import java.util.HashSet;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 17, 2015 11:07:49 PM
*/

/**
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                // 验证行有无重复
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                // 验证列有无重复
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                // 验证小九宫格内有无重复
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'
                        && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }
}