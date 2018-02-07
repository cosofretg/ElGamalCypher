import encryption.Encryption;
import encryption.KeyGenerator;
import keys.PrivateKey;
import keys.PublicKey;
import utils.CyclicGroup;
import utils.Pow;
import utils.PrimeNumber;
import utils.SafePrimeNumber;

import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        CyclicGroup cg = new CyclicGroup(4);
//        System.out.println(cg.getRandomElementFromGroup() + " " + "\n");
//        System.out.println(cg.getCyclicGroupGenerator(new SafePrimeNumber(5,2)));
//        PrimeNumber pn = new PrimeNumber();
//        SafePrimeNumber p = pn.getSafeRandomPrimeNumber();
//        System.out.println(p.getP() + " " + pn.isPrimeLong(p.getP()));
//        System.out.println(p.getP() / 2 + " " + pn.isPrimeLong(p.getP()));
//        System.out.println(p.getP() % 2);
//        KeyGenerator kg = new KeyGenerator();
//        PublicKey publicKey = kg.generatePublicKey();
//        System.out.println(publicKey.getG() + " " + publicKey.getY() + " " + publicKey.getP());
//        System.out.println("G:" + publicKey.getG() + " " + "Y:" + publicKey.getY() + " " + "P:" + publicKey.getP());
//        PrivateKey privateKey = kg.generatePrivateKey();
//        System.out.println("X:" + privateKey.getX());
//        String s = "Mesaj";
        Encryption e = new Encryption();
        PublicKey p = e.encrypt("Mesaj de criptat");
        System.out.println(p.getG() + " " + p.getP() + " " + p.getY());
//        Shanks s = new Shanks();
//        s.ShanksAlgoritm(3, 525, 809);
//        s.printList1();
        //System.out.println(Pow.pow(9,10));
    }

}
