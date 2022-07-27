package design_patterns.creational.factory;

public abstract class Factory {
    public static CrunchfiyCompany getDetails(String type, String phoneNumber, String zipCode) {
        if ("Ebay".equalsIgnoreCase(type)) {
            return new CrunchifyEbay(phoneNumber, zipCode);
        }
        else if ("Google".equalsIgnoreCase(type)) {
            return new CrunchifyGoogle(phoneNumber, zipCode);
        }

        return null;
    }

    public static ImageReader getImageReader(String imageType, String image) {
        if (imageType.equals("giff")) {
            return new GifReader(image);
        }
        else if (imageType.equals("jpeg")) {
            return new JpegReader(image);
        }
        return null;
    }

}
