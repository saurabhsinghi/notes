
/* Complete OO design: https://github.com/robertbraeutigam/tictactoe/tree/master/src/main/java/com/github/robertbraeutigam/tictactoe
*/

/*
 Given n = 3, assume player 1 is "X" and player 2 is "0" 
*/
public class TicTacToe{

  private int[] rows;
  private int[] cols'
  private int diagonal;
  private int antiDiagonal;
 
 public TicTacToe(int n){
  rows = new int[n];
  cols = new int[n];
 }
 /** Naive move implementation, see smarter implementation below **/
 /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        matrix[row][col]=player;
 
        //check row
        boolean win=true;
        for(int i=0; i<matrix.length; i++){
            if(matrix[row][i]!=player){
                win=false;
                break;
            }
        }
 
        if(win) return player;
 
        //check column
        win=true;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][col]!=player){
                win=false;
                break;
            }
        }
 
        if(win) return player;
 
        //check back diagonal
        win=true;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][i]!=player){
                win=false;
                break;
            }
        }
 
        if(win) return player;
 
        //check forward diagonal
        win=true;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][matrix.length-i-1]!=player){
                win=false;
                break;
            }
        }
 
        if(win) return player;
 
        return 0;
    }

/** Smarter implementation
 @param row - row of the board
 @param col - col of the board
 @param player - 1 or 2

 @return: The current winning condition:
 0: No one wins
 1: Player 1 wins
 2: Player 2 wins

*/
 public int move(int row, int col, int player){
  int toAdd = (player ==1) ? (1 : -1);
  
  rows[row] += toAdd;
  cols[col] += toAdd; 
  
  if(row==col){
   diagonal += toAdd;
  }

  if(col == (cols.length - row -1)){
    antiDiagonal += toAdd;
  }
  
  int size = rows.length; 
  
  if(Math.abs(rows[row]) == size || 
     Math.abs(cols[col]) == size ||
     Math.abs(diagonal) == size ||
     Math.abs(antiDiagonal) == size  
   ){
     return player;
   }
   return 0;
  }

public static void main(String args[]){
 TicTacToe tt = new TicTacToe(3);
 tt.move(0,0,1);
 tt.move(1,0,2); 
}

}
