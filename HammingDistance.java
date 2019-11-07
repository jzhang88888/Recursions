import java.util.Arrays;

class HammingDistance {
  private static final String TAG = "HammingDistance";

  public int getDistance(int a, int b) {
    if(a == 0 && b == 0) return 0;

    int aa = a >> 1;
    int bb = b >> 1;
    if(a % 2 != b % 2) return 1 + getDistance(aa, bb);
    return getDistance(aa, bb);
  }
}