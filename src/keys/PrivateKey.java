package keys;

public class PrivateKey {

    /* y = g^x ( mod p ) => the private key is the exponent x
    *  p is a prime number previously generated using package utils.PrimeNumber.getRandomPrimeNumber() method
    *  g is the generator of the cyclic group */

    private int x;

    public PrivateKey() {}

    public PrivateKey(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
