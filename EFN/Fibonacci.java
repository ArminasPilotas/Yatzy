public class Fibonacci {
    private int n1 = 0;
    private int n2 = 1;
    private int n3;
    private int sumFibonacci=0;


    public int sumOfFibonacci() {
        while (n3 < 4000000) {
           n3=n1+n2;
           n1=n2;
           n2=n3;
           if(n3%2==0){
               sumFibonacci+=n3;
           }
        }
        return sumFibonacci; //sum equals 4613732
    }
}