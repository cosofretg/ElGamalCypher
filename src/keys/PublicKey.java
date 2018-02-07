package keys;

public class PublicKey {

    /* y = g^x ( mod p ) => the public key is the pair (y, g, p)
    *  p is a prime number previously generated using package utils.PrimeNumber.getRandomPrimeNumber() method
     * g is the generator of the cyclic group */

    private int y;
    private int g;
    private int p;

    public PublicKey() {}

    public PublicKey(int y, int g, int p) {
        this.y = y;
        this.g = g;
        this.p = p;
    }

    public int getG() {
        return g;
    }

    public int getP() {
        return p;
    }

    public int getY() {
        return y;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setY(int y) {
        this.y = y;
    }
}
