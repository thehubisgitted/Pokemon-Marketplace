import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
public class Server {
    private static final int PORT = 1234;
    public static ArrayList<ClientHandler> clients = new ArrayList<>(); // Client Handler List
    public static ArrayList<itemObject> itemList = new ArrayList<>(); // item List
    public static HashMap<String, String> loginInfo = new HashMap<>(); //hashmap w username key / passwords
        
    public static void initializeItemList() throws FileNotFoundException{
      File file = new File("src\\items.csv");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String[] listInfo = scanner.nextLine().split(",");
            itemObject item = new itemObject(listInfo);
            itemList.add(item);
        }

    }

    
       
    public static void main(String[] args) throws IOException{

      initializeItemList();
      ServerSocket listener = new ServerSocket(PORT);
      
      while(true){
        
        System.out.println("Server Waiting for Client Connection");
        Socket client = listener.accept();
        System.out.println("Server Connected to Client!");
        
        ClientHandler clientThread = new ClientHandler(client);
        Thread t = new Thread(clientThread);
        clients.add(clientThread);
        t.start();
      }
      
    }

    
}
