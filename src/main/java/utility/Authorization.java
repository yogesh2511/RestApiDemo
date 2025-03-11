package utility;

import io.github.cdimascio.dotenv.Dotenv;

public class Authorization {
	static Dotenv dotenv = Dotenv.load();
//	public final static String token= ConfigReader.getProperty("token");
//	public final static String key= ConfigReader.getProperty("key");
	
	public final static String token= dotenv.get("API_TOKEN");
	public final static String key= dotenv.get("API_KEY");
	
	public String getToken() {
		return token;
	}
	
	public String getKey() {
		return key;
	}
}
