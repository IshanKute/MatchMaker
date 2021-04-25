package matchmaker.util;

import matchmaker.exceptions.CastException;
import matchmaker.models.*;

import java.util.List;

public class Util {
    public Util() {}

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
            print("Select your " + propertyName + " from the following list");
            print(options.toString());
        }
        else print("Enter " + propertyName + ":");
    }

    public void printResult(List<Score> result) {
        print("-------------------------------------------------------------------------------------------");
        print("Matched users are:");
        result.forEach(
                r -> {
                    print(r.getUser().getFullName() + ": " + r.getScore());
                    print(r.getUser().toString());
                    print("\n");
                }
        );
    }

    public void print(String s){
        System.out.println(s);
    }
}
