import java.util.Arrays;

public class TowerOfHanoi {
  public int timeO=0;
  public void run(int n) {
    System.out.println("\n----Tower of Hanoi------------");
    this.run(n, true);
    System.out.println("\n------------------------------");
    this.run(n, 'S', 'D', 'A');
  }

  private void run(int n, boolean toLeft) {
    this.timeO++;
    if(n == 0) return;
    this.run(n-1, !toLeft);
    System.out.println("Move Disc #"+n+" to the "+(toLeft?"Left":"Right"));
    this.run(n-1, !toLeft);
  } 

  private void run(int n, char from, char to, char aux) {
    this.timeO++;
    if(n==0) return;
    this.run(n-1, from, aux, to);
    System.out.println("Move Disc #"+n+" from "+from+" to "+to);
    this.run(n-1, aux, to, from);
  }
}