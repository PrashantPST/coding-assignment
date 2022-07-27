package design_patterns.creational.factory;

public class CrunchifyGoogle extends CrunchfiyCompany {

    private final String phoneNumber;
    private final String zipCode;

    public CrunchifyGoogle(String phoneNumber, String zipCode) {
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getZipCode() {
        return this.zipCode;
    }
}
