package Utils;

public class TestMultiThreading implements Runnable {

    public void run() {
        for (int i = 0; i < 1000000000; i++) {
            System.out.println("My thread" + i);
        }
    }
}
