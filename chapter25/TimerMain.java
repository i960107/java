package chapter25;

public class TimerMain {
    public static void main(String[] args) {
        TimerThread timer = new TimerThread();
        timer.start();
    }
}
