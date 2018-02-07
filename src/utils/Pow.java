package utils;

public class Pow {

    public static long pow(int a, int b) {
        long finalProduct = 1;
        int more = b;
        while (more != 0) {
            finalProduct *= a;
            more--;
        }
        return finalProduct;
    }
}
