package matchmaker.input.validator;

import matchmaker.exceptions.NonPositiveAgeException;

public class AgeValidator implements Validator{
    @Override
    public boolean validate(Object property) throws NonPositiveAgeException {
        int age = (int) property;
        if(age <= 0) throw new NonPositiveAgeException("Age cannot be zero or negative");
        return true;
    }
}
