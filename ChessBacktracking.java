import java.util.Arrays;

//https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/tutorial/
//https://www.geeksforgeeks.org/n-queen-in-on-space/
public class ChessBacktracking {
  private int[][] board;

  public void run(int dim) {
    this.board = new int[dim][dim];
    boolean ok = this.showRec(dim);
    if(ok) this.printBoard(dim);
  }

  public boolean showRec(int n) {
    if(n==0) return true; //solution found
    for(int i=0; i<n; i++) {
      inner:
      for(int j=0; j<n; j++) {
        if(isAttacking(i, j, n)) continue inner;
        System.out.println("i="+i+" j="+j+" n="+n);
        board[i][j] = 1;
        if(showRec(n - 1)) return true;
        //backtracking
        board[i][j] = 0;
      }
    }
    return false;
  }

  private void printBoard(int dim) {
    for(int i=0; i<dim; i++) {
      System.out.println(Arrays.toString(this.board[i]));
    }
  } 

  private boolean isAttacking(int x, int y, int n) {
    for(int i=0; i<n; i++) {
      if(board[x][i]==1) return true;
      if(board[i][y]==1) return true;
      for(int j=0; j<n; j++) {
        if((x + y) == (i + j) || (x - y) == (i - j)) {
          if(board[i][j]==1) return true;
        }
      }
    }
    return false;
  }
}