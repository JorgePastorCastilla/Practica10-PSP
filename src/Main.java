import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        Hilo hiloa = new Hilo('a','A');
        Hilo hiloe = new Hilo('e','E');
        Hilo hiloi = new Hilo('i','I');
        Hilo hiloo = new Hilo('o','O');
        Hilo hilou = new Hilo('u','U');

        hiloa.start();
        hiloe.start();
        hiloi.start();
        hiloo.start();
        hilou.start();
    }

}
