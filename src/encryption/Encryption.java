package encryption;

import keys.PrivateKey;
import keys.PublicKey;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Encryption {

    /* this is the class where lands the encryption method */

    private KeyGenerator keyGenerator;

    public Encryption() {
        this.keyGenerator = new KeyGenerator();
    }

    public int encryptMessage(String message) {
        byte[] bytes = message.getBytes();
        int s = 0;
        for (int i = 0; i < bytes.length; i++) {
            s = s + bytes[i];
        }
        return s;
    }

    public void writeInFile(int x, String message) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("C:\\Users\\MariusDK\\Desktop\\ElGamalCypher\\src\\files\\message_and_private_key.txt", "UTF-8");
            writer.println(x);
            writer.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

    }

    public PublicKey encrypt(String message) {
        PublicKey publicKey = keyGenerator.generatePublicKey();
        PrivateKey privateKey = keyGenerator.generatePrivateKey();
        System.out.println(privateKey.getX());
        int x = privateKey.getX();
        int messageEncrypted = encryptMessage(message);
        writeInFile(x, message);
        return publicKey;
    }
}
