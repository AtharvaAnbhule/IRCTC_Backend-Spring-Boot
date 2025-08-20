package app ;


import java.io.* ;
import java.net.* ;

public class Client {
    public void run() throws UnknownHostException, IOException {
        int port = 8010;
        InetAddress address = InetAddress.getByName(host:"localhost");
        Socket socket = new Socket(address, port);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello from the client");
        String line = fromSocket.readerLine();
        System.out.println("Response from the socket is : " + line);
toSocket.close() ;
fromSocket.close() ;
socket.close() ;
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.run();
        } catch (Exception ex) {
            ex.printStackTrave();
        }
    }
}
