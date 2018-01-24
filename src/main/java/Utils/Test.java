package Utils;

public class Test {


    @org.testng.annotations.Test
    public void testMTTH() {
        TestMultiThreading testMultiThreading = new TestMultiThreading();

        Thread thread = new Thread(testMultiThreading);
        thread.start();

        for (int i= 0; i < 1000000000; i ++) {
            System.out.println("VLADIS");
        }
    }

}
