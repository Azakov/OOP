package third;

public class ClientStart {
    public static void main(String[] args){

        WebClient wc = new WebClient("127.0.0.1", 40000);
        wc.start();
    }
}
