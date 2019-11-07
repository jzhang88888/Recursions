import java.util.Arrays;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    /*
    int[]a = randomIntArray (10, true);
    System.out.println(Arrays.toString(a));

    BinarySearch bs = new BinarySearch(a);
    int key = a[3];
    int result = bs.search(key);
    System.out.println((result < 0 ? "MISS: " : "HIT index=") + result + " key="+key);

    StrPerm strperm = new StrPerm("hat");
    strperm.permutate();
    strperm.combine();

    //TowerOfHanoi toh = new TowerOfHanoi();
    //toh.run(3);
    HammingDistance hd = new HammingDistance();
    int a = 58, b = 23;
    String A = Integer.toBinaryString(a);
    String B = Integer.toBinaryString(b);
    System.out.println("a=" + A);
    System.out.println("b=" + B);
    System.out.println("dist="+hd.getDistance(a, b));
    System.out.println("\n---------------------------");

    ChessBacktracking chess = new ChessBacktracking();
    chess.run(4);
    */

    GreyCodeGen gcg = new GreyCodeGen();
    gcg.run(4, 0); //4 bits words
    gcg.run(4, 1); //4 bits words
  }

  private static int[] randomIntArray(int len, boolean sorted) {
    int[] array = new int[len];
    Random rand = new Random();    
    for(int i=0; i< len; i++) array[i] = rand.nextInt(len*10);
    if(sorted) Arrays.sort(array);
    return array;
  }
}