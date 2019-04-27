package core.Thread;

//Deadlock in multi-threading describes a situation where two or more threads are blocked forever, waiting for each other.

//https://netjs.blogspot.com/2015/07/deadlock-in-java-multi-threading.html

public class DeadLockDemo {

    private final String name;

    public DeadLockDemo(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public synchronized void call(DeadLockDemo caller){
        System.out.println(this.getName() + " has asked to call me " + caller.getName());
        try {
            // Introducing some delay
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Calling another synchronized method
        caller.callMe(this);
    }

    public synchronized void callMe(DeadLockDemo caller){
        System.out.println(this.getName() + " has called me " + caller.getName());
    }

    public static void main(String[] args) {
        DeadLockDemo caller1 = new DeadLockDemo("caller-1");
        DeadLockDemo caller2 = new DeadLockDemo("caller-2");
        // Thread 1
        new Thread(new Runnable() {
            public void run() { caller1.call(caller2); }
        }).start();

        //Thread 2
        new Thread(new Runnable() {
            public void run() { caller2.call(caller1); }
        }).start();
    }
}