package ThreadsExample;

class NumberPrinter extends Thread {
    private int start;
    private int end;
    private long intervalMillis;

    public NumberPrinter(int start, int end, long intervalMillis) {
        this.start = start;
        this.end = end;
        this.intervalMillis = intervalMillis;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Threads {
    public static void main(String[] args) {
        Thread thread1 = new NumberPrinter(1, 10, 500); // Thread for numbers 1 to 10 at 0.5-second intervals
        Thread thread2 = new NumberPrinter(11, 20, 1000); // Thread for numbers 11 to 20 at 1-second intervals

        thread1.start();
        thread2.start();
    }
}
