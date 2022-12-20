package com.example.marketclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MarketController implements Initializable{

    @FXML
    private Label pokemon1;

    @FXML
    private Label pokemon2;

    @FXML
    private Label pokemon3;

    @FXML
    private Label pokemon4;

    @FXML
    private Label pokemon5;

    @FXML
    private Label pokemon1Price;

    @FXML
    private Label pokemon2Price;

    @FXML
    private Label pokemon3Price;

    @FXML
    private Label pokemon4Price;

    @FXML
    private Label pokemon5Price;

    @FXML
    private Label pokemon1Bid;

    @FXML
    private Label pokemon2Bid;

    @FXML
    private Label pokemon3Bid;

    @FXML
    private Label pokemon4Bid;

    @FXML
    private Label pokemon5Bid;

    @FXML
    private Button pokemon1Buy;

    @FXML
    private Button pokemon2Buy;

    @FXML
    private Button pokemon3Buy;

    @FXML
    private Button pokemon4Buy;

    @FXML
    private Button pokemon5Buy;

    @FXML
    private TextField pokemon1Textfield;

    @FXML
    private TextField pokemon2Textfield;

    @FXML
    private TextField pokemon3Textfield;

    @FXML
    private TextField pokemon4Textfield;

    @FXML
    private TextField pokemon5Textfield;

    @FXML
    private Button pokemon1BidButton;

    @FXML
    private Button pokemon2BidButton;

    @FXML
    private Button pokemon3BidButton;

    @FXML
    private Button pokemon4BidButton;

    @FXML
    private Button pokemon5BidButton;

    @FXML
    private Button pokedex1;

    @FXML
    private Button pokedex2;

    @FXML
    private Button pokedex3;

    @FXML
    private Button pokedex4;

    @FXML
    private Button pokedex5;

    @FXML
    private Button historyButton;


    public void historyButtonOnAction(ActionEvent e) throws IOException {
        FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("history-view.fxml"));
        Parent root1 = (Parent) fxmloader.load();
        Stage stage = new Stage();
        stage.setTitle("History");
        stage.setScene(new Scene(root1));
        stage.centerOnScreen();
        stage.show();
    }
    public Boolean isANumber(String s){
        return s!= "" && s.matches("[0-9.]+");


    }
    public void bid1OnAction(ActionEvent e) throws IOException {
        String value = pokemon1Textfield.getText();
        if(isANumber(value) == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Amount Bid is Invalid");
            alert.setHeaderText("Payment Error");
            alert.show();
        }
        else{

            String serverResponse = ClientBody.biddingProcess("1,"+value);

            if(serverResponse.equals("success")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Bid exceeded purchase price so the item is now yours!");
                alert.setHeaderText("Item Purchased");
                alert.show();
            }

            if(serverResponse.equals("placed")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Bid Placed");
                alert.setContentText("Bid Successful. You're now the highest bidder!");
                alert.show();
            }
            if(serverResponse.equals("unavailable")){
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error!");
                alert2.setHeaderText("Bid Failed");
                alert2.setContentText("Item has already been sold.");
                alert2.show();
            }
            if (serverResponse.equals("failure")){
                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert3.setTitle("Error!");
                alert3.setHeaderText("Bid Failed");
                alert3.setContentText("Bid was too low.");
                alert3.show();
            }

        }
    }

    public void bid2OnAction(ActionEvent e)throws IOException{
        String value = pokemon2Textfield.getText();
        if(isANumber(value) == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Amount Bid is Invalid");
            alert.setHeaderText("Payment Error");
            alert.show();
        }
        else{

            String serverResponse = ClientBody.biddingProcess("2,"+value);

            if(serverResponse.equals("success")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Bid exceeded purchase price so the item is now yours!");
                alert.setHeaderText("Item Purchased");
                alert.show();
            }

            if(serverResponse.equals("placed")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Bid Placed");
                alert.setContentText("Bid Successful. You're now the highest bidder!");
                alert.show();
            }
            if(serverResponse.equals("unavailable")){
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error!");
                alert2.setHeaderText("Bid Failed");
                alert2.setContentText("Item has already been sold.");
                alert2.show();
            }
            if (serverResponse.equals("failure")){
                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert3.setTitle("Error!");
                alert3.setHeaderText("Bid Failed");
                alert3.setContentText("Bid was too low.");
                alert3.show();
            }

        }
    }

    public void bid3OnAction(ActionEvent e)throws IOException{
        String value = pokemon3Textfield.getText();
        if(isANumber(value) == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Amount Bid is Invalid");
            alert.setHeaderText("Payment Error");
            alert.show();
        }
        else{

            String serverResponse = ClientBody.biddingProcess("3,"+value);

            if(serverResponse.equals("success")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Bid exceeded purchase price so the item is now yours!");
                alert.setHeaderText("Item Purchased");
                alert.show();
            }

            if(serverResponse.equals("placed")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Bid Placed");
                alert.setContentText("Bid Successful. You're now the highest bidder!");
                alert.show();
            }
            if(serverResponse.equals("unavailable")){
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error!");
                alert2.setHeaderText("Bid Failed");
                alert2.setContentText("Item has already been sold.");
                alert2.show();
            }
            if (serverResponse.equals("failure")){
                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert3.setTitle("Error!");
                alert3.setHeaderText("Bid Failed");
                alert3.setContentText("Bid was too low.");
                alert3.show();
            }

        }
    }

    public void bid4OnAction(ActionEvent e)throws IOException{
        String value = pokemon4Textfield.getText();
        if(isANumber(value) == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Amount Bid is Invalid");
            alert.setHeaderText("Payment Error");
            alert.show();
        }
        else{

            String serverResponse = ClientBody.biddingProcess("4,"+value);

            if(serverResponse.equals("success")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Bid exceeded purchase price so the item is now yours!");
                alert.setHeaderText("Item Purchased");
                alert.show();
            }

            if(serverResponse.equals("placed")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Bid Placed");
                alert.setContentText("Bid Successful. You're now the highest bidder!");
                alert.show();
            }
            if(serverResponse.equals("unavailable")){
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error!");
                alert2.setHeaderText("Bid Failed");
                alert2.setContentText("Item has already been sold.");
                alert2.show();
            }
            if (serverResponse.equals("failure")){
                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert3.setTitle("Error!");
                alert3.setHeaderText("Bid Failed");
                alert3.setContentText("Bid was too low.");
                alert3.show();
            }

        }
    }

    public void bid5OnAction(ActionEvent e)throws IOException{
        String value = pokemon5Textfield.getText();
        if(isANumber(value) == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Amount Bid is Invalid");
            alert.setHeaderText("Payment Error");
            alert.show();
        }
        else{

            String serverResponse = ClientBody.biddingProcess("5,"+value);

            if(serverResponse.equals("success")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Bid exceeded purchase price so the item is now yours!");
                alert.setHeaderText("Item Purchased");
                alert.show();
            }

            if(serverResponse.equals("placed")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Bid Placed");
                alert.setContentText("Bid Successful. You're now the highest bidder!");
                alert.show();
            }
            if(serverResponse.equals("unavailable")){
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error!");
                alert2.setHeaderText("Bid Failed");
                alert2.setContentText("Item has already been sold.");
                alert2.show();
            }
            if (serverResponse.equals("failure")){
                Alert alert3 = new Alert(Alert.AlertType.ERROR);
                alert3.setTitle("Error!");
                alert3.setHeaderText("Bid Failed");
                alert3.setContentText("Bid was too low.");
                alert3.show();
            }

        }
    }

    public void buy1OnAction()throws IOException{

        Boolean valid = ClientBody.buyingProcess("1,"+"69");

        if(valid == true){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Buy Successful");
            alert.setContentText("Item was purchased!");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Buy Failed");
            alert.setContentText("Item is Sold Out");
            alert.show();
        }

    }

    public void buy2OnAction()throws IOException{

        Boolean valid = ClientBody.buyingProcess("2,"+"69");

        if(valid == true){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Buy Successful");
            alert.setContentText("Item was purchased!");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Buy Failed");
            alert.setContentText("Item is Sold Out");
            alert.show();
        }
    }

    public void buy3OnAction()throws IOException{

        Boolean valid = ClientBody.buyingProcess("3,"+"69");

        if(valid == true){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Buy Successful");
            alert.setContentText("Item was purchased!");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Buy Failed");
            alert.setContentText("Item is Sold Out");
            alert.show();
        }
    }

    public void buy4OnAction()throws IOException{

        Boolean valid = ClientBody.buyingProcess("4,"+"69");

        if(valid == true){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Buy Successful");
            alert.setContentText("Item was purchased!");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Buy Failed");
            alert.setContentText("Item is Sold Out");
            alert.show();
        }

    }

    public void buy5OnAction()throws IOException{

        Boolean valid = ClientBody.buyingProcess("5,"+"69");

        if(valid == true){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Buy Successful");
            alert.setContentText("Item was purchased!");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Buy Failed");
            alert.setContentText("Item is Sold Out");
            alert.show();
        }

    }

    @FXML
    private Button logOutButton;
    static MediaPlayer bgmusic;
    public void logOutAction(ActionEvent e){
        Platform.exit();
    }

    public void pokedex1OnAction(ActionEvent e){

        Media h = new Media(new File(ClientBody.pokedexSelect1()).toURI().toString());
        bgmusic = new MediaPlayer(h);
        bgmusic.play();
    }

    public void pokedex2OnAction(ActionEvent e){


        Media h = new Media(new File(ClientBody.pokedexSelect2()).toURI().toString());
        bgmusic = new MediaPlayer(h);
        bgmusic.play();
    }

    public void pokedex3OnAction(ActionEvent e){


        Media h = new Media(new File(ClientBody.pokedexSelect3()).toURI().toString());
        bgmusic = new MediaPlayer(h);
        bgmusic.play();
    }

    public void pokedex4OnAction(ActionEvent e){


        Media h = new Media(new File(ClientBody.pokedexSelect4()).toURI().toString());
        bgmusic = new MediaPlayer(h);
        bgmusic.play();
    }

    public void pokedex5OnAction(ActionEvent e){


        Media h = new Media(new File(ClientBody.pokedexSelect5()).toURI().toString());
        bgmusic = new MediaPlayer(h);
        bgmusic.play();
    }

    @FXML
    private Label bidderName1;

    @FXML
    private Label bidderName2;

    @FXML
    private Label bidderName3;

    @FXML
    private Label bidderName4;

    @FXML
    private Label bidderName5;

    @FXML
    private Label finalbid1;

    @FXML
    private Label finalbid2;

    @FXML
    private Label finalbid3;

    @FXML
    private Label finalbid4;

    @FXML
    private Label finalbid5;

    @FXML
    private Label saleStatus1;

    @FXML
    private Label saleStatus2;

    @FXML
    private Label saleStatus3;

    @FXML
    private Label saleStatus4;

    @FXML
    private Label saleStatus5;

    @FXML
    private ImageView pokeballImage;

    @FXML
    private Label UserGreeting;

    public void updateContent() throws IOException {
        String serverRawData = ClientBody.updateUILogic();
        String [] specificItemData = serverRawData.split("~", 6);

        for(int i = 0;i < 5;i++){
            String [] parsedData = specificItemData[i].split(",");

            if(i ==0){ //first pokemon
                pokemon1.setText(parsedData[1]); //skip 0 for first pokemon because of dummy init string
                ClientBody.pokemonname1 = parsedData[1]; //saves what pokemon is in what slot for mp3
                pokemon1Price.setText("Price: "+parsedData[2]); //sets price
                pokemon1Bid.setText("Bid Amount: "+parsedData[3]); //sets bid amount
                if(parsedData[4].equals("sold")){ //if sold then
                    saleStatus1.setText("Sold Out!"); //show sold out!
                    saleStatus1.setAlignment(Pos.CENTER);
                    finalbid1.setText("Sold For "+parsedData[3]); //sold for x amount if sold only

                }
                bidderName1.setText(parsedData[5]); // sets bidder name for highest bidder
                bidderName1.setAlignment(Pos.CENTER);

            }
            if(i ==1){
                pokemon2.setText(parsedData[0]);
                ClientBody.pokemonname2 = parsedData[1];
                pokemon2Price.setText("Price:"+ parsedData[1]); //sets price
                pokemon2Bid.setText("Bid Amount: "+parsedData[2]); //sets bid amount
                if(parsedData[3].equals("sold")){ //if sold then
                    saleStatus2.setText("Sold Out!");
                    saleStatus2.setAlignment(Pos.CENTER);
                    finalbid2.setText("Sold For "+parsedData[2]);
                }
                bidderName2.setText(parsedData[4]); // sets bidder name for highest bidder
                bidderName2.setAlignment(Pos.CENTER);
            }

            if(i ==2){
                pokemon3.setText(parsedData[0]);
                ClientBody.pokemonname3 = parsedData[0];
                pokemon3Price.setText("Price:"+ parsedData[1]); //sets price
                pokemon3Bid.setText("Bid Amount: "+parsedData[2]); //sets bid amount
                if(parsedData[3].equals("sold")){ //if sold then
                    saleStatus3.setText("Sold Out!");
                    saleStatus3.setAlignment(Pos.CENTER);
                    finalbid3.setText("Sold For "+parsedData[2]);
                }
                bidderName3.setText(parsedData[4]); // sets bidder name for highest bidder
                bidderName3.setAlignment(Pos.CENTER);
            }

            if(i ==3){
                pokemon4.setText(parsedData[0]);
                ClientBody.pokemonname4 = parsedData[0];
                pokemon4Price.setText("Price:"+ parsedData[1]); //sets price
                pokemon4Bid.setText("Bid Amount: "+parsedData[2]); //sets bid amount
                if(parsedData[3].equals("sold")){ //if sold then
                    saleStatus4.setText("Sold Out!");
                    saleStatus4.setAlignment(Pos.CENTER);
                    finalbid4.setText("Sold For "+parsedData[2]);
                }
                bidderName4.setText(parsedData[4]); // sets bidder name for highest bidder
                bidderName4.setAlignment(Pos.CENTER);
            }

            if(i ==4){
                pokemon5.setText(parsedData[0]);
                ClientBody.pokemonname5 = parsedData[0];
                pokemon5Price.setText("Price:"+ parsedData[1]); //sets price
                pokemon5Bid.setText("Bid Amount: "+parsedData[2]); //sets bid amount
                if(parsedData[3].equals("sold")){ //if sold then
                    saleStatus5.setText("Sold Out!");
                    saleStatus5.setAlignment(Pos.CENTER);
                    finalbid5.setText("Sold For "+parsedData[2]);
                }
                bidderName5.setText(parsedData[4]); // sets bidder name for highest bidder
                bidderName5.setAlignment(Pos.CENTER);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File pokeball = new File("images/pokeball2.png");
        Image MarketImage = new Image(pokeball.toURI().toString());
        pokeballImage.setImage(MarketImage);

        UserGreeting.setText("Welcome "+ClientBody.getAccountName());
        UserGreeting.setAlignment(Pos.CENTER);

        TimerTask task = new Update();
        Timer timer = new Timer();
        timer.schedule(task,0,1000);
    }

        private class Update extends TimerTask {

            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            updateContent();
                        } catch (IOException e) {
                            System.err.println("IO exception in TimerTask");
                            System.err.println(e.getStackTrace());
                        }
                    }
                });
            }
        }

}
