package design_patterns.creational.factory;

public abstract class CrunchfiyCompany {
    public abstract String getPhoneNumber();

    public abstract String getZipCode();

    @Override
    public String toString() {
        return "Phone #= " + this.getPhoneNumber() + ", Zip Code= " + this.getZipCode();
    }
}
