package first;


public class Main {
    public static void main(String[] args){
        System.out.println("start");
        FileWorker  FW = new  FileWorker("C:\\Users\\Go-go\\Desktop\\Java 4 семестр");
        FW.execute(new Md5Executor());
        System.out.print("end");
    }
}
