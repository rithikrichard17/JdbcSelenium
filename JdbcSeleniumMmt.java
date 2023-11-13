package seleniummakemytrip;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcSeleniumMmt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/hotels/");
		
        Thread.sleep(3000);
		
		driver.findElement(By.className("commonModal__close")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("hsw_search_button")).click();
		
		Thread.sleep(3000);
		
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("./Screenshotmmt/JdbcSeleniumMakemytrip.png");
		
		FileUtils.copyFile(srcFile,destFile);
		
		driver.findElement(By.id("htl_id_seo_20080802125928557")).click();
		
		String title = driver.getTitle();
		
		String currenturl = driver.getCurrentUrl();
		
		System.out.println(title);
				
		System.out.println(currenturl);
		
		String dburl = "jdbc:mysql://localhost:3306/itinerary";
		
		String username = "root";
		
		String password = "1234";
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	   
	Connection con = DriverManager.getConnection(dburl,username,password);
	
	System.out.print("successfully connected");
	
	String Name = "Maga";
	
	String Age = "50";
	
	String Destination = "London";
	
	PreparedStatement ps = con.prepareStatement("insert into travel values(?,?,?)");
	
	ps.setString(1,Name);
	
	ps.setString(2,Age);
	
	ps.setString(3,Destination);
	
	ps.executeUpdate();
	
	con.close();
		
		

	}

}
