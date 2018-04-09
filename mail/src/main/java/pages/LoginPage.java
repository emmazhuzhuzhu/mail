package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Action;



public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--kiosk");
		//chromeOption.addEncodedExtensions("AdBlock_v3.10.0.crx");
		//((Object) chromeOption).add_extension("AdBlock_v3.10.0.crx")；
		//chromeOption.addArguments("allow-outdated-plugins");
		
		WebDriver driver = new ChromeDriver(chromeOption);
		
		driver.get("http://www.163.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//鼠标悬停在邮箱按钮上
		WebElement loginBtn = driver.findElement(By.className("ntes-nav-login-title"));
		Actions action = new Actions(driver);
		action.moveToElement(loginBtn).perform();
		action.moveToElement(driver.findElement(By.id("js_N_login_wrap"))).perform();

		//切换到登录frame
		//WebElement loginFrame = driver.findElement(By.id("x-URS-iframe"));
		//WebElement loginFrame = driver.findElement(By.xpath("//iframe[contains(@id,'x-URS-iframe'"));
		//WebElement loginFrame = driver.findElement(By.xpath("//iframe[statrs-with(@id,'x-URS-iframe'"));
		//WebElement loginFrame = driver.findElement(By.xpath("//div[@id='js_N_login_wrap']/iframe"));
		//WebElement loginFrame = driver.findElement(By.xpath("//div[@id='js_N_login_wrap']/iframe[contains(@src,'http://webzj.reg.163.com')]"));
		//WebElement loginFrame = driver.findElement(By.xpath("//div[@id='js_N_login_wrap']/child"));
		//driver.switchTo().frame("x-URS-iframe");
		//WebElement loginFrame = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div[2]/div[1]/div[1]/div/iframe")); 
		//WebElement loginFrame = driver.findElement(By.xpath("//*[contains(@src,'http://webzj.reg.163.com')]"));	
		//Thread.sleep(3000);
		WebElement loginFrame = driver.findElement(By.xpath("//iframe[contains(@src,'http://webzj.reg.163.com/v1.0.1/pub/index_dl')]")); 
		
		driver.switchTo().frame(loginFrame);
		Thread.sleep(5000);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa----------------------");
	
		//输入用户名密码，点击登录 	
		WebElement userName = driver.findElement(By.name("email"));
		userName.sendKeys("juanhdk@163.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("625777");
		WebElement login = driver.findElement(By.id("dologin"));
		login.click();
		
		//切换到default frame
		driver.switchTo().defaultContent();
		//System.out.print("url1="+driver.getCurrentUrl());
		//action.moveToElement(driver.findElement(By.id("js_N_login_wrap"))).perform();
		//action.moveToElement(driver.findElement(By.id("js_N_navUsername"))).perform();  
		//action.moveToElement(driver.findElement(By.id("js_login_suggest_wrap"))).perform(); 
		//action.moveToElement(driver.findElement(By.xpath(".//*[@id='js_logined_suggest']/li[2]/a/span"))).perform(); 
		//action.moveToElement(driver.findElement(By.id("js_logined_suggest"))).perform(); 
		//driver.findElement(By.id("js_logined_suggest"));
		//driver.findElement(By.linkText("juanhdk@163.com"));
		//driver.findElement(By.linkText("我的邮箱")).click();
		//action.moveToElement(driver.findElement(By.className("ntes-nav-select-arr"))).perform();
		
		Thread.sleep(5000);
		//driver.findElement(By.id("js_N_navLoginAfter")).click();
		//鼠标悬停在邮箱账号上面
		action.moveToElement(driver.findElement(By.id("js_N_navUsername"))).perform();
		// unable to locate element --- driver.findElement(By.linkText("我的邮箱")).click();
		
		Thread.sleep(5000);
		
		//鼠标悬停在下拉列表ul上面
		action.moveToElement(driver.findElement(By.id("js_logined_suggest"))).perform();
		//这个步骤很重要，action 的 moveToElement 是鼠标一闪而过的，这一句代码执行完了，鼠标就不在元素上面了，所以要悬停到要点击的元素上，再点击
		action.moveToElement(driver.findElement(By.xpath("//*[@id='js_logined_suggest']/li[2]/a"))).perform();
		//这个不行，文字是在span里，不是在a标签里 driver.findElement(By.linkText("我的邮箱"));
		driver.findElement(By.xpath("//*[@id='js_logined_suggest']/li[2]/a")).click();
		// 这个可以找到 driver.findElement(By.xpath("//*[@id='js_logined_suggest']/li[2]/a/span[text()='我的邮箱']")).click();
		//Thread.sleep(10000);
		//点击写信按钮
		
		//driver.findElement(By.xpath("//div[@id='dvNavTop']/ul/li[2]/span[2]")).click();
		//切换到新连接
		
		//System.out.print("url2="+driver.getCurrentUrl());
	//	driver.switchTo().window(driver.getWindowHandle());
		//driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);

		String currentWindow = driver.getWindowHandle();
		System.out.println("currentWinddow is:"+currentWindow);
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles){
			if(!currentWindow.equals(handle)){
				driver.switchTo().window(handle);
				System.out.println("handle is:"+handle);
				break;
			}
			
		}
		//iterator
//		Iterator<String> it = handles.iterator();
//		while(it.hasNext()){
//			 String handle = it.next();  
			// if(currentWindow.equals(handle)) continue; 
//			driver.switchTo().window(it.next());
//		}
		
		
		//点击写信按钮
		driver.findElement(By.xpath("//div[@id='dvNavTop']/ul/li[2]/span[2]")).click();
		//输入收件人邮箱
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("juanhdk@163.com");
		//输入主题
		driver.findElement(By.xpath("//input[contains(@id,'_subjectInput')]")).sendKeys("测试邮件");
		//切换到邮件正文的iframe
		driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
		//输入邮件内容
		driver.findElement(By.xpath("//body[@class='nui-scroll' and @contenteditable='true']")).sendKeys("这是一个自动化测试邮件");
		//driver.find_element_by_xpath("//body[@class='nui-scroll' and @contenteditable='true']").send_keys(u'这是一个自动化测试邮件')
		driver.switchTo().defaultContent();
		//点击发送按钮
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='nui-toolbar-item']/div/span[2]")).click();
		
	}



}
