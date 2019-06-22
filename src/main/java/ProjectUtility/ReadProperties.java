package ProjectUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	static String value = null;
	
	public static String getValue(String key) throws FileNotFoundException, IOException {
	Properties props = new Properties();
	String path = System.getProperty("user.dir");
	
			props.load(new FileInputStream(path+"\\config\\" + "data.properties"));	
			value = props.getProperty(key);
			return value;
}
}