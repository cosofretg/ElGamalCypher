import decrypt.Shanks;
import utils.CyclicGroup;
import utils.PrimeNumber;
import utils.SafePrimeNumber;

import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        CyclicGroup cg = new CyclicGroup(4);
//        System.out.println(cg.getRandomElementFromGroup() + " " + "\n");
//        System.out.println(cg.getCyclicGroupGenerator());
//        PrimeNumber pn = new PrimeNumber();
//        SafePrimeNumber spn = pn.getSafeRandomPrimeNumber();
//        System.out.println(spn.getP() + " " + spn.getQ());
        Shanks shanks = new Shanks();
        System.out.println(shanks.ShanksAlgoritm(3,525,809));
        shanks.printList2();

    }

}
