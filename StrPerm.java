import java.util.Arrays;

class StrPerm {
  private String string;
  private int len;
  private int outId=0;
  private boolean[] usedG;
  private StringBuffer outG;
  private char[] chars;

  public StrPerm(String str) {
    this.string = str;
    this.chars = str.toCharArray();
    this.len = str.length();
    this.usedG = new boolean[this.len];
    this.outG = new StringBuffer();
  }

  public void permutate() {
    //boolean[]   used = new boolean[this.len];
    //StringBuffer out = new StringBuffer();
    System.out.println("\npermutate input="+this.string);
    System.out.println("--------------------");
    this.outId = 0;
    this.permutate (0);
  }

  private void permutate(int level) {
    if(level == this.len) {
      System.out.println("  =>output[" + (this.outId++)+"]="+this.outG.toString());
      return;
    }

    for(int i=0; i<this.len; i++) {
      if(this.usedG[i]) continue;

      this.outG.append(this.chars[i]);
      this.usedG[i] = true;

      permutate(level + 1);

      this.usedG[i] = false;
      this.outG.setLength(this.outG.length() - 1); //remove the last char;
    }    
  }

  public void combine() {
    this.chars = this.string.toCharArray();
    System.out.println("\ncombine input="+this.string);
    System.out.println("------------------");
    this.outId = 0;
    this.combine(0);
  }

  private void combine(int start) {
    for(int i = start; i < this.len; i++) {
      this.outG.append(this.chars[i]);
      System.out.println("  =>combine out[" + (this.outId++) +"]="+this.outG.toString());

      if(i < this.len - 1) combine(i + 1);
      this.outG.setLength(this.outG.length() - 1);
    }
  }
}