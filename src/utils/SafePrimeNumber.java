package utils;

public class SafePrimeNumber {

    /* This is an abstract representation for a prime number in form p = 2 * q + 1 */

    private long p;
    private long q;

    public SafePrimeNumber() {}

    public SafePrimeNumber(long p, long q) {
        this.p = p;
        this.q = q;
    }

    public long getP() {
        return p;
    }

    public long getQ() {
        return q;
    }

    public void setP(long p) {
        this.p = p;
    }

    public void setQ(long q) {
        this.q = q;
    }
}
