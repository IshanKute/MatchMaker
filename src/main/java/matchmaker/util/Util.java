package matchmaker.util;

import matchmaker.exceptions.CastException;
import matchmaker.models.*;

import java.util.List;

public class Util {
    Console console;

    public Util(Console console) {
        this.console = console;
    }

    @SuppressWarnings("unchecked")
    public <T> Object cast(String nextLine, Class<T> type) throws CastException {
        String typeSimpleName = type.getSimpleName();
        try {
            switch(typeSimpleName) {
                case "String": return nextLine;
                case "Integer": return Integer.parseInt(nextLine);
                case "Gender": return Gender.valueOf(nextLine);
                case "Profession": return Profession.valueOf(nextLine);
                case "District": return District.valueOf(nextLine);
                default: return (T) nextLine;
            }
        }
        catch (Exception e) {
            String additionalMessage;
            if(typeSimpleName.equals("Gender") || typeSimpleName.equals("Profession") || typeSimpleName.equals("District"))
                additionalMessage = "\nPlease select from given options only";
            else additionalMessage = "";
            String message = "Cannot cast " + nextLine + " to type " + typeSimpleName + additionalMessage;
            throw new CastException(message);
        }

    }

    public <T> void printEnterPropertyMessage(String propertyName, List<T> options) {
        if(options != null && options.size() > 0) {
            console.print("Select your " + propertyName + " from the following list");
            console.print(options.toString());
        }
        else console.print("Enter " + propertyName + ":");
    }

    public void printResult(List<Score> result) {
        console.print("-------------------------------------------------------------------------------------------");
        console.print("Matched users are:");
        result.forEach(
                r -> {
                    console.print(r.getUser().getFullName() + ": " + r.getScore());
                    console.print(r.getUser().toString());
                    console.print("\n");
                }
        );
    }
}
