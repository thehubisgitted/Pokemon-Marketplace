import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private Socket client;
    BufferedReader in;
    PrintWriter out;
    Object database = new Object();
    Object items = new Object();

    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    public void updateHashMap() throws FileNotFoundException {
        File file = new File("src\\passwordDatabase.csv");
        Scanner scanner = new Scanner(file);
        Server.loginInfo.clear();
        Server.loginInfo = new HashMap<>();

        while (scanner.hasNext()) {
            String[] usernameAndPassword = scanner.nextLine().split(",");
            Server.loginInfo.put(usernameAndPassword[0], usernameAndPassword[1]);
        }
        scanner.close();

    }

    public void loginValidationProcess(String data) throws FileNotFoundException {
        synchronized (database) {
            updateHashMap(); // updates passwords/usernames in case theres a change
            String[] processedData = data.split(",", 2);
            String username = processedData[0];
            String encryptedpassword = processedData[1];
            String savedPassword = Server.loginInfo.get(username);
            if (encryptedpassword.equals(savedPassword)) {
                out.println("success");
                System.out.println("Password Matches");
            } else {
                out.println("failure");
                System.out.println("Password Failed");
            }
        }
    }

    public void registrationProcess(String data) throws IOException {
        synchronized(database){
        updateHashMap(); // updates passwords/usernames
        String[] processedData = data.split(",", 2);
        String username = processedData[0];
        String encryptedpassword = processedData[1];

        if (Server.loginInfo.containsKey(username)) {
            out.println("duplicate");
            System.out.println("Duplicate Found");
        } else {
            BufferedWriter writer = new BufferedWriter(new FileWriter(
                    "C:\\Users\\Kenpi\\Documents\\Java\\MarketServer\\MarketServer\\src\\passwordDatabase.csv", true));

            writer.write(username + "," + encryptedpassword + "\n");
            writer.close();
            out.println("success");
            System.out.println("Successful Registration!");
        }
    }

    }

    public void buyingProcess(String data){
        synchronized(items){

            String[] processedData = data.split(",", 3);
            String itemNumber = processedData[0];
            String accountName = processedData[2];

            int index = Integer.parseInt(itemNumber) - 1;

            String availability = Server.itemList.get(index).availability;
            if (availability.equals("sold")) {
                out.println("unavailable");
                System.out.println("item already sold");
            }
            else{
                Server.itemList.get(index).availability = "sold";
                String price = Server.itemList.get(index).price;
                Server.itemList.get(index).bidAmount = price;
                Server.itemList.get(index).highestBidder = accountName;
                out.println("success");
                System.out.println("Item Bought Successful (BUY TRANSACTION)");
            }
        }
    }

    public void biddingProcess(String data) throws FileNotFoundException {
        synchronized(items){
        
        String[] processedData = data.split(",", 3);
        String itemNumber = processedData[0];
        String value = processedData[1];
        String accountName = processedData[2];

        int index = Integer.parseInt(itemNumber) - 1;

        String availability = Server.itemList.get(index).availability;

        if (availability.equals("sold")) {
            out.println("unavailable");
            System.out.println("item already sold");
        } else {
            String price = Server.itemList.get(index).price;
            String bidAmount = Server.itemList.get(index).bidAmount;

            double valueDouble = Double.parseDouble(value);
            double priceDouble = Double.parseDouble(price);
            double bidAmountDouble = Double.parseDouble(bidAmount);

            if (valueDouble >= priceDouble) {
                Server.itemList.get(index).availability = "sold";
                Server.itemList.get(index).bidAmount = String.valueOf(valueDouble);
                Server.itemList.get(index).highestBidder = accountName;
                out.println("success"); // if sold need to record who bought it (could make it so if login successful
                                        
                System.out.println("Bid Higher than Price, Success");
            } else if (valueDouble > bidAmountDouble) {
                Server.itemList.get(index).bidAmount = String.valueOf(valueDouble);
                Server.itemList.get(index).highestBidder = accountName;
                out.println("placed");
                System.out.println("bid sucessfully placed");
                // if bid is higher than current bid need to update bid value
            } else {
                out.println("failure");
                System.out.println("bid price too low");
            }
        }
        }
    }

    public void updateProcess(){
        String itemListString = "data,";
        for(itemObject item: Server.itemList){
            itemListString = itemListString+item.name+",";
            itemListString = itemListString+item.price+",";
            itemListString = itemListString+item.bidAmount+",";
            itemListString = itemListString+item.availability+",";
            itemListString = itemListString+item.highestBidder+"~";

        }
        //System.out.println(itemListString);
        out.println(itemListString);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String clientMessage = in.readLine();
                
                if (clientMessage.contains("login,")) {
                    System.out.println("login msg recieved");
                    String[] rawData = clientMessage.split(",", 3);
                    String data = rawData[1] + "," + rawData[2];
                    loginValidationProcess(data);

                }

                if (clientMessage.contains("register,")) {
                    String[] rawData = clientMessage.split(",", 3);
                    String data = rawData[1] + "," + rawData[2];
                    registrationProcess(data);
                    // checks if hashmap has username already registerd if so send msg error back
                    // otherwise register user into hashmap/csv
                }

                if (clientMessage.contains("bid,")) {
                    String[] rawData = clientMessage.split(",", 4);
                    String data = rawData[1] + "," + rawData[2]+","+rawData[3];
                    biddingProcess(data);
                }

                if(clientMessage.contains("buy,")){
                    String[] rawData = clientMessage.split(",",4);
                    String data = rawData[1] + "," + rawData[2]+","+rawData[3];
                    buyingProcess(data);
                }

                if(clientMessage.contains("ping")){
                    updateProcess();
                }
            }
        } catch (IOException e) {
            System.err.println("IO exception in Handler");
            System.err.println(e.getStackTrace());
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
