package utility;

public class CreateURL {

	public final static String baseURI = ConfigReader.getProperty("baseurl");
	
	public static String getBaseURI() {
		return baseURI;
	}
	
	public static String getBaseURI(String resourcePath) {
		return baseURI + resourcePath;
	}
}
