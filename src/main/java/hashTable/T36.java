package hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class T36 {
    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        char[][] nums = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean re = solution36.isValidSudoku(nums);
        System.out.println(re);
    }
}
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        char[][] rowHashSet = new char[9][9];
        char[][] boxHashSet = new char[9][9];
        char[][] columnHashSet = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int box = i/3*3 + j/3;
                char nowCh = board[i][j];
                System.out.println(nowCh+","+(nowCh-'1'));
                if(nowCh=='.')
                    continue;
                if(rowHashSet[i][nowCh-'1'] > 0 || boxHashSet[box][nowCh-'1'] > 0 ||columnHashSet[j][nowCh-'1'] > 0 ){
                    return false;
                }
                rowHashSet[i][nowCh-'1'] = 1 ;
                boxHashSet[box][nowCh-'1'] = 1 ;
                columnHashSet[j][nowCh-'1'] = 1 ;
            }
        }
        return true;

    }
}