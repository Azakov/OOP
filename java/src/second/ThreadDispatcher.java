package second;
import java.util.HashSet;


public  class  ThreadDispatcher {


    private HashSet<Thread> currentThreads;
    private ThreadMonitor monitor;
    private static ThreadDispatcher instance;

    public synchronized static ThreadDispatcher getInstance() {
        if (instance == null)
            instance =  new ThreadDispatcher();
        return instance;
    }

    private ThreadDispatcher(){
        System.out.println(instance);
        currentThreads = new HashSet<Thread>();
        monitor = new ThreadMonitor();
        add(monitor);
    }

    public synchronized void add(ThreadedTask task){
        Thread thread = new Thread(task);
        thread.start();
        currentThreads.add(thread);
        System.out.println(currentThreads);
        monitor.updateTrue();
    }



    public  HashSet<Thread> getThreads(){
        return currentThreads;
    }

    public synchronized void delete(Thread thread){
       System.out.println(thread + " " + thread.getId() + " gg ");
        currentThreads.remove(thread);
        monitor.updateTrue();
    }

}
