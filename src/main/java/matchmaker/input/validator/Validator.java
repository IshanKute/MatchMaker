package matchmaker.input.validator;

import matchmaker.exceptions.ValidatorException;

public interface Validator {
    boolean validate(Object property) throws ValidatorException;
}
