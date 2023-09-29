package helloWorld;
import java.text.MessageFormat;

import helloWorld.randomInt;

public class App {
    public static void main(String[] args) throws Exception {
        int randomNumber = randomInt.randomint();
        System.out.println(MessageFormat.format("{0}", randomNumber));
        Thread.sleep(randomNumber);
        System.out.println("boop");
    }
}

