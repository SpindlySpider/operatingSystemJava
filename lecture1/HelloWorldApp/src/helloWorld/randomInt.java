package helloWorld;


public class randomInt {
    public static Integer randomint(){
        double random = Math.random()*5000;
        int interger = (int) (random+0.5);
        return interger;
    }
}
