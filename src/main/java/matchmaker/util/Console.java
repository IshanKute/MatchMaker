package matchmaker.util;

import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);

    public Console() {
    }

    public void print(String s){
        System.out.println(s);
    }

    public String read() {
        return scanner.nextLine();
    }
}
