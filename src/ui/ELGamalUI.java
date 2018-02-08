package ui;

import controller.ElGamalController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ELGamalUI implements Initializable{

        private ElGamalController controller;
        @FXML private Label id_msLabel;
        @FXML private Label id_msCryptText;
        @FXML private Label id_decryptShanks;
        @FXML private Label id_DecryptPol;

        @FXML private Button id_crypt;
        @FXML private TextField id_msText;
        @FXML private Button id_bShanks;
        @FXML private Button id_bPollardRho;




        public ELGamalUI() {
            this.controller = new ElGamalController();

        }

        @Override
        public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
            initData();
        }

        public void initData() {

            //predict.setOnAction(event -> predictPopularity());
            String s = id_msText.getText();
            if (s.equals("")) {
                System.out.println("ERROR: Introduceti un mesaj!");
            }
            else {

                id_crypt.setOnAction(event -> id_msCryptText.setText(controller.getMessageEncrypt(id_msText.getText())+""));

                id_bShanks.setOnAction(event -> id_decryptShanks.setText(controller.decryptShanks()));

                id_bPollardRho.setOnAction(event -> id_DecryptPol.setText(controller.decryptPollardRho()));
            }
        }



}
