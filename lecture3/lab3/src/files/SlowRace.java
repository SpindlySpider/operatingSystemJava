package files;
import files.petersonAlgorithm;

public class SlowRace {
public static void main(String args []) throws Exception { 
petersonAlgorithm peterson = new petersonAlgorithm();
MyThread.count = 0;
MyThread thread1 = new MyThread();
thread1.name = "A";
thread1.threadNumber =0;
MyThread thread2 = new MyThread();
thread2.name = "B";
thread2.threadNumber = 1;

thread1.start();
thread2.start();
thread2.join();
thread1.join();
System.out.println("MyThread.count = " + MyThread.count);
}
}

class MyThread extends Thread { 
volatile static int count;
String name;
int threadNumber;
petersonAlgorithm obj;

public MyThread(petersonAlgorithm peter){
     obj = peter;

}

public void run() {
for(int i = 0 ; i < 10 ; i++) { 
     obj.queueThread(threadNumber);
     obj.raiseFlag(threadNumber);
delay();
int x = count;
System.out.println("Thread " + name + " read " + x);
delay();
count = x + 1;
System.out.println("Thread " + name + " wrote " + (x + 1));
}
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
