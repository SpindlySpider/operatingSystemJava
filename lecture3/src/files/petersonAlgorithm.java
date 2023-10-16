package files;

public class petersonAlgorithm {
    volatile static private boolean[] flags = new boolean[2];// we can only have 2 threads in this position
    volatile static public int turn = 0; // used to see whos turn it is next
    public petersonAlgorithm(){ 
    }
    public void addFlag(int threadID){
        flags[threadID] = false;
    }
    public void raiseFlag(int threadID){
        flags[threadID] = true;
    }
    public void lowerFlag(int threadID){
        flags[threadID] = false;
    }
    public void setTurn(int threadID){
        turn = threadID;
    }
    public boolean enterCriticalSection(int threadID){ // this function is used as a entry point to run a critical section
            if (turn == threadID && flags[threadID] == true){

                return true;
            }
            else{
                return false;
            }

        
    }
    
}
