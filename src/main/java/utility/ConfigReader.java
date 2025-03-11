package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getEndpoint(String endpointKey, String... pathParams) {
        String endpoint = properties.getProperty(endpointKey);
        if (pathParams.length > 0) {
            for (String param : pathParams) {
                endpoint = endpoint.replaceFirst("\\{.*?}", param);
            }
        }
        return getProperty("base.url") + endpoint;
    }
    
    public static void main(String[] args) {
		
		Dotenv dotenv = Dotenv.load();
		System.out.println(dotenv.get("API_TOKEN"));
		System.out.println(dotenv.get("API_KEY"));
	}
}
