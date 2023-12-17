
// No setters, since a license plate should be immutable
public class LicensePlate {

    private String regionalCode;
    private String letters;
    private int digits;









    public LicensePlate(String regionalCode, String letters, int digits) {
        this.regionalCode = regionalCode;
        this.letters = letters;
        this.digits = digits;
    }










    public boolean isEqual(LicensePlate other) {
        return regionalCode.equals(other.regionalCode) && letters.equals(other.letters)
                && digits == other.digits;
    }























    public String toString() {
        return regionalCode + ":" + letters + " " + digits;
    }






    public String getRegionalCode() {
        return regionalCode;
    }

    public String getLetters() {
        return letters;
    }

    public int getDigits() {
        return digits;
    }
}
