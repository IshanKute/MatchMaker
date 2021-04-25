package matchmaker.input;

import matchmaker.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleOperator {
    Scanner sc = new Scanner(System.in);
    ConsoleInput consoleInput;
    Util util;

    public ConsoleOperator(ConsoleInput consoleInput, Util util) {
        this.consoleInput = consoleInput;
        this.util = util;
    }

    public <T> List<T> getListProperty(String propertyName, Class<T> type, List<T> options) {
        String input;
        List<T> propertyList = new ArrayList<>();
        do {
            util.printEnterPropertyMessage(propertyName, options.stream().filter(option -> !propertyList.contains(option)).collect(Collectors.toList()));
            T property = consoleInput.getValidInput(propertyName, type);
            propertyList.add(property);
            util.print(propertyName + ": " + propertyList.toString());
            util.print("Press any key to continue adding more " + propertyName + " or press 'D' if you are done");
            input = this.sc.nextLine();
        } while (!input.equals("d") && !input.equals("D"));
        return propertyList;
    }

    public <T> T getProperty(String propertyName, Class<T> type, List<T> options) {
        util.printEnterPropertyMessage(propertyName, options);
        return consoleInput.getValidInput(propertyName, type);
    }
}
