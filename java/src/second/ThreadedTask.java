package second;


abstract class ThreadedTask implements Runnable {

    @Override
    public void run(){
        work();
        finish();
    }
    abstract void work();

    private void finish() {
        ThreadDispatcher threadDispatcher = ThreadDispatcher.getInstance();
        threadDispatcher.delete(Thread.currentThread());
    }
}
