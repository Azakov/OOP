package second;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;


public class ThreadMonitor extends ThreadedTask {


    private volatile boolean update = false;
    @Override
    public void work() {
        ThreadDispatcher threadDispatcher = ThreadDispatcher.getInstance();
        while (true){
            try {
                if (update){
                    record(threadDispatcher.getThreads());
                    update = false;
                }
                    Thread.sleep(1000);
                System.out.println(threadDispatcher.getThreads());

                } catch ( InterruptedException exception){
                    exception.printStackTrace();
                }
        }
    }

    public void  updateTrue(){
        update = true;
    }

    private synchronized void record( Set<Thread> threads){
        try {
            for (Thread thread :threads){
                FileWriter fileWriter = new FileWriter("D:\\java\\src\\second\\currentThreads.txt");
                fileWriter.write(thread +" " + thread.getId()+ "\n");
                fileWriter.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
