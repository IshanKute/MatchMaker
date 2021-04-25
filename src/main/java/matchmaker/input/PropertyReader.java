package matchmaker.input;

import matchmaker.util.Console;
import matchmaker.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyReader {
    InputReader inputReader;
    Util util;
    Console console;

    public PropertyReader(InputReader inputReader, Util util, Console console) {
        this.inputReader = inputReader;
        this.util = util;
        this.console = console;
    }

    public <T> List<T> getListProperty(String propertyName, Class<T> type, List<T> options) {
        String input;
        List<T> propertyList = new ArrayList<>();
        do {
            util.printEnterPropertyMessage(propertyName, options.stream().filter(option -> !propertyList.contains(option)).collect(Collectors.toList()));
            T property = inputReader.getValidInput(propertyName, type);
            propertyList.add(property);
            console.print(propertyName + ": " + propertyList.toString());
            console.print("Press any key to continue adding more " + propertyName + " or press 'D' if you are done");
            input = this.console.read();
        } while (!input.equals("d") && !input.equals("D"));
        return propertyList;
    }

    public <T> T getProperty(String propertyName, Class<T> type, List<T> options) {
        util.printEnterPropertyMessage(propertyName, options);
        return inputReader.getValidInput(propertyName, type);
    }
}
