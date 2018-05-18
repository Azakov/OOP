package second;

public class ThreadSleep extends ThreadedTask {

    @Override
    public void work() {
        try {

            Thread.sleep(10000);
            System.out.println("end");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

