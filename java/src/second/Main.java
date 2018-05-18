package second;



public class Main {


    public static void main(String[] args){
        ThreadDispatcher tD1 = ThreadDispatcher.getInstance();
        tD1.add(new ThreadSleep());
        tD1.add(new ThreadSleep());
        tD1.add(new ThreadSleep());




    }
}
