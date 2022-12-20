package com.example.marketclient;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class LoginController implements Initializable{
    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private ImageView logoImage;

    @FXML
    private ImageView lockImage;

    @FXML
    private TextField usernameTextfield;

    @FXML
    private PasswordField passwordTextfield;

    private Stage stage;
    private Scene scene;
    private Parent root;



    public void loginButtonOnAction(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        loginMessageLabel.setText("Login Attempted");
        loginMessageLabel.setAlignment(Pos.CENTER);

        Boolean valid = ClientBody.loginValidation(usernameTextfield.getText(),passwordTextfield.getText());
        if(valid == true){
            loginMessageLabel.setText("Login Successful");
            loginMessageLabel.setAlignment(Pos.CENTER);
            //switch scenes time
            root = FXMLLoader.load(getClass().getResource("market-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();

        }
        else{
            loginMessageLabel.setText("Incorrect Password");
            loginMessageLabel.setAlignment(Pos.CENTER);

        }


    }

    public void registerButtonOnAction(ActionEvent event) throws NoSuchAlgorithmException, IOException {
        loginMessageLabel.setText("User Registering");
        loginMessageLabel.setAlignment(Pos.CENTER);
        String username = usernameTextfield.getText();
        String password = passwordTextfield.getText();
        if(usernameTextfield.getText().trim().equals("") == true){
            loginMessageLabel.setText("Username Required");
            loginMessageLabel.setAlignment(Pos.CENTER);
        }
        else if(passwordTextfield.getText().trim().equals("") == true){
            loginMessageLabel.setText("Logged in as Guest");
            loginMessageLabel.setAlignment(Pos.CENTER);
            String loginData = username + ","+ MD5Encryption.encryptPassword("guestpassword");
            boolean valid = ClientBody.registerClient(loginData);
            if(valid == false){
                loginMessageLabel.setText("Please use a unique username");
                loginMessageLabel.setAlignment(Pos.CENTER);
            }
        }
        else{

            String loginData = username + "," + MD5Encryption.encryptPassword(password);
            boolean valid = ClientBody.registerClient(loginData);
            if (valid == true) {
                loginMessageLabel.setText("Registration Successful!");
                loginMessageLabel.setAlignment(Pos.CENTER);
            } else {
                loginMessageLabel.setText("Username Already Exists");
                loginMessageLabel.setAlignment(Pos.CENTER);
            }
        }
    }

    public static void playMusic(){
        MediaPlayer bgmusic;

        Media h = new Media(new File("SoundEffects/loginMusic.mp3").toURI().toString());
        bgmusic = new MediaPlayer(h);
        bgmusic.setOnEndOfMedia(new Runnable() {
            public void run() {
                bgmusic.seek(Duration.ZERO);
            }
        });
        bgmusic.setVolume(.1);
        bgmusic.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File pokemonMarketplaceLogo = new File("images/PokemonMarketLogo.jpg");
        Image pokemonMarket = new Image(pokemonMarketplaceLogo.toURI().toString());
        logoImage.setImage(pokemonMarket);

        File lockFile = new File("images/lock-icon-29071.png");
        Image lockImageView = new Image(lockFile.toURI().toString());
        lockImage.setImage(lockImageView);

        playMusic();



    }
}