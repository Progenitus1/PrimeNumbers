public class Main {

    public static void main(String[] args) {
        if(args.length < 1){
            throw new IllegalArgumentException();
        }
        PrimeNumberFilter primeNumberFilter = new PrimeNumberFilter(args[0]);
        primeNumberFilter.printPrimeNumbers();


    }
}
