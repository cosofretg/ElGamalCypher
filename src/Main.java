import decrypt.IndexCalculus;
import decrypt.PollardRho;
import decrypt.Shanks;
import encryption.Encryption;
import keys.PublicKey;
import utils.CyclicGroup;
import utils.PrimeNumber;
import utils.SafePrimeNumber;

import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //----------------------------ui----------------
//        public class Main extends Application {
//            @Override
//            public void start(Stage primaryStage) throws Exception {
//                Parent root = FXMLLoader.load(getClass().getResource("ui/ElGamal_window.fxml"));
//                primaryStage.setTitle("ElGamal Cypher");
//                primaryStage.setScene(new Scene(root));
//                primaryStage.show();
//            }
//            public static void main(String[] args) {
//                launch();
//            }
//
//        }
        
        //----------------------------------------------
        PublicKey p = new PublicKey();
        System.out.println(p.getG() + " " + p.getP() + " " + p.getY());

//        Shanks shanks = new Shanks();
//        System.out.println(shanks.ShanksAlgoritm(p.getG(),p.getY(),p.getP()));

        CyclicGroup cyclicGroup = new CyclicGroup(p.getP()-1);
        PollardRho pollardRho = new PollardRho();
        if (cyclicGroup.elementIsInGroup(p.getY())) {
            System.out.println(pollardRho.PollardRhoAlgoritm(p.getY(), p.getG(), p.getP()));

        }
        }

}
