import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//Create the class client
public class Client implements Runnable{
    //creation of private variables
    private int port;
    private String message;
    private int chat;
    //Function that assigns the port and message values
    public Client (String message, int port, int chat){
        this.message = message;
        this.port = port;
        this.chat = chat;
        System.out.println("Client port " + port);
    }
    //Function that creates and connects to the socket
    public void run() {
        for(int i=1;i<= chat; i+=1){
            if(5000+i != port){
                System.out.println("Send message to " + (i+5000));
                //Create the constant String HOST
                final String HOST = "127.0.0.1";
                DataOutputStream out;
                //Try to connect to socket
                try{
                    //Create a new socket
                    Socket sc = new Socket(HOST, (i+5000));
                    //Create the out data
                    out = new DataOutputStream(sc.getOutputStream());
                    //Write the message
                    out.writeUTF(message);
                    //Close the socket
                    sc.close();
                }
                //Catch method
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}