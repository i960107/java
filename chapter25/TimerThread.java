package chapter25;

import java.util.Date;

public class TimerThread extends Thread {
    @Override
    public void run() {
        printCurrentTime();
    }

    private void reduceTimeGap() {
        long currentTime = System.currentTimeMillis();
        long timeMod = currentTime % 1000;
        try {
            Thread.sleep(1000 - timeMod);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void printCurrentTime() {
        int count = 0;
        try {
            while (count < 10) {
                long timeMillis = System.currentTimeMillis();
                System.out.printf("current time(%d) = %s, currentTimeMillis = %s\n",
                        count,
                        new Date(timeMillis),
                        timeMillis);
                Thread.sleep(900); // 총 1000초를 쉬기 위해서 100밀리초동안 연산할 거리 남아있음
                reduceTimeGap();
                count++;
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
