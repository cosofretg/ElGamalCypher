package utils;

public class Pow {

    public static int pow(int a, int b) {
        int finalProduct = 1;
        int more = b;
        while (more != 0) {
            finalProduct *= a;
            more--;
        }
        return finalProduct;
    }
}
