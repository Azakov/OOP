package third;

public class ServerStart {
    public static void main(String[] args){

        WebServer ws = new WebServer("127.0.0.1", 40000);
        ws.start("C:\\Users\\Go-go\\Desktop\\Java 4 семестр");
    }
}
