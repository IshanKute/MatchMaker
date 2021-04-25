package matchmaker.input.validator;

import matchmaker.exceptions.EmptyStringException;
import matchmaker.exceptions.NonAlphabeticCharacterException;

public class FullNameValidator implements Validator {
    @Override
    public boolean validate(Object property) throws EmptyStringException, NonAlphabeticCharacterException {
        String fullName = (String) property;
        if (fullName.length() <= 0) throw new EmptyStringException("Full-name cannot be empty");
        if (!fullName.matches("^[a-zA-Z ]*$")) throw new NonAlphabeticCharacterException("Full-name cannot contain non-alphabetic characters");
        return true;
    }
}
