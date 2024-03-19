package chapter25;

/*
 * Object 클래스에 선언된 쓰레드와 관련있는 메소드들
 * */
public class StateThread extends Thread {
    private Object monitor;

    public StateThread(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            for (int loop = 0; loop < 10000; loop++) {
                String a = "A";
            }
            synchronized (monitor) {
                monitor.wait();
            }
            // Thread.getName()
            System.out.println(getName() + " is notified");
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
