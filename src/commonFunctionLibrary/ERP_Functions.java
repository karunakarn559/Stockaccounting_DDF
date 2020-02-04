package commonFunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ERP_Functions {
	WebDriver driver;
	String res;
	
	public String launchAPP(String url)throws Throwable{
		String res="";
		
		System.setProperty("webdriver.chrome.driver","D:\\Karunakar\\Stockaccounting_DDF\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	if(driver.findElement(By.id("btnsubmit")).isDisplayed()){
			res="Pass";
		}
		else{
			res="Fail";
		}
	return res;
	}
	
    public String login(String username,String password) throws Throwable {
    	
    	driver.findElement(By.id("username")).clear();
    	driver.findElement(By.id("username")).sendKeys(username);
    	driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("btnsubmit")).click();
	    Thread.sleep(5000);
	    
	    if(driver.findElement(By.id("logout")).isDisplayed()){
	    	res="Pass";
	    }else{
	    	res="Fail";
	    }
	    return res;  
}
    public String supplier(String sname,String address,String city,String country,String cperson,String pnumber,String email,String mnumber,String notes ) throws Throwable{
    	driver.findElement(By.linkText("Suppliers")).click();
    	driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
    	String expdata= driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
    	driver.findElement(By.id("x_Supplier_Name")).sendKeys(sname);
    	driver.findElement(By.id("x_Address")).sendKeys(address);
    	driver.findElement(By.id("x_City")).sendKeys(city);
    	driver.findElement(By.id("x_Country")).sendKeys(country);
    	driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
    	driver.findElement(By.id("x_Phone_Number")).sendKeys(pnumber);
    	driver.findElement(By.id("x__Email")).sendKeys(email);
    	driver.findElement(By.id("x_Mobile_Number")).sendKeys(mnumber);
    	driver.findElement(By.id("x_Notes")).sendKeys(notes);
    	driver.findElement(By.id("btnAction")).sendKeys(Keys.ENTER);
    	Thread.sleep(5000);
    	
    	driver.findElement(By.xpath("//button[text()='OK!']")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
    	
    	driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button/span")).click();
    	driver.findElement(By.id("psearch")).sendKeys(expdata);
    	driver.findElement(By.id("btnsubmit")).click();
    	if(driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
		{
			driver.findElement(By.id("psearch")).clear();
			driver.findElement(By.id("psearch")).sendKeys(expdata);
			driver.findElement(By.xpath("//*[@id='btnsubmit']")).click();
		}
		else{
			//click on search panel
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search ewIcon']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).clear();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(expdata);
		driver.findElement(By.xpath("//*[@id='btnsubmit']")).click();
		}
		
		
		
		String actdata=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
		
		if(expdata.equals(actdata)){
			res="pass";
		}else{
			res="fail";
		}
		
		return res;
	
	}
public String logout() throws Exception{
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='OK!']")).click();
		
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed()){
			res="pass";
		}else{
			res="fail";
		}
		
		return res;
	}
	
	public void closebrw()
	{
		driver.close();
	}
    }

