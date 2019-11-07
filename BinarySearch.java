import java.util.Arrays;

public class BinarySearch {
  private final static int NOT_IN_ARRAY    = -1;
  private final static int ARRAY_UNORDERED = -2;
  private final static int LIMIT_REVERSED  = -3;

  private int[] array;
  private int target; 

  public BinarySearch(int[] source_array) {
    this.array = source_array;
  }

  public int search(int t) {
    this.target=t;
    return binarySearchRec (0, this.array.length - 1);
    //return binarySearch (0, this.array.length - 1);
  }
  //a is inscreasing sored
  //target=the value sought
  private int binarySearchRec(int lower, int upper) {
    int center = (lower + upper) / 2;
    //base cases
    if(lower > upper)                                       return LIMIT_REVERSED;  //bc
    else if(lower==upper && this.array[lower]!=this.target) return NOT_IN_ARRAY;    //bc
    else if(this.array[lower] > this.array[upper])        return ARRAY_UNORDERED; //bc
    if(this.target==this.array[center])                   return center; //HIT base case
    else if(this.target<this.array[center]) return binarySearchRec(lower, center-1);
    else                                    return binarySearchRec(center+1, upper);
  }

  //return hit index or Error
  private int binarySearch(int lower, int upper) {
    System.out.println("binarySearch (non-recursion)");
    if(lower > upper)                         return LIMIT_REVERSED;
    if(this.array[lower] > this.array[upper]) return ARRAY_UNORDERED;
    int center;
    while(true) {
      if(upper==lower && this.array[lower] != this.target) return NOT_IN_ARRAY;
      if(this.array[lower] > this.array[upper])        return ARRAY_UNORDERED;
      center = (lower + upper) / 2;
      if(this.array[center] == this.target) return center; //HIT exit
      if(this.array[center] < this.target) lower = center + 1;
      else upper = center - 1;
    }
  }
}