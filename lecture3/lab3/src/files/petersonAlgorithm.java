package files;
import java.util.LinkedList;
import java.util.Queue;
public class petersonAlgorithm {
    private boolean[] flags;
    private Queue<Integer> turns = new LinkedList<>(); // used to see whos turn it is next
    public petersonAlgorithm(){ 
    }
    public void raiseFlag(int threadID){
        flags[threadID] = true;
    }
    public void lowerFlag(int threadID){
        flags[threadID] = false;
    }
    public void queueThread(int threadID){
        turns.add(threadID);
    }
    public void removeThread(int threadID){
        turns.remove();
    }
    public void enterCriticalSection(int threadID){ // this function is used as a entry point to run a critical section
        while (!(turns.peek() == threadID && flags[threadID] == true)){

        }
    }
    
}
