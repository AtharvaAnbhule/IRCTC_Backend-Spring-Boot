package multithreaded ;

import java.io.* ;
import java.net.* ;


public class Client {
    public Runnable getRunnable(){
        return new Runnable(){
            @Override
            public void run(){
                int port = 0010;


                    try {
                        InetAddress address = InetAddress.getByName("localhost") ;
                        Socket socket = new Socket(address,port) ;
                        try {
                            PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),autoFlash:true) ;
                            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        } {

                    toSocket.println("Hello from client"+socket.getLocalSocketAddress()) ;
                    String line = fromSocket.readLine() ;
                            System.out.println("Response from Server"+line) ;
                        } catch(IOException e){
                               e.printStackTrace() ;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

            }
        }
    }
    public
    public static void main(String[] args){
        Client client = new Client() ;
        for( int i = 0 ; i<100 ; i++) {
            try {
                Thread thread = new Thread(client.getRunnable()) ;
                thread.start() ;
            }
            catch (Exception ex) {
                return;
            }
        }
    }
}