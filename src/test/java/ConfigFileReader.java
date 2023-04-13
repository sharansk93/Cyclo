import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigFileReader {
	public String getReportConfigPath() throws FileNotFoundException{
		File a = new File("C:\\\\Users\\\\VDI007\\\\eclipse-workspace\\\\Cyclo\\\\config\\\\cofiguration.properties");
		FileInputStream f=new FileInputStream(a);
		Properties p =new Properties();
		String reportConfigPath = p.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

}
