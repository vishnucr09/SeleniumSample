package com.test.sears;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.sears.utils.PropertiesUtil;

public class TestPropertiesDemo {
	
	 public Properties properties = new Properties();
	 
	 File testPropertiesFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" 
			 + File.separator + "resources" + File.separator + "test.properties");
			 
	 public void loadProperties(){
		 try {
			properties.load(new FileInputStream(testPropertiesFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public String getProperty(){
		 String url = properties.getProperty("sears.homepage.url");
		 return url;
	 }
	 
	 @Test
	 public void runTest(){
		 TestPropertiesDemo d = new TestPropertiesDemo();
		 d.loadProperties();
		 String url = d.getProperty();
		 System.out.println(url);
		 System.out.println(PropertiesUtil.getProperty("Browser"));
	 }


}
