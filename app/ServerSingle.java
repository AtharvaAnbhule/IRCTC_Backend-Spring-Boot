package app ;
import java.io.* ;
import java.net.* ;

public class Server {
    public void run() throws IOException {
        int port = 0010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while (true) {
            try {
                System.out.println("Server is listening on port" + port);
                Socket accpetedConnection = socket.accept();
                System.out.println("Connection accepted from client" + accpetedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(accpetedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(accpetedConnection.getInputStream()));
                toClient.println("Hello from the server");
                toClient.close() ;
                fromClient.close() ;
                accpetedConnection.close() ;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server new Server();
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}