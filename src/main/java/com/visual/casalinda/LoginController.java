package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController {

    @FXML
    private ImageView Button_Eye;

    @FXML
    private TextField userField;

    @FXML
    private TextField showPassword;

    @FXML
    private PasswordField password;

    @FXML
    private Label warning;
    private String Password = "aaa";

    private String User = "admin";

    @FXML
    void changeStyle(String style) {
        password.setId(style);
        userField.setId(style);
        showPassword.setId(style);
    }

    @FXML
    void login() {
        String checkUser = userField.getText();
        String checkPass;

        if (password.isVisible()) checkPass = String.valueOf(password.getText());
        else checkPass = showPassword.getText();

        changeStyle("Default");

        if (checkUser.isEmpty() || checkPass.isEmpty()) {
            warning.setText("Preencha os campos vazios.");
            changeStyle("Error");
        } else if (checkLogin(checkPass, checkUser)) {
            // tela logada
            System.out.println("logado"); // apagar quando finalizar
            return;
        } else warning.setText("Usuario ou senha incorreta.");

        warning.setVisible(true);
        changeStyle("Error");
    }

    boolean checkLogin(String checkPass, String checkUser) {
        warning.setVisible(false);
        if (checkPass.equals(Password) && checkUser.equals(User)) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void enablePassword() {
        // Usuario solicita para mostrar senha
        if (password.isVisible()) {
            Button_Eye.setId("Button_Eye");
            password.setVisible(false);
            showPassword.setText(String.valueOf(password.getText()));
            showPassword.setVisible(true);
        }
        // Usuario solicita para ocultar senha
        else {
            Button_Eye.setId("Button_EyeOpen");
            password.setVisible(true);
            password.setText(showPassword.getText());
            showPassword.setVisible(false);
        }
    }

    /*@FXML
    public void changeScreen(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
            stage = (Stage) iniciar.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
        }
    }*/
}
