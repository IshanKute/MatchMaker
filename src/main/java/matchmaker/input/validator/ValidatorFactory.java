package matchmaker.input.validator;

public class ValidatorFactory {
    public ValidatorFactory() {}

    public Validator getValidator(String type) {
        switch (type) {
            case "Full name":
            case "Hobbies":
                return new FullNameValidator();
            case "Age":
            case "Partner's preferred minimum age":
            case "Partner's preferred maximum age":
                return new AgeValidator();
            default: return new DefaultValidator();
        }
    }
}
