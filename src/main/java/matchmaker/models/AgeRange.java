package matchmaker.models;

public class AgeRange {
    private final int lowerAge;
    private final int upperAge;

    public AgeRange(int lowerAge, int upperAge) {
        this.lowerAge = lowerAge;
        this.upperAge = upperAge;
    }

    public boolean checkRange(int age) {
        return age >= this.lowerAge && age <= this.upperAge;
    }

    @Override
    public String toString() {
        return "AgeRange{" +
                "lowerAge=" + lowerAge +
                ", upperAge=" + upperAge +
                '}';
    }
}
