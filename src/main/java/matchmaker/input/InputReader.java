package matchmaker.input;

import matchmaker.exceptions.CastException;
import matchmaker.exceptions.ValidatorException;
import matchmaker.input.validator.ValidatorFactory;
import matchmaker.util.Util;

import java.util.Scanner;


public class InputReader {
    Scanner sc = new Scanner(System.in);
    Util util;

    public InputReader(Util util) {
        this.util = util;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValidInput(String propertyName, Class<T> type) {
        ValidatorFactory validatorFactory = new ValidatorFactory();
        boolean propertyIsValid = false;
        Object property = null;
        while(!propertyIsValid) {
            try {
                property = util.cast(this.sc.nextLine(), type);
                propertyIsValid = validatorFactory.getValidator(propertyName).validate(property);
            } catch (ValidatorException | CastException e) {
                util.print(e.getMessage());
                util.print("Please enter again: ");
            }
        }
        return (T) property;
    }
}
