package utils;

public class SafePrimeNumber {

    /* This is an abstract representation for a prime number in form p = 2 * q + 1 */

    private int p;
    private int q;

    public SafePrimeNumber() {}

    public SafePrimeNumber(int p, int q) {
        this.p = p;
        this.q = q;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
