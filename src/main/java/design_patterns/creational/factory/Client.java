package design_patterns.creational.factory;

public class Client {
    public static void main(String[] args) {
        CrunchfiyCompany eBay = Factory.getDetails("Ebay", "408.123.4567", "98765");
        CrunchfiyCompany google = Factory.getDetails("Google", "519.123.4567", "56789");
        System.out.println("Factory eBay Config::" + eBay);
        System.out.println("Factory Google Config::" + google);

        DecodedImage decodedImage;
        ImageReader giffImageReader = Factory.getImageReader("giff", "a giff image");
        assert giffImageReader != null;
        decodedImage = giffImageReader.getDecodeImage();
        System.out.println(decodedImage);
        ImageReader jpegImageReader = Factory.getImageReader("jpeg", "a jpeg image");
        assert jpegImageReader != null;
        decodedImage = jpegImageReader.getDecodeImage();
        System.out.println(decodedImage);
    }
}
