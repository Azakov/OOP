package third;

import java.io.*;
import java.net.Socket;

public class WebClient {

    private String host;
    private int port;

    WebClient(String host, int port){
        this.host = host;
        this.port = port;
    }
    public void start() {


        try {
            System.out.println("Write something command");
            Socket socket = new Socket(host, port);
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line;
        while (!socket.isClosed()){
            line = keyboard.readLine();
            System.out.println("Send to server...");
            out.writeUTF(line);
            line = in.readUTF();
            System.out.println(line);
            if (line.equals("Stop client")) {
                socket.close();
            }
        }
            System.out.println("End of client-thread");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
