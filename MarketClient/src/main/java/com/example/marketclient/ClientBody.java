package com.example.marketclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

public class ClientBody {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 1234;
    private static Socket socket;
    private static String accountName;
    public static String pokemonname1;
    public static String pokemonname2;
    public static String pokemonname3;
    public static String pokemonname4;
    public static String pokemonname5;

    static {
        try {
            socket = new Socket(SERVER_IP,SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedReader input;

    static {
        try {
            input = new BufferedReader(new InputStreamReader((socket.getInputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PrintWriter out;

    static {
        try {
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientBody() throws IOException {
    }

    public static boolean loginValidation(String username, String password) throws IOException, NoSuchAlgorithmException {
        String data = "login,"+username+","+MD5Encryption.encryptPassword(password);
        out.println(data);
        out.flush();

        String serverResponse = input.readLine();
        if(serverResponse.equals("success")){

            accountName = username; //saves username
            return true;
        }
        else{
            return false;
        }

    }

    public static boolean registerClient(String loginData) throws IOException {
        out.println("register,"+loginData);

        String serverResponse = input.readLine();

        if(serverResponse.equals("success")){
            return true;
        }
        return false;

    }

    public static String biddingProcess(String value) throws IOException {
        out.println("bid,"+value+","+accountName);

        String serverResponse = input.readLine();

        return serverResponse;
    }

    public static Boolean buyingProcess(String value) throws IOException{
        out.println("buy,"+value+","+accountName);

        String serverResponse = input.readLine();

        if(serverResponse.equals("success")){
            return true;
        }
        else{
            return false;
        }
    }

    public static String getAccountName(){
        return accountName;
    }

    public static String updateUILogic() throws IOException {
        out.println("ping");
        String serverResponse = input.readLine();
        return serverResponse;
    }

    public static String pokedexSelect1(){
        if(pokemonname1.equals("Rayquaza")){
            return "SoundEffects/Rayquaza Pokedex.mp3";
        }
        if(pokemonname1.equals("Charizard")){
            return "SoundEffects/Charizard Pokedex.mp3";
        }
        if(pokemonname1.equals("Celebi")){
            return "SoundEffects/Celebi Pokedex.mp3";
        }
        if(pokemonname1.equals("Cyndaquil")){
            return "SoundEffects/Cyndaquil Pokedex.mp3";
        }
        if(pokemonname1.equals("Bidoof")){
            return "SoundEffects/Bidoof Pokedex.mp3";
        }
        if(pokemonname1.equals("Lapras")){
            return "SoundEffects/Lapras.mp3";
        }
        if(pokemonname1.equals("Pidgy")){
            return "SoundEffects/Pidgy.mp3";
        }
        if(pokemonname1.equals("Piplup")){
            return "SoundEffects/Piplup.mp3";
        }
        if(pokemonname1.equals("Chikorita")){
            return "SoundEffects/Chikorita.mp3";
        }
        else{
            return "SoundEffects/Ditto.mp3";
        }
    }

    public static String pokedexSelect2(){
        if(pokemonname2.equals("Rayquaza")){
            return "SoundEffects/Rayquaza Pokedex.mp3";
        }
        if(pokemonname2.equals("Charizard")){
            return "SoundEffects/Charizard Pokedex.mp3";
        }
        if(pokemonname2.equals("Celebi")){
            return "SoundEffects/Celebi Pokedex.mp3";
        }
        if(pokemonname2.equals("Cyndaquil")){
            return "SoundEffects/Cyndaquil Pokedex.mp3";
        }
        if(pokemonname2.equals("Bidoof")){
            return "SoundEffects/Bidoof Pokedex.mp3";
        }
        if(pokemonname2.equals("Lapras")){
            return "SoundEffects/Lapras.mp3";
        }
        if(pokemonname2.equals("Pidgy")){
            return "SoundEffects/Pidgy.mp3";
        }
        if(pokemonname2.equals("Piplup")){
            return "SoundEffects/Piplup.mp3";
        }
        if(pokemonname2.equals("Chikorita")){
            return "SoundEffects/Chikorita.mp3";
        }
        else{
            return "SoundEffects/Ditto.mp3";
        }
    }

    public static String pokedexSelect3(){
        if(pokemonname3.equals("Rayquaza")){
            return "SoundEffects/Rayquaza Pokedex.mp3";
        }
        if(pokemonname3.equals("Charizard")){
            return "SoundEffects/Charizard Pokedex.mp3";
        }
        if(pokemonname3.equals("Celebi")){
            return "SoundEffects/Celebi Pokedex.mp3";
        }
        if(pokemonname3.equals("Cyndaquil")){
            return "SoundEffects/Cyndaquil Pokedex.mp3";
        }
        if(pokemonname3.equals("Bidoof")){
            return "SoundEffects/Bidoof Pokedex.mp3";
        }
        if(pokemonname3.equals("Lapras")){
            return "SoundEffects/Lapras.mp3";
        }
        if(pokemonname3.equals("Pidgy")){
            return "SoundEffects/Pidgy.mp3";
        }
        if(pokemonname3.equals("Piplup")){
            return "SoundEffects/Piplup.mp3";
        }
        if(pokemonname3.equals("Chikorita")){
            return "SoundEffects/Chikorita.mp3";
        }
        else{
            return "SoundEffects/Ditto.mp3";
        }
    }

    public static String pokedexSelect4(){
        if(pokemonname4.equals("Rayquaza")){
            return "SoundEffects/Rayquaza Pokedex.mp3";
        }
        if(pokemonname4.equals("Charizard")){
            return "SoundEffects/Charizard Pokedex.mp3";
        }
        if(pokemonname4.equals("Celebi")){
            return "SoundEffects/Celebi Pokedex.mp3";
        }
        if(pokemonname4.equals("Cyndaquil")){
            return "SoundEffects/Cyndaquil Pokedex.mp3";
        }
        if(pokemonname4.equals("Bidoof")){
            return "SoundEffects/Bidoof Pokedex.mp3";
        }
        if(pokemonname4.equals("Lapras")){
            return "SoundEffects/Lapras.mp3";
        }
        if(pokemonname4.equals("Pidgy")){
            return "SoundEffects/Pidgy.mp3";
        }
        if(pokemonname4.equals("Piplup")){
            return "SoundEffects/Piplup.mp3";
        }
        if(pokemonname4.equals("Chikorita")){
            return "SoundEffects/Chikorita.mp3";
        }
        else{
            return "SoundEffects/Ditto.mp3";
        }
    }

    public static String pokedexSelect5(){
        if(pokemonname5.equals("Rayquaza")){
            return "SoundEffects/Rayquaza Pokedex.mp3";
        }
        if(pokemonname5.equals("Charizard")){
            return "SoundEffects/Charizard Pokedex.mp3";
        }
        if(pokemonname5.equals("Celebi")){
            return "SoundEffects/Celebi Pokedex.mp3";
        }
        if(pokemonname5.equals("Cyndaquil")){
            return "SoundEffects/Cyndaquil Pokedex.mp3";
        }
        if(pokemonname5.equals("Bidoof")){
            return "SoundEffects/Bidoof Pokedex.mp3";
        }
        if(pokemonname5.equals("Lapras")){
            return "SoundEffects/Lapras.mp3";
        }
        if(pokemonname5.equals("Pidgy")){
            return "SoundEffects/Pidgy.mp3";
        }
        if(pokemonname5.equals("Piplup")){
            return "SoundEffects/Piplup.mp3";
        }
        if(pokemonname5.equals("Chikorita")){
            return "SoundEffects/Chikorita.mp3";
        }
        else{
            return "SoundEffects/Ditto.mp3";
        }
    }

}
