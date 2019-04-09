public class FibPair {
    public static void main(String[] args) {
        nextText( 8, 5, "[13,8]");
        nextText( 3, 2, "[5,3]");

        /* optional extra education: Fibonacci numbers
        recursively, and in linear time */
        oneFib(  0, 0);  // base case
        oneFib(  1, 1);  // smallest recursive case, or base case
        oneFib(  2, 1);  // recursive case, sometimes smallest
        oneFib(  7, 13); // recursive case

        System.out.println( "no noticeable delay before...");
        oneFib( 46, 1836311903);
          /* value from
             stackoverflow.com/questions/15065088/upper-limits-for-fibonnacci
             but adjusted because they index from 1. Who ARE these people?
           */
    }

    private static Pair<Integer> nextPairAfter(Pair<Integer> oldPair) {
        int newFirst = oldPair.getFirst() + oldPair.getSecond();
        int newSecond = oldPair.getFirst();
        return new Pair<Integer>(newFirst, newSecond);
    }

    private static void nextText( Integer bigger
                               , Integer smaller
                               , String expect
                               ) {

       // code here to make a pair from the params
       Pair<Integer> pair = new Pair<Integer>(bigger, smaller);

       System.out.println(
           "The pair after "
         + pair
         + " is " + nextPairAfter(pair)
         + " ...expecting " + expect
         + System.lineSeparator());
    }

        /**
      test fib()
      optional extra education
     */
    private static void oneFib( int n
                              , int expect
                              ) {
        System.out.println(
            "Fib " + n + ": "
          + fib(n)
          + " ...expecting " + expect
          + System.lineSeparator());
     }

    /*
    calculate the pair
    [Fn,Fn−1]
    recursively from the pair
    [Fn−1,Fn−2]

    /**
      Calculate a Fibonacci number recursively
      and in linear time.
      optional extra education

      @return the nth Fibonacci number
              n >= 0
     */
    private static Integer fib( int n) {
        return fibo(n, new Pair<Integer>(0,1));
    }

    private static Integer fibo(int n, Pair<Integer> pair) {
        if (n == 0) return pair.getFirst();
        else return fibo(n - 1, nextPairAfter(pair));
    }
}
