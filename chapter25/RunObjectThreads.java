package chapter25;

public class RunObjectThreads {
    public static void main(String[] args) {
        RunObjectThreads sample = new RunObjectThreads();
//        sample.checkThreadState();
//        sample.checkThreadState2();
        Thread newThread = new Thread(()->{
            System.out.println("run");
        });
    }

    private void checkThreadState() {
        Object monitor = new Object();
        StateThread stateThread = new StateThread(monitor);
        try {
            System.out.println("thread state = " + stateThread.getState());
            stateThread.start();
            System.out.println("thread state(after start) = " + stateThread.getState());

            Thread.sleep(100);
            System.out.println("thread state(after 0.1sec) = " + stateThread.getState());

            synchronized (monitor) {
                monitor.notify();
            }
            Thread.sleep(100);
            System.out.println("thread state(after notify) = " + stateThread.getState());

            stateThread.join();
            System.out.println("thread state(after join) = " + stateThread.getState());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void checkThreadState2() {
        Object monitor = new Object();
        StateThread thread1 = new StateThread(monitor);
        StateThread thread2 = new StateThread(monitor);
        try {
            System.out.println("thread state = " + thread1.getState());
            thread1.start();
            thread2.start();
            System.out.println("thread state(after start) = " + thread1.getState());

            Thread.sleep(100);
            System.out.println("thread state(after 0.1sec) = " + thread1.getState());

            synchronized (monitor) {
                monitor.notify();
            }
            Thread.sleep(100);
            System.out.println("thread state(after notify) = " + thread1.getState());

            thread1.join();
            System.out.println("thread state(after join) = " + thread1.getState());
            thread2.join();
            System.out.println("thread2 state(after join) = " + thread2.getState());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
