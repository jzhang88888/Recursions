import java.util.Arrays;

//https://www.geeksforgeeks.org/backtracking-approach-generate-n-bit-gray-codes/
class GreyCodeGen {
  private int[] numbers;
  private int number;
  private int index;
  private int timeO;

  public void run (int bits, int id) {
    //this.numbers = new int[(int) Math.pow(2, bits)];
    this.numbers = new int[1 << bits];
    this.index = 0;
    this.number = 0;
    this.timeO  = 0;

    if (id==0) this.gen(bits);
    if (id==1) this.gen2(bits);

    System.out.println("\n----------");
    System.out.println("Grey Codes");
    System.out.println("timeO=" + this.timeO);
    System.out.println("----------");
    printOut(this.numbers, bits);
  }

  /*
  //https://www.geeksforgeeks.org/given-a-number-n-generate-bit-patterns-from-0-to-2n-1-so-that-successive-patterns-differ-by-one-bit/
  //not working...
  private void gen2(int bits) {
    this.numbers[0] = 0;
    this.numbers[1] = 1;
    int i, j;
    for(i=2; i<this.len; i=i<<1) {
      for(j=i-1; j>00; j--)
    } 
  }
  */

  private void gen(int pos) {
    System.out.println("pos="+pos);
    this.timeO++;
    if (pos == 0) {
      this.numbers[index++] = this.number;
      //System.out.println("number saved ="+this.number+"\n");
      return;
    }
    this.gen(pos - 1);
    this.number = this.number ^ (1 << (pos - 1));
    this.gen(pos - 1);
  }

  //https://www.geeksforgeeks.org/generate-n-bit-gray-codes-set-2/
  private void gen2(int bits) {
    int N = 1 << bits;
    for (int i=0; i<N; i++) {
      this.timeO++;
      this.numbers[i] = i ^ (i >> 1);
    }
  }

  private static void printOut(int[] nums, int bits) {
    String out, idx;
    for (int i = 0; i < nums.length; i++) {
      out = String.format("%" + bits + "s", Integer.toBinaryString(nums[i]));
      idx = String.format("%2s: ", i); //2 decimal place
      System.out.println(idx + out.replace(' ', '0'));
    }
  }
}