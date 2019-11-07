import java.util.Arrays;

class PhoneNumbers {
  private static final int NUMBER_LEN = 7;
  private char[] number;
  private char[] result;

  public PhoneNumbers (int num) { //number is 7 digit
    this.number = (num + "").toCharArray();
    this.result = new char[NUMBER_LEN];
    this.doPhone(0);
  }

  private void doPhone(int curDigit) {
    if(curDigit == NUMBER_LEN) { // base case
      System.out.println(new String(this.result));
      return;
    } 

    for(int i=1; i<=3; i++) {
      this.result[curDigit] = this.getCharKey(number[curDigit], i);
      doPhone(curDigit + 1);
      if(this.number[curDigit]==0 || this.number[curDigit]==1) return;
    } 
  }

  private char getCharKey(int digit, int index) {
    return 0;
  }
}