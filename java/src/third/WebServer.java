package third;
import second.ThreadCommand;
import second.ThreadDispatcher;
import first.FileWorker;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private ServerSocket serverSocket = null;
    private ThreadDispatcher threadDispatcher = ThreadDispatcher.getInstance();

    WebServer(String host, int port){
        try {
            serverSocket = new ServerSocket(port, 0, InetAddress.getByName(host));
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start(String path) {
            System.out.println("Start server\nWaiting client command...");
            while (!serverSocket.isClosed()) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    FileWorker fileWorker = new FileWorker(path);
                    System.out.println("Client connect!");
                    threadDispatcher.add(new ThreadCommand(clientSocket,fileWorker));
                    System.out.println(threadDispatcher.getThreads());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
