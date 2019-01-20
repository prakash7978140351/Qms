package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil 
{
public static String getValueForKey(String key) throws Exception, IOException
{
	Properties ConfigProperties=new Properties();
	ConfigProperties.load(new FileInputStream(new File("./PropertiesFile/Enviornment.properties")));
	return ConfigProperties.getProperty(key);
}
	
	
}
