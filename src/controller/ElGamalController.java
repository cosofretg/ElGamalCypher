package controller;

import decrypt.PollardRho;
import decrypt.Shanks;
import encryption.Encryption;
import keys.PrivateKey;
import keys.PublicKey;

public class ElGamalController {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public String decryptShanks()
    {
        String s = "Esec";
        publicKey = new PublicKey();
        privateKey = new PrivateKey();
        Shanks shanks = new Shanks();
        int privateKeyVal = shanks.ShanksAlgoritm(publicKey.getG(),publicKey.getY(),publicKey.getP());
        if (privateKey.getX()==privateKeyVal)
        {
            //returnare mesaj
        }
        return s;
    }
    public String decryptPollardRho()
    {
        String s = "Esec";
        publicKey = new PublicKey();
        privateKey = new PrivateKey();
        PollardRho pollardRho = new PollardRho();
        int privateKeyVal = pollardRho.PollardRhoAlgoritm(publicKey.getG(),publicKey.getY(),publicKey.getP());
        if (privateKey.getX()==privateKeyVal)
        {
            //returnare mesaj
        }
        return s;
    }
    public int getMessageEncrypt(String message)
    {
        Encryption encryption = new Encryption();
        return encryption.encryptMessage(message);
    }
}
