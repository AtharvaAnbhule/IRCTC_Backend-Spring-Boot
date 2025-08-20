
import java.net.* ;

public class Server {

    public Consumer<Socket> getConsumer(){
        return (clientSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream()) ;
                toClient.println("Hello from the server") ;
                toClient.close() ;
                clientSocket.close() ;

            } catch (IOException ex) {
               ex.printStackTrace() ;
            }
        }
    }
    public static void main(String[] args){
        int port = 8010 ;
        Server server = new Server() ;
        try {
            ServerSocket serverSocket = new ServerSocket(port) ;
            serverSocket.setSoTimeout(10000) ;
            System.out.println("Server is running on port"+port) ;
            while(true){
                final Socket acceptedSocket = serverSocket.accept() ;
Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket)) ;
                thread.start() ;
            }
        } catch (IOExeption ex) {
            ex.printStackTrace();
        }
    }
}