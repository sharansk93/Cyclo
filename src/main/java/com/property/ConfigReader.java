package com.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static void main(String[] args) throws IOException {
		File a = new File("C:\\Users\\VDI007\\eclipse-workspace\\Cyclo\\src\\main\\java\\com\\property\\cyclo.properties");
		FileInputStream f=new FileInputStream(a);
		Properties p =new Properties();
		p.load(f);
		String property = p.getProperty("base");
		System.out.println(property);
	}

}
