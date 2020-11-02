package offer;

public class T12 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";
        Solution12 solution12 = new Solution12();
        boolean has = solution12.exist(board,word);
        System.out.println(has);
    }
}
class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(board[i][j]==words[0] && findWords(board,words,i,j,0))
                    return true;

            }
        }
        return false;
    }
    boolean findWords(char[][] board,char[] words,int i,int j,int index){
        char temp = board[i][j];
        System.out.println(i+","+j+","+temp);
        board[i][j] = '0';
        if(index==words.length-1) return true;

        if(i>0 && board[i-1][j]==words[index+1] && findWords(board,words,i-1,j,index+1)){
            return true;
        }
        if(i<board.length-1 && board[i+1][j]==words[index+1] && findWords(board,words,i+1,j,index+1)){
            return true;
        }
        if(j>0 && board[i][j-1]==words[index+1] && findWords(board,words,i,j-1,index+1)){
            return true;
        }
        if(j<board[0].length-1 && board[i][j+1]==words[index+1] && findWords(board,words,i,j+1,index+1)){
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}