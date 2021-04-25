package matchmaker.exceptions;

public class NonPositiveAgeException extends ValidatorException {
    public NonPositiveAgeException(String message) {
        super(message);
    }
}
