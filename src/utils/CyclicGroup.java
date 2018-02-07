package utils;

import java.util.Random;

public class CyclicGroup {

    /* utils class for handling the cyclic groups and for obatin the generator of a such group
     * we use the cyclic group Z[p]* = { 1, 2, ...., p-1 }
     * order of group = p - 1 */

    private int order;
    private PrimeNumber pn;

    public CyclicGroup() { this.pn = new PrimeNumber(); }

    public CyclicGroup(int order) {
        this.order = order;
        this.pn = new PrimeNumber();
    }

    public long getOrder() { return order; }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getRandomElementFromGroup() {
        int min = 0;
        int max = 100000;
        Random rand = new Random();
        int outNumber;
        do {
            outNumber = rand.nextInt(max - min) + min;
        } while(!elementIsInGroup(outNumber));
        return outNumber;
    }

    public boolean elementIsInGroup(int number) {
        boolean isInGroup = false;
        for(int i = 1 ; i <= order; i++) {
            if ( number % (order + 1) == i ) {
                isInGroup = true;
                break;
            }
        }
        return isInGroup;
    }

    public int getCyclicGroupGenerator(SafePrimeNumber spn) {
        int p = spn.getP();
        int q = spn.getQ();
        double generator = 0.0;
        for (int i = 2; i <= (order - 1); i++) {  // [2, order - 1] = [2, p-2]
            generator = (double) getRandomElementFromGroup();
            if ( (Math.pow(generator, 2) % p ) == 1 ) {
               continue;
            }
            if ( (Math.pow(generator, q)) != 1 ) {
                continue;
            }
            else
                return (int) generator;
           }
         return (int) generator;
    }

}
