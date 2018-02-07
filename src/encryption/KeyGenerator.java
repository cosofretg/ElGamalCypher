package encryption;

import keys.PrivateKey;
import keys.PublicKey;
import utils.CyclicGroup;
import utils.PrimeNumber;
import utils.SafePrimeNumber;

import java.util.Random;

public class KeyGenerator {

    /* class for generating the key pairs ( public key and private key ) necessary for the encryption method */

    private PrimeNumber pn;
    private CyclicGroup cg;
    private int p;           /* p = prime number used in public key, and in order of cyclic group */
    private int g;           /* g = generator of cyclic group */
    private int x;           /* x = private key */

    public KeyGenerator() {
        this.pn = new PrimeNumber();
        this.cg = new CyclicGroup();
    }

    public void setP(int p) { this.p = p; }

    public int getP() { return p; }

    public void setG(int g) { this.g = g; }

    public int getG() { return g; }

    public void setX(int x) { this.x = x; }

    public int getX() { return x; }

    public PublicKey generatePublicKey() {
        SafePrimeNumber spn = pn.getSafeRandomPrimeNumber();
        int p = spn.getP();                                    /* set p */
        setP(p);
        cg.setOrder(spn.getP() - 1);                           /* set order of the group p -1 */
        int g = cg.getCyclicGroupGenerator(spn);               /* get generator for the group Z[p] */
        setG(g);                                               /* set g */
        int x = new Random().nextInt((p-2) - 1) + 1;    /* choose random x so that min = 1 <= x <= p-2 = max */
        setX(x);                                               /* set x */
        int y = (int) Math.pow((double) g, (double) x) % p;    /* set y */
        return new PublicKey(y, g, p);
    }

    public PrivateKey generatePrivateKey() {
       return new PrivateKey(getX());
    }
}
