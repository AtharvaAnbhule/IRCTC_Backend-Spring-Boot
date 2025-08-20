


public class Server {
private final ExecutorService threadPool ;

public Service(int poolSize){
    this.threadPool = Executors.newFixedThreadPool(poolSize) ;

    public void handleClient(Socket clientSocket){
        try (PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(),autoFlash:true) ){
            toSocket.println("Hello from server"+clientSocket.getInetAddress()) ;

        } catch(IOException ex){
            ex.printStackTrace() ;
        }
 }


    public static void main(String[] args){
    int port = 8010 ;
    int poolSize = 10 ;
    final Server server = new Server(poolSize) ;


    try {
        ServerSocket serverSocket = new ServerSocket(port) ;
        serverSocket.setSoTimeout(70000) ;
        System.out.println("Server is listening on port"+port) ;

        while(true){
            final Socket clientSocket = serverSocket.accept() ;
            server.threadPool.execute(() -> server.handleClient(clientSocket)) ;
    }
    } catch(IOException ex) {
                ex.printStackTrace() ;
    } finally {
        server.threadPool.shutdown() ;
    }
    }
}