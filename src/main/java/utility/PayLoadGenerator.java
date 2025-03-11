package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoadGenerator {

	public static String generateStringPayload(String fileName) throws IOException{
		String filepath = System.getProperty("user.dir")+ "\\RestAssuuredFramework\\src\\main\\java\\resources"+ fileName;
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
}
