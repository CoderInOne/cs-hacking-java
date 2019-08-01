package cs.hacking.jvm;

public class DeadLockTest {
    private static final Object A = new Object();
    private static final Object B = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(100);

                synchronized (A) {
                    sleep(200);

                    synchronized (B) {

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(50);

                synchronized (B) {
                    sleep(200);

                    synchronized (A) {

                    }
                }
            }
        }).start();
    }

    private static void sleep(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
