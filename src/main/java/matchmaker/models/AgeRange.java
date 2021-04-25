package matchmaker.models;

public class AgeRange {
    private int lowerAge;
    private int upperAge;

    public AgeRange(int lowerAge, int upperAge) {
        this.lowerAge = lowerAge;
        this.upperAge = upperAge;
    }

    public int getLowerAge() {
        return lowerAge;
    }

    public void setLowerAge(int lowerAge) {
        this.lowerAge = lowerAge;
    }

    public int getUpperAge() {
        return upperAge;
    }

    public void setUpperAge(int upperAge) {
        this.upperAge = upperAge;
    }

    public boolean checkRange(int age) {
        return age >= this.lowerAge && age <= this.upperAge;
    }
}
