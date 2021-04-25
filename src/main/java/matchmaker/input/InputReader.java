package matchmaker.input;

import matchmaker.exceptions.CastException;
import matchmaker.exceptions.ValidatorException;
import matchmaker.input.validator.ValidatorFactory;
import matchmaker.util.Console;
import matchmaker.util.Util;

public class InputReader {
    Console console;
    Util util;

    public InputReader(Console console, Util util) {
        this.console = console;
        this.util = util;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValidInput(String propertyName, Class<T> type) {
        ValidatorFactory validatorFactory = new ValidatorFactory();
        boolean propertyIsValid = false;
        Object property = null;
        while(!propertyIsValid) {
            try {
                property = util.cast(this.console.read(), type);
                propertyIsValid = validatorFactory.getValidator(propertyName).validate(property);
            } catch (ValidatorException | CastException e) {
                console.print(e.getMessage());
                console.print("Please enter again: ");
            }
        }
        return (T) property;
    }
}
