package ThreadsExample;

class PriorityThread extends Thread {
    public PriorityThread(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PriorityExample {
    public static void main(String[] args) {
        PriorityThread highPriorityThread = new PriorityThread("High Priority Thread", Thread.MAX_PRIORITY);
        PriorityThread normalPriorityThread = new PriorityThread("Normal Priority Thread", Thread.NORM_PRIORITY);
        PriorityThread lowPriorityThread = new PriorityThread("Low Priority Thread", Thread.MIN_PRIORITY);

        highPriorityThread.start();
        normalPriorityThread.start();
        lowPriorityThread.start();
    }
}
