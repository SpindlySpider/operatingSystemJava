import java.util.concurrent.*;
public class Peterson {

    public static void main(String args []) throws Exception { 
    MyThread.count = 0;
    MyThread thread1 = new MyThread() ; thread1.name = "A";
    thread1.id = 0;
    

    MyThread thread2 = new MyThread() ; thread2.name = "B";
    thread2.id = 1;

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println("MyThread.count = " + MyThread.count);
    }
}

class MyThread extends Thread { 
    volatile static int count;
    static Semaphore mySemaphore = new Semaphore(1);
    String name ;
    int id ;
    public void run() { 
        try {
            for(int i = 0 ; i < 120 ; i++) { 
                delay() ;
                mySemaphore.acquire();	// P - decrease semaphore 
                delay() ;
                int x = count ;
                System.out.println("Thread " + name + " read " + x);
                delay() ;
                count = x + 1 ;
                System.out.println("Thread " + name + " wrote " + (x + 1));
                mySemaphore.release();	// V - increase semaphore
            }

        }
        catch(Exception e) {}
    }

    void delay() {
        int delay = (int) (1000 * Math.random());
        try {
        Thread.sleep(delay);
        }
        catch(Exception e) {
        }
    }
}

